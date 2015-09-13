import org.jibble.pircbot.*;

public class betsyroMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        betsyro bot = new betsyro();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        // Join the #pircbot channel.
        bot.joinChannel("#ppl");
        
    }
    
}
