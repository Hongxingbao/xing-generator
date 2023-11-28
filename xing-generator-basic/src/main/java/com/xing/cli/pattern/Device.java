package com.xing.cli.pattern;

/**
 * 被遥控的设备（接收者，是最终执行命令的对象，知道如何执行具体的操作）
 */
public class Device {

    private String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOn(){
        System.out.println("打开设备"+name);
    }

    public void turnOff(){
        System.out.println("关闭设备"+name);
    }
}
