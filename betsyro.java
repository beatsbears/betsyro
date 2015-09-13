// betsyro.java

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class betsyro extends PircBot {
    
    public betsyro() {
        this.setName("betsyro");
    }

    String[] badwords = new String[]{"shit", "poop", "ass","anal",
				     "anus",
				     "arse",
				     "ass",
				     "ballsack",
				     "balls",
				     "bastard",
				     "bitch",
				     "biatch",
				     "bloody",
				     "blowjob",
				     "blow job",
				     "bollock",
				     "bollok",
				     "boner",
				     "boob",
				     "bugger",
				     "bum",
				     "butt",
				     "buttplug",
				     "clitoris",
				     "cock",
				     "coon",
				     "crap",
				     "cunt",
				     "damn",
				     "dick",
				     "dildo",
				     "dyke",
				     "fag",
				     "feck",
				     "fellate",
				     "fellatio",
				     "felching",
				     "fuck",
				     "f u c k",
				     "fudgepacker",
				     "fudge packer",
				     "flange",
				     "Goddamn",
				     "God damn",
				     "hell",
				     "homo",
				     "jerk",
				     "jizz",
				     "knobend",
				     "knob end",
				     "labia",
				     "lmao",
				     "lmfao",
				     "muff",
				     "nigger",
				     "nigga",
				     "omg",
				     "penis",
				     "piss",
				     "poop",
				     "prick",
				     "pube",
				     "pussy",
				     "queer",
				     "scrotum",
				     "sex",
				     "shit",
				     "s hit",
				     "sh1t",
				     "slut",
				     "smegma",
				     "spunk",
				     "tit",
				     "tosser",
				     "turd",
				     "twat",
				     "vagina",
				     "wank",
				     "whore",
				     "wtf"};
    
    public void onMessage(String channel, String sender,
			  String login, String hostname, String message) {

        if (message.equalsIgnoreCase("What time is it?")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }

	if (message.equalsIgnoreCase("Who is the mayor?")) {
            String time = new java.util.Date().toString();
	    sendMessage(channel, sender + ": Michael F. Brennan");
	}
  

	if (message.equalsIgnoreCase("What is the city managers email address?")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": citymanager@portlandmaine.gov.");
        }

        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }

        if (message.toLowerCase().contains("mayor?")) {
            sendMessage(channel, sender + ": Michael F. Brennan ");
        }

	if (message.toLowerCase().contains("governor?")) {
            sendMessage(channel, sender + ": Paul Richard LePage ");
        }

        if (message.toLowerCase().contains("news")) {
            sendMessage(channel, sender + ": Here's some recent local news, http://www.portlandmaine.gov/CivicAlerts.aspx?CID=1,24,16,7,56,9,15,13,34,27,30,18,17,11,19,31,5,58,22,61,40,53,43,44,37,59,42,21,25,35,46,49");
        }

        if (message.toLowerCase().contains("notes")) {
            sendMessage(channel, sender + ": If you would like meeting notes please respond with 'meeting notes'dd/mm/yyyy' ");
        }

        if (message.toLowerCase().contains("bill")) {
            sendMessage(channel, sender + ": You can pay city bills here - https://trx.npspos.com/payapp/public/ECSale.html?siteId=18545&deptId=18545&urlKey=878a55b229b58de23645e5cfa8ec4f6a60469a37 ");
        }

        if (message.toLowerCase().contains("building code")) {
            sendMessage(channel, sender + ": Learn more about Portlands Building codes here - http://www.portlandmaine.gov/DocumentCenter/View/2325 ");
        }

        if (message.toLowerCase().contains("constitution")) {
            sendMessage(channel, sender + ": You can read the US Constitution here - https://portlandlibrary.bibliocommons.com/item/show/1503083077_the_annotated_us_constitution_and_declaration_of_independence ");
        }

        if (Arrays.asList(badwords).contains(message)) {
            sendMessage(channel, sender + ": Please be civil. ");
        }
    }
}
