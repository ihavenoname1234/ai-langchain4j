package cn.test.ailangchain4j;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.*;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.output.FinishReason;
import dev.langchain4j.model.output.TokenUsage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String args[]) throws IOException{
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DASHSCOPE_API_KEY environment variable before running this example.");
        }
        //使用qwen模型
        QwenChatModel model = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-plus")
                .build();

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.from("你好"));
        ChatResponse response = model.chat(messages);

        String text = response.aiMessage().text();
        TokenUsage usage = response.metadata().tokenUsage();
        FinishReason reason = response.metadata().finishReason();

        System.out.printf("输入 %d tokens，输出 %d tokens，停止原因 %s%n",usage.inputTokenCount(), usage.outputTokenCount(), reason);
        System.out.println(text);
    }
}
