package com.xing.cli.pattern;

/**
 * 遥控器类（作用是接收客户端的命令并执行）
 */
public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
