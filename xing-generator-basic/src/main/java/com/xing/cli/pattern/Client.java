package com.xing.cli.pattern;

/**
 * 客户端类（创建命令对象并与接收者关联（绑定设备），然后将命令对象传递给调用者(按遥控器)，从而触发执行）
 */
public class Client {
    public static void main(String[] args) {

        //创建设备（接受者对象）
        Device sony = new Device("索尼");
        Device tcl = new Device("TCL");

        //创建具体命令，绑定不同设备
        TurnOnCommand turnOnCommand = new TurnOnCommand(sony);
        TurnOffCommand turnOffCommand = new TurnOffCommand(tcl);

        //创建调用者
        RemoteControl remoteControl = new RemoteControl();

        //执行命令
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();

    }
}
