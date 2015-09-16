# betsyro
A software solution for online civil discourse and civic engagement.

# java
To install on GNU/Linux and Mac OS X

1. Install the lastest Java SDK
2. Download PircBot: http://www.jibble.org/files/pircbot-1.5.0.zip
3. Decompress the PircBot file
4. Copy the betsyro.java file to the decompressed PircBot directory
5. Copy the betsyroMain.java file to the decompressed PircBot directory
6. From the PircBot directory run ./compile-betsyro.sh
7. From the PircBot directory Run ./run-betsyro.sh

# jython
1. Install the lastest Java SDK
2. Install Python 2.7
3. Install Jython 2.7.0
4. From the /jython directory run "jython betsyro.py -l ./badwordlist.txt"
5. Success!


Note: Only .py files that compile and run in jython are accepted. All .py files should run in both python and jython