package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenStreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;

import java.util.concurrent.CountDownLatch;

public class streamOutput {

    public static void main(String[] args) {
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DASHSCOPE_API_KEY environment variable before running this example.");
        }

        QwenStreamingChatModel model = QwenStreamingChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen3.7-flash")
                .build();
        CountDownLatch completed = new CountDownLatch(1);

        model.chat("讲个笑话", new StreamingChatResponseHandler() {
            @Override
            public void onPartialResponse(String partialResponse) {
                System.out.print(partialResponse);
            }

            @Override
            public void onCompleteResponse(ChatResponse completeResponse) {
                System.out.println("\n[done] " + completeResponse.metadata().tokenUsage());
                completed.countDown();
            }

            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
                completed.countDown();
            }
        });

        try {
            completed.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for the streaming response.", e);
        }
    }
}
