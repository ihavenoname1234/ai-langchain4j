package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.output.FinishReason;
import dev.langchain4j.model.output.TokenUsage;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.tool.ToolExecution;

import java.util.List;

public class ResultT {
    interface Assistant {

        @UserMessage("Generate an outline for the article on the following topic: {{it}}")
        Result<List<String>> generateOutlineFor(String topic);
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DASHSCOPE_API_KEY environment variable before running this example.");
        }

        QwenChatModel model = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-plus")
                .build();
        Assistant assistant = AiServices.create(Assistant.class, model);

        Result<List<String>> result = assistant.generateOutlineFor("Java");

        List<String> outline = result.content();
        TokenUsage tokenUsage = result.tokenUsage();
        List<Content> sources = result.sources();
        List<ToolExecution> tools = result.toolExecutions();
        FinishReason finishReason = result.finishReason();

        System.out.println("文章大纲：");
        outline.forEach(item -> System.out.println("- " + item));
        System.out.println("Token 用量：" + tokenUsage);
        System.out.println("检索来源：" + sources);
        System.out.println("工具执行：" + tools);
        System.out.println("停止原因：" + finishReason);
        System.out.println("中间响应：" + result.intermediateResponses());
        System.out.println("最终响应：" + result.finalResponse());
    }

}
