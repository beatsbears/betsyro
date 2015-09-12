// betsyro.java

// Betsyro is a software solution for online civil discourse and civic 
// engagement. It aims to empower those that are unable to be physically present
// at a political venue or otherwise participate in the democratic process.

import java.io.*;
import java.net.*;

public class betsyro {

  public static void main(String[] args) throws Exception {

  // Define the channel string
  String channel = "#ppl";

  // Define the line string
  String line = null;

  // Define the login string
  String login = "betsyro";

  // Define the nick string
  String nick = "betsyro";

  // Define the server string
  String server = "irc.freenode.net";

  // Define the socket
  Socket socket = new Socket(server, 6667);
  
  // Define the buffered writer
  BufferedWriter writer = new BufferedWriter(
                          new OutputStreamWriter(socket.getOutputStream()));
  
  // Define the buffered reader
  BufferedReader reader = new BufferedReader(
                          new InputStreamReader(socket.getInputStream()));

  // Write nick stream to the IRC server
  writer.write("NICK " + nick + "\r\n");

  // Write user login stream to the IRC server
  writer.write("USER " + login + " 8 * : Betsy Rossbot \r\n");

  // Flush the writer buffer
  writer.flush();

  // Read the IRC server response to the user login stream write and break from
  // the loop if the nickname is not in use; otherwise tell the user that the
  // nickname is already in use
  while((line = reader.readLine()) != null) {
      if(line.indexOf("004") >= 0) {
        break;
      }
    
      else if(line.indexOf("433") >= 0) {
        System.out.println("Nickname is already in use.");
        
        return;
      }
  }

  // Write join channel stream to IRC server
  writer.write("JOIN " + channel + "\r\n");
  
  writer.flush();

  // Read ping stream from the IRC server; write stream pong and private message
  // the channel about being pinged
  while ((line = reader.readLine()) != null) {
      if(line.toLowerCase().startsWith("PING ")) {
        writer.write("PONG " + line.substring(5) + "\r\n");
        
        writer.write("PRIVMSG" + channel + " :I got pinged!\r\n");
        
        writer.flush();
      }
      
      else {
        System.out.println(line);
      }
    }
  }
}
