// betsyroMain.java

// Betsyro is a software solution for online civil discourse and civic 
// engagement. It aims to empower those that are unable to be physically present
// at a political venue or otherwise participate in the democratic process.

// Copyright (C) 2015  Scott C. MacCallum
// scm@linux.com

// Copyright (C) 2015  Andrew Scott
// a.clayton.scott@gmail.com

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see http://www.gnu.org/licenses/.

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
