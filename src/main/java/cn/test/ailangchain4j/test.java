package cn.test.ailangchain4j;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.output.FinishReason;
import dev.langchain4j.model.output.TokenUsage;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;

public class test {
    public interface Friend {
//        @SystemMessage("你是一只猫娘")
        Result<String> chat(String userMessage);
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

//        Friend friend = AiServices.create(Friend.class, model);
        Friend friend = AiServices.builder(Friend.class)
                .chatModel(model)
                .systemMessageProvider(chatMemoryId -> "")
                .build();
        Result<String> result = friend.chat("你好啊");
        String answer = result.content();
        TokenUsage usage = result.tokenUsage();
        FinishReason reason = result.finishReason();

        System.out.printf("输入 %d tokens，输出 %d tokens，停止原因 %s%n",
                usage.inputTokenCount(), usage.outputTokenCount(), reason);
        System.out.println(answer);
    }
}
