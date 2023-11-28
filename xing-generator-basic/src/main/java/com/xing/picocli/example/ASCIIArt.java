package com.xing.picocli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// some exports omitted for the sake of brevity

@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true) 
public class ASCIIArt implements Runnable { 

    @Option(names = { "-s", "--font-size" }, description = "Font size") 
    int fontSize = 19;

    @Option(names = {"-o","-option"})
    String[] values = {"haha"};

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
               description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" }; 

    @Override
    public void run() { 
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
        System.out.println("fontSize:"+fontSize);
        System.out.println("words:"+String.join(",",words));
        System.out.println("values:"+String.join(",",values));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute("-s","50","-option","111","-option","222","dd","gaga");
        System.exit(exitCode);
    }
}