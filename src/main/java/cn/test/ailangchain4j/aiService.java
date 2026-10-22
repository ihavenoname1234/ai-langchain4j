package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public class aiService {

    public interface Friend {
        String plainChat(String userMessage);

        String annotatedChat(@UserMessage String userMessage);

        String templateInUserMessage(@UserMessage String userMessage, @V("country") String country);

        @UserMessage("德国的首都是?")
        String fixedPrompt();

        @UserMessage("{{it}}的首都是?")
        String implicitTemplate(String country);

        @UserMessage("{{country}}的首都是?")
        String namedTemplate(@V("country") String country);

        @UserMessage("{{country}}的{{something}}是?")
        String multipleVariables(@V("something") String something, @V("country") String country);
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
        Friend friend = AiServices.create(Friend.class, model);

        System.out.println("plainChat: " + friend.plainChat("你好"));
        System.out.println("annotatedChat: " + friend.annotatedChat("你好啊"));
        System.out.println("templateInUserMessage: "
                + friend.templateInUserMessage(" {{country}}的首都是?", "法国"));
        System.out.println("fixedPrompt: " + friend.fixedPrompt());
        System.out.println("implicitTemplate: " + friend.implicitTemplate("意大利"));
        System.out.println("namedTemplate: " + friend.namedTemplate("日本"));
        System.out.println("multipleVariables: " + friend.multipleVariables("capital", "加拿大"));
    }
}
