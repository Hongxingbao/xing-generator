package com.xing.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.xing.model.MainTemplateConfig;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

/**
 * config子命令：查看参数信息
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //jdk原生反射
        Class<MainTemplateConfig> mainTemplateConfigClass = MainTemplateConfig.class;
        Field[] fields = mainTemplateConfigClass.getDeclaredFields();
        //huTool反射工具类
        // Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称"+field.getName());
            System.out.println("字段类型"+field.getType());
        }
        return 0;
    }
}
