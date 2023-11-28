package com.xing.cli.pattern;
/**
 * 遥控器的某个具体按钮（具体命令是命令接口的实现类，负责将请求传递给接收者（设备），并执行具体的操作）
 */
public class TurnOffCommand implements Command{

    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
