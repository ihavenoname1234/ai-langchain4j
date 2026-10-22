package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

import java.util.List;
import java.util.Locale;

public class lotAiService {

    interface GreetingExpert {
        @UserMessage("Is the following text a greeting? Text: {{it}}")
        boolean isGreeting(String text);
    }

    interface ChatBot {
        @SystemMessage("You are a polite chatbot of a company called Miles of Smiles. Use the provided company information when relevant.")
        String reply(String userMessage);
    }

    static class MilesOfSmiles {
        private final GreetingExpert greetingExpert;
        private final ChatBot chatBot;

        MilesOfSmiles(GreetingExpert greetingExpert, ChatBot chatBot) {
            this.greetingExpert = greetingExpert;
            this.chatBot = chatBot;
        }

        public String handle(String userMessage) {
            if (greetingExpert.isGreeting(userMessage)) {
                return "Greetings from Miles of Smiles! How can I make your day better?";
            }
            return chatBot.reply(userMessage);
        }
    }

    private static ContentRetriever createMilesOfSmilesContentRetriever() {
        List<KnowledgeEntry> knowledgeBase = List.of(
                new KnowledgeEntry(
                        List.of("hour", "open", "close", "营业", "时间"),
                        "Miles of Smiles customer support is available Monday to Friday, 9:00 AM to 5:00 PM."),
                new KnowledgeEntry(
                        List.of("return", "refund", "exchange", "退货", "退款"),
                        "Customers can request a return or exchange within 30 days of purchase. Contact support with your order number."),
                new KnowledgeEntry(
                        List.of("contact", "phone", "email", "联系", "客服"),
                        "You can contact Miles of Smiles customer support by email at support@milesofsmiles.example."),
                new KnowledgeEntry(
                        List.of("company", "miles of smiles", "公司"),
                        "Miles of Smiles is a customer-focused company. Our support team can help with orders, returns, and product questions.")
        );

        return query -> {
            String queryText = query.text().toLowerCase(Locale.ROOT);
            List<Content> matches = knowledgeBase.stream()
                    .filter(entry -> entry.keywords().stream()
                            .anyMatch(keyword -> queryText.contains(keyword.toLowerCase(Locale.ROOT))))
                    .map(entry -> Content.from(entry.text()))
                    .toList();

            return matches.isEmpty()
                    ? List.of(Content.from(knowledgeBase.get(3).text()))
                    : matches;
        };
    }

    private record KnowledgeEntry(List<String> keywords, String text) {
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DASHSCOPE_API_KEY environment variable before running this example.");
        }

        QwenChatModel cheapModel = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-turbo")
                .build();
        QwenChatModel strongModel = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-plus")
                .build();

        GreetingExpert greetingExpert = AiServices.create(GreetingExpert.class, cheapModel);
        ChatBot chatBot = AiServices.builder(ChatBot.class)
                .chatModel(strongModel)
                .contentRetriever(createMilesOfSmilesContentRetriever())
                .build();

        MilesOfSmiles milesOfSmiles = new MilesOfSmiles(greetingExpert, chatBot);
        System.out.println(milesOfSmiles.handle("What are your opening hours?"));
    }
}
