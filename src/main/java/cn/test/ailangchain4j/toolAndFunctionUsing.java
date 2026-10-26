package cn.test.ailangchain4j;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.tool.ToolArgumentsErrorHandler;
import dev.langchain4j.service.tool.ToolExecutionErrorHandler;

public class toolAndFunctionUsing {
    public interface Assistant {
        String chat(String userMessage);
    }

    public static class Calculator {
        @Tool("Sums 2 given numbers")
        double sum(double a, double b) {
            if (Double.isNaN(a) || Double.isNaN(b)) {
                throw new IllegalArgumentException("参数必须是有效数字");
            }
            return a + b;
        }

        @Tool("Returns a square root of a given number")
        double squareRoot(double x) {
            if (Double.isNaN(x) || x < 0) {
                throw new IllegalArgumentException("平方根参数必须是非负数");
            }
            return Math.sqrt(x);
        }
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("api配置出错");
        }

        QwenChatModel chatModel = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-plus")
                .build();

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .tools(new Calculator())
                .toolArgumentsErrorHandler(ToolArgumentsErrorHandler.failInvocation())
                .toolExecutionErrorHandler(ToolExecutionErrorHandler.sendExceptionMessageToLlm())
                .build();

        String answer1 = assistant.chat("1 + 3 = ?");
        System.out.println(answer1);
    }
}
