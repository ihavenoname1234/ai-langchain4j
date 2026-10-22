package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.memory.ChatMemoryAccess;

import java.util.List;

public class aiChatMemory {
    interface Assistant extends ChatMemoryAccess{
        String chat(@MemoryId int memoryId, @UserMessage String message);
    }
    public static void main(String[] arg){
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DASHSCOPE_API_KEY environment variable before running this example.");
        }

        QwenChatModel model = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-plus")
                .build();
        Assistant assistant= AiServices.builder(Assistant.class)
                .chatModel(model)
                .chatMemoryProvider(memoryId-> MessageWindowChatMemory.withMaxMessages(10))
                .build();
        String answerToKlaus = assistant.chat(1, "你好，我是孙笑川");
        String answerTo2 = assistant.chat(2, "你好，我的名字叫ko-miaomiao");
        System.out.println(answerToKlaus);
        System.out.println(answerTo2);
        List<ChatMessage> messagesWithKlaus = assistant.getChatMemory(2).messages();
        boolean evicted = assistant.evictChatMemory(2);

    }
}
