package cn.test.ailangchain4j;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.output.structured.Description;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;

public class structuredOutput {

    @Description("一只猫娘")
    record Catgirl(
            @Description("名字") String name,
            @Description("年龄，单位为岁") Integer age,
            @Description("身高，单位为厘米") Double height,
            @Description("毛发颜色") String hair,
            @Description("瞳色") String eyes
        ){
    }

    interface CatgirlExtractor {
        @UserMessage("从以下文本提取猫娘信息，并只返回包含 name、age、height、hair,eyes 字段的 JSON。"
                + "height 的单位为厘米；文本未提供的信息用 null，不要猜测。文本：{{it}}")
        Catgirl extractCatgirlFrom(String text);
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("DASHSCOPE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set the DASHSCOPE_API_KEY environment variable before running this example.");
        }

        QwenChatModel chatModel = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-plus")
                .build();

        CatgirlExtractor catgirlExtractor = AiServices.create(CatgirlExtractor.class, chatModel);
        String text = "克喵喵是一只年龄14岁身高148cm,白毛红瞳的猫娘小萝莉";
        Catgirl catgirl = catgirlExtractor.extractCatgirlFrom(text);
        System.out.println(catgirl);
    }
}
