package com.xing.generator;

import com.xing.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

import static com.xing.generator.DynamicGenerator.doGenerate;
import static com.xing.generator.StaticGenerator.copyFilesByHuTool;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "xing-generator-demo-projects\\acm-template").getAbsolutePath();
        String outputPath = projectPath;
        copyFilesByHuTool(inputPath, outputPath);

        String inputDynamicFilePath  = projectPath + File.separator + "src/main/resources/templates/mainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com/xing/acm/MainTemplate.java";
        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setAuthor("啊星");
        mainTemplateConfig.setOutputText("输出结果是");
        doGenerate(inputDynamicFilePath,outputDynamicFilePath,mainTemplateConfig);
    }
}
