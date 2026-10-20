package cn.test.ailangchain4j;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AiLangchain4jApplication {

    public interface ChatModel {

        String chat(String userMessage);

        ChatResponse chat(ChatMessage... messages);

        ChatResponse chat(List<ChatMessage> messages);
        
    }


    public static void main(String[] args) {
        SpringApplication.run(AiLangchain4jApplication.class, args);

        String apiKey = System.getenv("DEEPSEEK_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DEEPSEEK_API_KEY environment variable before running this example.");
        }
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey(apiKey)
                .modelName("deepseek-chat")
                .build();
//        String answer = model.chat("请模仿一只猫娘");
//        System.out.println(answer);

        UserMessage firstUserMessage = UserMessage.from("你好啊,请模仿科比布莱恩特");

        AiMessage firstAiMessage = model.chat(firstUserMessage).aiMessage();

        System.out.println(firstAiMessage.text());

        System.out.println("===================");

        List<ChatMessage> messageHistory = new ArrayList<>();
        messageHistory.add(firstUserMessage);
        messageHistory.add(firstAiMessage);

        Scanner scanner = new Scanner(System.in);

        for(int i=0;i>=0;i++){

            String iMessage = scanner.nextLine();

            if(iMessage.isEmpty()){
                break;
            }
            else {
                UserMessage secondUserMessage = UserMessage.from(iMessage);

                messageHistory.add(secondUserMessage);

                AiMessage iAiMessage = model.chat(messageHistory).aiMessage();

                messageHistory.add(iAiMessage);

                System.out.println(iAiMessage.text());

                System.out.println("===================");
            }
        }



//        UserMessage secondUserMessage = UserMessage.from("晚上好");
//
//        AiMessage secondAiMessage = model.chat(firstUserMessage, firstAiMessage, secondUserMessage).aiMessage(); // Klaus
//
//        System.out.println(secondAiMessage.text());
//        String answer2 = model.chat("晚上好");
//        System.out.println(answer2);
    }
}
