import socket
import optparse

print "[+] Gettings set up"
## set up socket stuff and connect
bot_owner = "Bluebot"
nick = "BlueBot"
chan = "#ppl"
sock = socket.socket()
sock.connect(("irc.freenode.net",6667))
sock.send("USER " + nick + " 0 * :" + bot_owner + "\r\n")
sock.send("NICK " + nick + "\r\n")
print '[+] joined ' + chan
## misc setup


###---------------------------------------------------------
## keep a list of badwords to ding users for
parser = optparse.OptionParser('usage: \n --help <show help> \n -l <bad word list>')
parser.add_option('-p', dest='wl', type='string', help='.txt list of bad words')
(options, args) = parser.parse_args()
wordlist_path = options.wl
wordlist = []

if wordlist_path != None:
	print '[+] bad word list found'
	d = open(wordlist_path)
	for line in d.readlines():
		if line != "\n" or line != " ":
			wordlist.append(line.translate(None, '\n'))
else:
	print '[!] no bad word list set'

## keep track of strikes
user_strikes = {}
def strike(user):
	if user in user_strikes:
		user_strikes[user] += 1
	else:
		user_strikes[user] = 1
	if user_strikes[user] > 2:
		## kick them out
		sock.send("PRIVMSG " + user + " :GET OUT!!!.\r\n")


###--------------------------
## main loop, check the channel for messages, respond to pings, etc.
def main():
	print '[+] starting main loop'
	while 1:
		## keep checking for data
		## reset all the vars after each check
		data = sock.recv(512)
		datalen = len(data.split(" "))
		sender = ""
		msg_type = ""
		msg_rcpt = ""
		message = ""

		###----------------------------------------------
		## reply to keep alive pings
		if data[0:4] == "PING":
			sock.send(data.replace("PING", "PONG"))
		if data[0]!=':':
			continue
		if data.split(" ")[1] == "001":
			sock.send("MODE " + nick + " +B\r\n")
			sock.send("JOIN " + chan + "\r\n")


		###-----------------------------------------------
		##split and assign data parts

		## parse out the actual sender
		send_data = data.split(" ")[0]
		send_data = send_data[1:]
		sender = send_data.split('!')[0]

		## mode
		msg_type = data.split(" ")[1]

		## if it exists get the recipient (room or private)
		if datalen > 2:
			msg_rcpt = data.split(" ")[2]

		## get the actual message body	
		if datalen > 3:
			message = (" ".join(data.split(" ")[3:])).lower()[1:]


		###----------------------------------------------

		## Start replying to private messages	
		if msg_type == "PRIVMSG" and msg_rcpt == nick:
			print "message received"
			print message
			if "mayor" in message:
				sock.send("PRIVMSG " + sender + " :Portland's mayor is Michael F. Brennan\r\n")
			elif "governor" in message:
				sock.send("PRIVMSG " + sender + " :Maine's governor is Paul LePage.. Ew\r\n")
			else:
				sock.send("PRIVMSG " + sender + " :Sorry, I don't understand you...yet.\r\n")

		if msg_type == "PRIVMSG" and msg_rcpt == chan:
			print message
			for curse in wordlist:
				if curse in message:
					print "bad word"
					strike(msg_rcpt)
					sock.send("PRIVMSG " + chan + " :" + sender+ " Please be Civil!.\r\n")
					break


if __name__=='__main__':
	main()




	
