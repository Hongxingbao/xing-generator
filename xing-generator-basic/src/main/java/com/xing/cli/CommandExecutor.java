package com.xing.cli;

import com.xing.cli.command.ConfigCommand;
import com.xing.cli.command.GenerateCommand;
import com.xing.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;
@Command(name = "sing",mixinStandardHelpOptions = true)
public class CommandExecutor implements Callable {
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }
    @Override
    public Object call() throws Exception {
        System.out.println("请输入具体命令，或者输入 --help查看命令提示");
        return null;
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer doExecute(String[] args){
        return commandLine.execute(args);
    }

}
