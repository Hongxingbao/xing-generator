package com.xing.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.xing.generator.MainGenerator;
import com.xing.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;
/**
 * generate子命令：生成文件
 */
@Data
@Command(name = "generate", description = "代码生成", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    /**
     * 是否生成循环
     */
    @Option(names = { "-l", "--loop" }, description = "是否循环",arity = "0..1",interactive = true,echo = true)
    private boolean  loop;

    /**
     * 作者注释
     */
    @Option(names = { "-a", "--author" }, description = "请输入作者名",arity = "0..1",interactive = true,echo = true)
    private String author = "啊星";

    /**
     * 输出信息
     */
    @Option(names = { "-o", "--outputText" }, description = "请输入输出信息",arity = "0..1",interactive = true,echo = true)
    private String outputText = "sum = ";

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        System.out.println(mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
