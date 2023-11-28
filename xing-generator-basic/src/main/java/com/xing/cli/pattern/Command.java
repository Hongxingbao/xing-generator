package com.xing.cli.pattern;

/**
 * 定义了遥控器操作按钮的规范，封装了具体的操作
 */
public interface Command {
    void execute();
}
