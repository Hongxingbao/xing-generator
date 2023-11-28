package com.xing.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * list子命令：查看要生成的原始文件列表信息
 */
@Command(name = "list", description = "查看要生成的原始文件列表信息", mixinStandardHelpOptions = true)
public class ListCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "xing-generator-demo-projects\\acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
        return 0;
    }
}
