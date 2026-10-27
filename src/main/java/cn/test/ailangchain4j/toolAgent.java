package cn.test.ailangchain4j;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.tool.ToolArgumentsErrorHandler;
import dev.langchain4j.service.tool.ToolExecutionErrorHandler;

public class toolAgent {
        interface RouterAgent {

            @UserMessage("""
                分析以下用户请求，并将其分类为“法律”、“医疗”或“建筑学”，然后将请求原样转发给作为工具提供的相应专家。
                最后返回您从专家那里收到的答案，不作任何修改。
                用户请求是：'{{it}}'。
            """)
            String askToExpert(String request);
        }

        interface MedicalExpert {
            @UserMessage("你是医学专家。从医学角度分析以下用户请求，并提供最好的可能答案。用户请求是{{it}}。")
            @Tool("一个医学专家")
            String medicalRequest(String request);
        }

        interface LegalExpert {
            @UserMessage("你是法律专家 ... 用户请求是{{it}}.")
            @Tool("一个法律专家")
            String legalRequest(String request);
        }

        interface TechnicalExpert {
            @UserMessage("你是建筑学家 ... 用户请求是{{it}}.")
            @Tool("一个建筑学家")
            String technicalRequest(String request);
        }
        public static void main(String[] args){
            String apiKey=System.getenv("DASHSCOPE_API_KEY");
            if(apiKey==null||apiKey.isBlank())throw new IllegalStateException("api出错");
            QwenChatModel model = QwenChatModel.builder()
                    .apiKey(apiKey)
                    .modelName("qwen-plus")
                    .build();

            MedicalExpert   medicalExpert   = AiServices.builder(MedicalExpert.class).chatModel(model).build();
            LegalExpert     legalExpert     = AiServices.builder(LegalExpert.class).chatModel(model).build();
            TechnicalExpert technicalExpert = AiServices.builder(TechnicalExpert.class).chatModel(model).build();

            RouterAgent routerAgent = AiServices.builder(RouterAgent.class)
                    .chatModel(model)
                    .tools(medicalExpert, legalExpert, technicalExpert)
                    .toolArgumentsErrorHandler(ToolArgumentsErrorHandler.sendExceptionMessageToLlm())
                    .toolExecutionErrorHandler(ToolExecutionErrorHandler.failInvocationUnlessVisibleToLlm())
                    .build();

            String answer = routerAgent.askToExpert("我认为南宋画师李嵩根本不懂建筑，不如我库爹李松伦");
            System.out.println(answer);
        }
}
