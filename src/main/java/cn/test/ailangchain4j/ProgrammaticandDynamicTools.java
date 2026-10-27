package cn.test.ailangchain4j;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.ToolExecutionResultMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.request.json.JsonObjectSchema;
import dev.langchain4j.model.chat.request.json.JsonStringSchema;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.memory.ChatMemoryAccess;
import dev.langchain4j.service.tool.*;

import java.util.List;
import java.util.Map;

public class ProgrammaticandDynamicTools {
    private record Booking(String bookingNumber, String guestName, String hotelName) {
    }

    private static final Map<String, Booking> BOOKINGS = Map.of(
            "B-12345", new Booking("B-12345", "张三", "孙二娘酒店"),
                "A-35673",new Booking("A-35673","克喵喵","发福酒店")
    );

    interface Assistant extends ChatMemoryAccess {
        String chat(@MemoryId int memoryId, @UserMessage String message);
        Result<String> chat(String userMessage);
    }
    private static Booking getBooking(String bookingNumber) {
        Booking booking = BOOKINGS.get(bookingNumber);
        if (booking == null) {
            throw new IllegalArgumentException("No booking found for number: " + bookingNumber);
        }
        return booking;
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
        ToolSpecification toolSpecification = ToolSpecification.builder()
                .name("get_booking_details")
                .description("返回预订详情")
                .parameters(JsonObjectSchema.builder()
                        .addProperty("bookingNumber", JsonStringSchema.builder()
                                .description("预订编号，格式为 B-12345")
                                .build())
                        .required("bookingNumber")
                        .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        ToolExecutor toolExecutor = (toolExecutionRequest, memoryId) -> {
            try {
                Map<String, Object> arguments = objectMapper.readValue(
                        toolExecutionRequest.arguments(),
                        new TypeReference<>() {
                        });
                Object bookingNumberArgument = arguments.get("bookingNumber");
                if (!(bookingNumberArgument instanceof String bookingNumber) || bookingNumber.isBlank()) {
                    throw new IllegalArgumentException("bookingNumber must be a non-empty string.");
                }
                return getBooking(bookingNumber).toString();
            } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
                throw new IllegalArgumentException("Invalid tool arguments.", e);
            }
        };
        ToolProvider toolProvider = request -> {
            String message = request.userMessage().singleText();

            if (message.contains("预订") || message.contains("booking")) {
                return ToolProviderResult.builder()
                        .add(toolSpecification, toolExecutor)
                        .build();
            }

            return ToolProviderResult.builder().build();
        };
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(model)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .hallucinatedToolNameStrategy(toolExecutionRequest -> ToolExecutionResultMessage.from(
                        toolExecutionRequest,
                        "Error: there is no tool called " + toolExecutionRequest.name()))
                .toolProvider(toolProvider)
                .toolArgumentsErrorHandler(ToolArgumentsErrorHandler.sendExceptionMessageToLlm())
                .toolExecutionErrorHandler(ToolExecutionErrorHandler.failInvocationUnlessVisibleToLlm())
                .build();
        String answer=assistant.chat(1,"帮我查询预订 A-35673 的详情");
        System.out.println(answer+"\n");
        Result<String> result = assistant.chat("取消我的预订 B-12345");
        String answer2 = result.content();
        List<ToolExecution> toolExecutions = result.toolExecutions();
        System.out.println(answer2);
    }
}
