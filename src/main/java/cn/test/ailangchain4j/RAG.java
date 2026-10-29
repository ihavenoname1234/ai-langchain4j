package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import dev.langchain4j.community.model.dashscope.QwenEmbeddingModel;
import java.util.List;

public class RAG {
    interface Assistant{
        String chat(String userMessage);
    }
    public static void main(String[] args){
        String apiKey=System.getenv("DASHSCOPE_API_KEY");
        if(apiKey==null||apiKey.isBlank())throw new IllegalStateException("api配置错误");
        QwenChatModel chatModel=QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen3.7-flash")
                .build();
        EmbeddingModel embeddingModel=QwenEmbeddingModel.builder()
                .apiKey(apiKey)
                .modelName("text-embedding-v3")
                .build();
        List<Document> documents = List.of(FileSystemDocumentLoader.loadDocument("README.md"));
        ////loadDocuments用于读取目录，读取单个文件应使用 loadDocument()
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .documentSplitter(DocumentSplitters.recursive(1000, 200))
                .build();
        ingestor.ingest(documents);

        Assistant assistant= AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(EmbeddingStoreContentRetriever.builder()
                        .embeddingStore(embeddingStore)
                        .embeddingModel(embeddingModel)
                        .build())
                .build();
        String answer=assistant.chat("请看看该文件");
        System.out.println(answer);
    }

}
