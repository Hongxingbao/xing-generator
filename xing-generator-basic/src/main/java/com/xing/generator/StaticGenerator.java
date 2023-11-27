package com.xing.generator;

import cn.hutool.core.io.FileUtil;
import lombok.val;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);//E:\code\xing-generator\xing-generator-demo-projects\acm-template
        File parentFile = new File(projectPath).getParentFile();

        String inputPath = new File(parentFile, "xing-generator-demo-projects\\acm-template").getAbsolutePath();
        //E:\code\xing-generator\xing-generator-demo-projects\acm-template
        String outputPath = projectPath;
        copyFilesByHuTool(inputPath, outputPath);



    }

    /**
     * 利用HuTool工具拷贝目录及其子文件夹
     *
     * @param srcPath
     * @param destPath
     */
    public static void copyFilesByHuTool(String srcPath, String destPath) {
        FileUtil.copy(srcPath, destPath, false);
    }
}
