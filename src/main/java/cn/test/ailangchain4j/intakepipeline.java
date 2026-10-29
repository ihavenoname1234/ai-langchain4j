package cn.test.ailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenEmbeddingModel;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiTokenCountEstimator;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.IngestionResult;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

import java.util.List;

public class intakepipeline {
    public static void main(String[] args){
        String apiKey=System.getenv("DASHSCOPE_API_KEY");
        if(apiKey==null||apiKey.isBlank())throw new IllegalStateException("api is wrong");
        EmbeddingModel embeddingModel= QwenEmbeddingModel.builder()
                .apiKey(apiKey)
                .modelName("text-embedding-v3")
                .build();
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("D://1//Documents");
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()

                // 给每个 Document 打上 userId 标签，便于后续按用户过滤检索范围
                .documentTransformer(document -> {
                    document.metadata().put("userId", "12345");
                    return document;
                })

                // 切成 1000 token 的片段，重叠 200 token
                .documentSplitter(DocumentSplitters.recursive(1000, 200, new OpenAiTokenCountEstimator("gpt-4o-mini")))

                // 把文档名拼到每个片段开头，提升检索命中率
                .textSegmentTransformer(textSegment -> TextSegment.from(
                        textSegment.metadata().getString("file_name") + "\n" + textSegment.text(),
                        textSegment.metadata()))

                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build();
        IngestionResult result = ingestor.ingest(documents);
        System.out.println(result);
    }

}
