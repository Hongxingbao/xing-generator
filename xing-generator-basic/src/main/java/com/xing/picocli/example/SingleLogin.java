package com.xing.picocli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
// some exports omitted for the sake of brevity

@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class SingleLogin implements Callable {

    @Option(names = { "-u", "--user" }, description = "用户名",echo = true)
    String username;

    @Option(names = { "-p", "--password" }, description = "请输入密码",arity = "0..1",interactive = true,echo = false)
    String password;

    @Option(names = { "-cp", "--checkPassword" }, description = "请再次输入密码",arity = "0..1",interactive = true,echo = false)
    String checkPassword;


    public static void main(String[] args) {
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        argList.add("-u");
        argList.add("user888");
        //动态检查是否包含 -p 和 -cp 选项，如果不包含，则将它们添加到参数列表中。
        if (!argList.contains("-p")) {
            argList.add("-p");
        }
        if (!argList.contains("-cp")) {
            argList.add("-cp");
        }
        new CommandLine(new SingleLogin()).execute(argList.toArray(new String[0]));
    }

    @Override
    public Object call() throws Exception {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("checkPassword:"+checkPassword);
        return 0;
    }
}