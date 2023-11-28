package com.xing;

import com.xing.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        //args = new String[]{"generate","-a","-l","-o"};
        //args = new String[]{"config"};
        //args = new String[]{"list"};
        CommandExecutor executor = new CommandExecutor();
        executor.doExecute(args);
    }
}
