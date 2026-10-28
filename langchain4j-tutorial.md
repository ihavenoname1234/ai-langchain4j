# LangChain4j 实战教程

面向 Java 开发者的完整路径：从底层 `ChatModel` 到声明式 AI Services、工具调用、RAG 与响应流式传输。内容依据官方中文文档 `langchain4j.cn/tutorials` 整理并校准到当前主线版本。

**LangChain4j 1.20.0** · JDK 17+ · Spring Boot 3.2+ · 14 个章节 · 40+ 代码示例

---

## 目录

- [01 认识 LangChain4j](#01-认识-langchain4j)
- [02 环境与第一个程序](#02-环境与第一个程序)
- [03 ChatModel：底层 API](#03-chatmodel底层-api)
- [04 消息模型与多轮对话](#04-消息模型与多轮对话)
- [05 ChatMemory：聊天记忆](#05-chatmemory聊天记忆)
- [06 AI Services：声明式高层 API](#06-ai-services声明式高层-api)
- [07 结构化输出](#07-结构化输出)
- [08 工具与函数调用](#08-工具与函数调用)
- [09 RAG：检索增强生成](#09-rag检索增强生成)
- [10 流式输出](#10-流式输出)
- [11 Spring Boot 集成](#11-spring-boot-集成)
- [12 可观测性与成本控制](#12-可观测性与成本控制)
- [13 工程实践与常见坑](#13-工程实践与常见坑)
- [14 学习路线与资源](#14-学习路线与资源)

---

## 01 认识 LangChain4j

先用一分钟把「它是什么、解决什么问题、什么时候不该用它」讲清楚，后面所有代码才有落点。

### 一句话定位

LangChain4j 是专为 JVM 打造的大模型应用开发库。它把各家大模型 SDK 的差异（不同的请求格式、参数名、返回结构、认证方式、重试逻辑）统一成一套 Java 风格的 API：**类型安全、POJO、注解、接口、流式 API**。

> **说明 · 澄清一个常见误解**
>
> LangChain4j **不是** Python LangChain 的移植版。它从零设计，遵循 Java 的编程习惯。名字里有 "LangChain" 只是致敬，别拿 Python 那套 LCEL 的心智模型往上套。

### 它解决的四类麻烦事

- **多模型统一**：同一份代码切换 OpenAI / Gemini / Claude / Ollama / 通义 / DeepSeek，只改构建器，不改业务逻辑。
- **多轮对话**：LLM 本身无状态，`ChatMemory` 帮你管理消息窗口、淘汰策略与持久化。
- **让 AI 用你的数据**：文档加载 → 切分 → 嵌入 → 向量检索 → 注入提示词，整条 RAG 管线开箱即用。
- **让 AI 干活**：`@Tool` 注解把 Java 方法暴露给模型，查库、下单、搜索、发邮件都能被自动调度。

### 核心心智模型：两级抽象

这是理解整个框架的关键。LangChain4j 的 API 分成明显两层，**你可以在同一个项目里混用**。

| 分层 | 组成 |
| --- | --- |
| 高层 API · AI Services（声明式，日常业务代码写在这一层） | `AiServices` · `@SystemMessage` · `@UserMessage` · `@MemoryId` · `@Tool` · `TokenStream` · `Result<T>` |
| 底层 API · 组件编排（需要精细控制时下沉到这一层） | `ChatModel` · `StreamingChatModel` · `ChatRequest` · `ChatMemory` · `EmbeddingStore` · `RetrievalAugmentor` |
| 基础设施 · 模型与存储实现（由 provider 依赖提供） | `langchain4j-open-ai` · `langchain4j-ollama` · `langchain4j-pgvector` · `langchain4j-easy-rag` |
| 你的业务代码 | `Spring Boot / Quarkus / Micronaut / 纯 Java` |

| 对比项 | 底层 ChatModel | 高层 AI Services |
| --- | --- | --- |
| 调用方式 | 手动拼 `ChatMessage`，自己解析返回值 | 定义一个接口，框架生成实现（代理对象） |
| 代码量 | 多，样板代码明显 | 极少，一个方法签名就是一次 LLM 调用 |
| 灵活度 | 最高，可直接控制 `ChatRequest` 每个字段 | 高，通过注解 + 构建器配置 |
| 典型场景 | 多模态输入、自定义请求重写、框架二次封装 | 业务功能：问答、抽取、分类、客服、Agent |
| 可测试性 | 需自行 mock | 本身就是接口，天然可 mock |

> **提示 · 选型建议**
>
> 默认从 AI Services 起步。只有当你要发送图片/音频/PDF、要精细改写 `ChatRequest`、或框架能力覆盖不到某个参数时，才下沉到 `ChatModel`。

### 版本与运行要求

- **最低 JDK 17**，没有 Java 8 兼容线。
- 核心库 `dev.langchain4j:langchain4j` 当前主线版本 **1.20.0**；同时并行维护回溯补丁线（如 1.19.x、1.11.x、1.5.x），锁定旧版本的生产系统仍能拿到修复。
- **集成模块大量使用 beta 版本号**，这是官方刻意的版本策略，不代表质量差。例如 Spring Boot Starter 目前是 `1.20.0-beta30`，核心库是 `1.20.0`，两者搭配合用。
- 上游中文文档里的示例写的是 `1.3.0-beta9`，那是历史版本。API 名称基本一致，但本文统一按新版本写法给出。

> **注意 · 升级提醒**
>
> beta 模块的 API 存在变动可能。生产项目务必在 BOM 里锁死版本号，升级前跑一遍回归测试，尤其关注工具调用与结构化输出相关的 API。

---

## 02 环境与第一个程序

### 步骤 1：准备 JDK 与构建工具

确认 JDK 版本不低于 17：

```bash
java -version
mvn -v
```

如果 `mvn` 提示找不到命令，需要先装 Maven（或用 IDE 内置的 Maven / Gradle Wrapper 代跑）。

### 步骤 2：用 BOM 统一版本

LangChain4j 的模块非常多，强烈建议用 BOM 管理版本，否则很容易出现模块间版本错配。**以下是本章之后所有示例的依赖基础**：

**`pom.xml`**

```xml
<properties>
    <maven.compiler.release>17</maven.compiler.release>
    <langchain4j.version>1.20.0</langchain4j.version>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>dev.langchain4j</groupId>
            <artifactId>langchain4j-bom</artifactId>
            <version>${langchain4j.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <!-- 核心库：模型接口、AI Services、RAG。不含具体厂商实现 -->
    <dependency>
        <groupId>dev.langchain4j</groupId>
        <artifactId>langchain4j</artifactId>
    </dependency>

    <!-- 具体厂商实现，本教程用 OpenAI 协议系 -->
    <dependency>
        <groupId>dev.langchain4j</groupId>
        <artifactId>langchain4j-open-ai</artifactId>
    </dependency>
</dependencies>
```

### 步骤 3：配置密钥

不要硬编码 API Key。用环境变量：

```bash
# macOS / Linux
export OPENAI_API_KEY="sk-xxxxxxxx"

# Windows PowerShell
$env:OPENAI_API_KEY = "sk-xxxxxxxx"
```

### 步骤 4：Hello World

这是底层 API 最短的可用路径，先确认链路是通的：

**`HelloLangChain4j.java`**

```java
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;

public class HelloLangChain4j {

    public static void main(String[] args) {

        ChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                    .modelName(GPT_4_O_MINI)
                .logRequests(true)   // 打印发出去的请求，开发期必开
                .logResponses(true)  // 打印返回的响应
                .build();

        String answer = model.chat("用一句话解释什么是 JVM");
        System.out.println(answer);
    }
}
```

> **提示 · 国内网络的实战写法**
>
> `OpenAiChatModel` 走的是 OpenAI 协议，只要目标服务提供 OpenAI 兼容端点，改 `baseUrl` 即可无缝切换到国内模型，业务代码零改动：
>
> ```java
> // 以 DeepSeek 为例，其他兼容端点同理
> ChatModel model = OpenAiChatModel.builder()
>         .baseUrl("https://api.deepseek.com/v1")
>         .apiKey(System.getenv("DEEPSEEK_API_KEY"))
>         .modelName("deepseek-chat")
>         .build();
> ```
>
> 同理，Maven 依赖拉取慢可以在 `~/.m2/settings.xml` 里配置国内镜像。

> **注意 · 务必打开日志**
>
> 刚上手时 90% 的问题都能靠 `logRequests` / `logResponses` 直接定位——你会亲眼看到框架往提示词里塞了什么、模型究竟返回了什么。这是排查「模型为什么不按我说的做」的唯一高效手段。

---

## 03 ChatModel：底层 API

先把底层搞明白，AI Services 的魔法就变得透明了——它做的无非就是替你拼消息、解析返回值。

### 三种调用重载

**`ChatModel 接口（节选）`**

```java
public interface ChatModel {

    // 1) 便捷方法：输入 String，输出 String。适合快速实验
    String chat(String userMessage);

    // 2) 完整消息：输入一条或多条 ChatMessage
    ChatResponse chat(ChatMessage... messages);
    ChatResponse chat(List<ChatMessage> messages);

    // 3) 完全控制：通过 ChatRequest 指定模型、温度、工具、JSON Schema 等
    ChatResponse chat(ChatRequest chatRequest);
}
```

### ChatResponse：一次调用拿到了什么

`chat(ChatMessage...)` 返回的不是字符串，而是 `ChatResponse`，它包含两部分信息：

- `aiMessage()` —— 模型生成的消息，可取 `text()`、`thinking()`（推理内容）、`toolExecutionRequests()`（工具调用请求）、`attributes()`（厂商特有属性）。
- `metadata()` —— 即 `ChatResponseMetadata`，内含 `TokenUsage` 与 `FinishReason`。

| 成员 | 含义 | 你会用它做什么 |
| --- | --- | --- |
| `TokenUsage` | 输入 token、输出 token、总量 | 计算单次调用成本、做配额与计费统计 |
| `FinishReason` | 生成为何停止 | 常见值 `STOP`（模型自行结束）；若为长度截断则要考虑调大 `maxOutputTokens` |

```java
ChatResponse response = model.chat(UserMessage.from("你好"));

String text = response.aiMessage().text();
TokenUsage usage = response.metadata().tokenUsage();
FinishReason reason = response.metadata().finishReason();

System.out.printf("输入 %d tokens，输出 %d tokens，停止原因 %s%n",usage.inputTokenCount(), usage.outputTokenCount(), reason);
```

### ChatRequest：所有可调参数的入口

当 AI Services 的注解不够用时，就用 `ChatRequest` 精确控制：

```java
ChatRequest chatRequest = ChatRequest.builder()
        .messages(...)               // 消息列表
        .modelName(...)              // 覆盖构建时指定的模型
        .temperature(...)            // 随机性：0 确定性高，1+ 更发散
        .topP(...)                   // 核采样
        .topK(...)                   // 候选集大小
        .frequencyPenalty(...)       // 抑制重复词
        .presencePenalty(...)        // 鼓励引入新话题
        .maxOutputTokens(...)        // 输出上限
        .stopSequences(...)          // 停止序列
        .toolSpecifications(...)     // 可调用的工具
        .toolChoice(...)             // 工具选择策略
        .responseFormat(...)         // 文本 / JSON Schema
        .parameters(...)             // 一次性设置通用或厂商特有参数
        .build();

ChatResponse chatResponse = model.chat(chatRequest);
```

### 其他模型类型

除了聊天模型，LangChain4j 还把另外几类模型抽象成了统一接口。前面几章只会用到 `EmbeddingModel`，其余了解即可：

| 接口 | 职责 | 出现场景 |
| --- | --- | --- |
| `LanguageModel` | String 进、String 出 | 老接口，已被 ChatModel 取代，新功能不再支持 |
| `ChatModel` | ChatMessage 进、AiMessage 出 | 所有对话场景 |
| `EmbeddingModel` | 文本 → `Embedding` 向量 | RAG 的索引与检索 |
| `ImageModel` | 生成与编辑图像 | 文生图 |
| `ModerationModel` | 检测有害内容 | 内容审核，可挂在 AI Service 上自动执行 |
| `ScoringModel` | 给多段文本按相关性打分 | RAG 重排序（rerank） |

---

## 04 消息模型与多轮对话

### 五种 ChatMessage

`ChatMessage` 是一个基础接口，按消息来源分为五种：

| 类型 | 来源 | 说明 |
| --- | --- | --- |
| `UserMessage` | 用户 | 可以是终端用户，也可以是你的应用程序本身。可包含多模态内容 |
| `AiMessage` | 模型 | 包含 `text()`、`thinking()`、`toolExecutionRequests()`、`attributes()` |
| `SystemMessage` | 开发者 | 定义模型的角色、行为准则、回答风格。模型被训练得更重视它 |
| `ToolExecutionResultMessage` | 你的代码 | 工具执行结果，回传给模型形成闭环 |
| `CustomMessage` | 任意 | 仅当模型实现支持时可用（目前仅 Ollama） |

> **警告 · 安全红线：SystemMessage 绝不能让终端用户直接写入**
>
> 系统消息的权重远高于用户消息，这正是「提示词注入」的攻击入口。永远不要做类似 `SystemMessage.from(request.getParam())` 的事情——系统提示词必须由开发者在代码或资源文件中定义。

### 关键认知：LLM 是无状态的

模型不记得任何事。想要多轮对话，**上下文必须由你自己带上**。这是理解 `ChatMemory` 为什么存在的前提。

目标对话：

**`对话记录`**

```text
用户：Hello, my name is Klaus
AI  ：Hi Klaus, how can I help you?
用户：What is my name?
AI  ：Klaus
```

用底层 API 实现它，第二次调用时必须把前面的消息一起传进去：

```java
UserMessage firstUserMessage = UserMessage.from("Hello, my name is Klaus");

AiMessage firstAiMessage = model.chat(firstUserMessage).aiMessage();
// Hi Klaus, how can I help you?

UserMessage secondUserMessage = UserMessage.from("What is my name?");

// 注意：第三次参数里带了前两条消息，模型才"记得"名字
AiMessage secondAiMessage = model
        .chat(firstUserMessage, firstAiMessage, secondUserMessage)
        .aiMessage();
// Klaus
```

手动维护这个列表显然不现实——它会长到超出上下文窗口，而且每次都要重发全部历史，成本随轮次线性增长。这就是第五章 `ChatMemory` 要解决的问题。

### 多模态输入

`UserMessage` 内部持有一个 `List<Content> contents`，因此可以混合多种内容：

- **TextContent**：纯文本，最简单的形式
- **ImageContent**：远程 URL 或 Base64 二进制
- **AudioContent**：音频内容
- **VideoContent**：视频内容
- **PdfFileContent**：PDF 文件二进制内容

文本 + 图片一起发送：

```java
UserMessage userMessage = UserMessage.from(
        TextContent.from("Describe the following image"),
        ImageContent.from("https://example.com/cat.jpg")//必须使用网络图片的url
);

ChatResponse response = model.chat(userMessage);
```

用本地文件的 Base64 数据构造图片内容：

```java
byte[] imageBytes = readBytes("C\\cat.jpg");
String base64Data = Base64.getEncoder().encodeToString(imageBytes);

ImageContent imageContent = ImageContent.from(base64Data, "image/jpg");

//本地图片比网络图片多一半转换成base64 编码字符串

UserMessage userMessage = UserMessage.from(
    TextContent.from("Describe the following image"),
    imageContent
);
```

> **说明 · 关于 DetailLevel**
>
> 图片内容还可以指定 `DetailLevel` 枚举（`LOW` / `HIGH` / `AUTO`）来控制模型如何处理图像。`LOW` 更省 token，适合只需要粗略识别内容的场景。

> **注意 · 能力边界**
>
> 并非所有模型都支持全部模态，具体要看厂商的集成文档对比表。另外：**AI Services 目前不支持多模态**，需要发图片/音频时必须使用底层 API。

---

输入文件

```java
// Extract text from PDF
PDDocument document = PDDocument.load(new File("文件路径"));
PDFTextStripper stripper = new PDFTextStripper();
String pdfText = stripper.getText(document);
document.close();
// TXT - 直接读取
String text = Files.readString(Paths.get("file.txt"));

// DOCX - 使用 Apache POI
XWPFDocument doc = new XWPFDocument(new FileInputStream("file.docx"));
String text = doc.getParagraphs().stream()
    .map(XWPFParagraph::getText)
    .collect(Collectors.joining("\n"));
```

## 05 ChatMemory：聊天记忆

手工维护消息列表既繁琐又昂贵，`ChatMemory` 就是替你做这件事的抽象。

### 先分清「记忆」和「历史」

这两个概念经常被混为一谈，但在工程上是两件不同的事：

- **历史（History）**：用户和 AI 之间**所有**完整消息。它是你在 UI 上展示给用户看的东西，代表真实说过的每一句话。
- **记忆（Memory）**：只保留**部分信息**，是喂给 LLM 的那一份。根据算法不同，它可以淘汰消息、总结消息、删除细节、注入额外上下文或指令。

> **注意 · 重要边界**
>
> LangChain4j 目前**只提供记忆，不提供历史**。如果你需要完整、可追溯的对话记录（审计、客服质检、界面回放），必须自己实现存储，不要指望 `ChatMemory`。

### 淘汰策略：两种开箱实现

为什么必须淘汰？三个理由：适配模型的上下文窗口、控制 token 成本、降低响应延迟。

| 实现 | 策略 | 适用场景 |
| --- | --- | --- |
| `MessageWindowChatMemory` | 滑动窗口，保留最近 **N 条消息** | 快速原型。因为每条消息长度差异大，token 数不可控 |
| `TokenWindowChatMemory` | 滑动窗口，保留最近 **N 个 token** | 生产环境。需要提供 `TokenCountEstimator` 计算 token 数 |

注意 `TokenWindowChatMemory` 的一个细节：**消息不可分割**。如果一条消息塞不进窗口，整条被淘汰，而不是截断。

```java
// 最简用法：保留最近 10 条消息
ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);

memory.add(UserMessage.from("你好，我叫 Klaus"));
memory.add(AiMessage.from("你好 Klaus，有什么可以帮你？"));

List<ChatMessage> messages = memory.messages(); // 给 LLM 的那份上下文
```

### 持久化：把记忆存到数据库

默认实现把消息放在内存里，应用重启就没了。要实现持久化，写一个 `ChatMemoryStore`：

```java
class PersistentChatMemoryStore implements ChatMemoryStore {

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        // 通过 memoryId 从数据库取出该会话的全部消息
        // 可用 ChatMessageDeserializer.messagesFromJson(String) 反序列化
        String json = loadFromDb(memoryId);
        return ChatMessageDeserializer.messagesFromJson(json);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        // 每次新增 ChatMessage 都会被调用（通常一轮交互调用两次：加 UserMessage、加 AiMessage）
        // 可用 ChatMessageSerializer.messagesToJson(List<ChatMessage>) 序列化
        saveToDb(memoryId, ChatMessageSerializer.messagesToJson(messages));
    }

    @Override
    public void deleteMessages(Object memoryId) {
        // 当调用 ChatMemory.clear() 时触发；不使用该功能可以留空
        deleteFromDb(memoryId);
    }
}

ChatMemory chatMemory = MessageWindowChatMemory.builder()
        .id("12345")                 // 区分不同用户 / 不同会话
        .maxMessages(10)
        .chatMemoryStore(new PersistentChatMemoryStore())
        .build();
```

> **说明 · 一个容易踩的语义细节**
>
> `updateMessages()` 是**全量更新**语义：被淘汰的消息也会从 `ChatMemoryStore` 里消失（回调时传入的列表已不含它）。如果你同时还需要完整历史，那必须在另一个表里单独落库——这也再次说明了记忆 ≠ 历史。

### 框架替你处理的两类特殊消息

#### SystemMessage

- 一旦加入，**永远保留**，不会被窗口淘汰。
- 同一时刻只保留一个。内容相同的新系统消息会被忽略；内容不同的会**替换**旧的。

#### 工具消息

如果一条含 `ToolExecutionRequest` 的 `AiMessage` 被淘汰，它后续「孤立」的 `ToolExecutionResultMessage` 会一并自动淘汰。原因是 OpenAI 等服务商禁止在请求中出现孤立的工具结果消息，框架帮你避免了这个报错。

### 多用户场景怎么写

一个 `ChatMemory` 实例只能服务一个会话。多用户时用 `ChatMemoryProvider` 按 ID 分发——这个用法在下一章 AI Services 里会更自然，这里先给独立使用版本：

```java
// 由你的代码负责按 userId 持有各自的 ChatMemory
Map<String, ChatMemory> memories = new ConcurrentHashMap<>();

ChatMemory memoryFor(String userId) {
    return memories.computeIfAbsent(userId,
            id -> MessageWindowChatMemory.withMaxMessages(20));
}
```

> **警告 · 内存泄漏风险**
>
> 上面这种 `Map` 会随用户数无限增长。生产环境必须在会话结束时主动清除：调用 `ChatMemory.clear()`，并从你自己的 `Map` 中移除对应条目。另外，**不要对同一个 `@MemoryId` 并发调用 AI Service**，框架没有做防并发保护，可能导致 `ChatMemory` 数据损坏。

---

## 06 AI Services：声明式高层 API

这是 LangChain4j 最核心、最值得掌握的章节。心智模型和 Spring Data JPA、Retrofit 完全一致：**你声明接口，框架生成实现**。

### 从最简形态开始

```java
interface Assistant {
    String chat(String userMessage);
}

ChatModel model = OpenAiChatModel.builder()
        .apiKey(System.getenv("OPENAI_API_KEY"))
        .modelName(GPT_4_O_MINI)
        .build();

// 生成代理对象
Assistant assistant = AiServices.create(Assistant.class, model);

String answer = assistant.chat("Hello");
System.out.println(answer); // Hello, how can I help you?
```

#### 底层发生了什么

你把接口的 `Class` 和底层组件交给 `AiServices`，它用反射生成一个实现该接口的代理对象，由代理完成输入输出的双向转换：

- 输入侧：你的 `String` 参数被自动包装成 `UserMessage`；
- 输出侧：`ChatModel` 返回的 `AiMessage` 被转换回你声明的返回类型（这里是 `String`）。

它同时替你处理：为 LLM 格式化输入、解析 LLM 输出。并内建支持聊天记忆、工具、RAG。

> **提示 · Spring Boot / Quarkus 项目不用手写 create**
>
> 在这两个框架中，自动配置会替你创建 `Assistant` Bean。你只需要定义接口并注入，无需调用 `AiServices.create(...)`。详见第 11 章。

### @SystemMessage 与 @UserMessage

通过系统消息设定角色和行为准则，最常用的方式：

```java
interface Friend {

    @SystemMessage("你是一只猫娘")
    String chat(String userMessage);
}

Friend friend = AiServices.create(Friend.class, model);
Result<String> result = friend.chat("你好啊");
String answer = result.content();
```

注解值也可以从类路径资源加载，适合长提示词：

```java
@SystemMessage(fromResource = "my-prompt-template.txt")
String chat(String userMessage);
```

若模型不支持系统消息，或你想把指令放进用户消息，改用 `@UserMessage` 配合模板变量：

```java
interface Friend {

    // {{it}} 指代方法的唯一参数
    @UserMessage("You are a good friend of mine. Answer using slang. {{it}}")
    String chat(String userMessage);
}

// 参数多时，用 @V 给模板变量起名
interface QaBot {

    @UserMessage("You are a good friend of mine. Answer using slang. {{message}}")
    String chat(@V("message") String userMessage);
}
```

> **注意 · @V 在什么情况下是必需的**
>
> 只有当 Java 编译时**没有**开启 `-parameters` 选项时才需要 `@V`（因为拿不到参数名）。使用 Quarkus 或 Spring Boot 时不需要它。Maven 编译插件加 `<parameters>true</parameters>` 也能解决。

### 动态系统消息

需要按用户/会话给不同的系统提示词时，用 `systemMessageProvider`：

```java
Friend friend = AiServices.builder(Friend.class)
        .chatModel(model)
        .systemMessageProvider(chatMemoryId -> "You are a good friend of mine. Answer using slang.")
        .build();
```

### 有效的 AI Service 方法签名

下面这些写法都是合法的，值得对照着用：

**`java · 只发 UserMessage`**

```java
String chat(String userMessage);

String chat(@UserMessage String userMessage);

// userMessage 里含 "{{country}}" 模板变量
String chat(@UserMessage String userMessage, @V("country") String country);
//把方法参数 country 绑定到模板变量 country
@UserMessage("What is the capital of Germany?")
String chat();

@UserMessage("What is the capital of {{it}}?")
String chat(String country);

@UserMessage("What is the capital of {{country}}?")
String chat(@V("country") String country);

@UserMessage("What is the {{something}} of {{country}}?")
String chat(@V("something") String something, @V("country") String country);
```

**`java · SystemMessage + UserMessage`**

```java
@SystemMessage("Given a name of a country, answer with a name of it's capital")
String chat(String userMessage);

@SystemMessage("Given a name of a country, answer with a name of it's capital")
String chat(@UserMessage String userMessage);

@SystemMessage("Given a name of a country, {{answerInstructions}}")
String chat(@V("answerInstructions") String answerInstructions, @UserMessage String userMessage);

@SystemMessage("Given a name of a country, answer with a name of it's capital")
@UserMessage("Germany")
String chat();

@SystemMessage("Given a name of a country, answer with a name of it's capital")
@UserMessage("{{country}}")
String chat(@V("country") String country);
```

### 在 AI Service 中接入聊天记忆

单个会话最简单，构建时挂一个 `ChatMemory`：

```java
Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(model)
        .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
        .build();
```

多用户则必须用 `ChatMemoryProvider`，通过 `@MemoryId` 区分会话：

```java
interface Assistant {
    String chat(@MemoryId int memoryId, @UserMessage String message);
}

Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(model)
        .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
        .build();

String answerToKlaus = assistant.chat(1, "Hello, my name is Klaus");
String answerToFrancine = assistant.chat(2, "Hello, my name is Francine");
```

要能访问和清除某个会话的记忆，让接口额外继承 `ChatMemoryAccess`：

```java
interface Assistant extends ChatMemoryAccess {
    String chat(@MemoryId int memoryId, @UserMessage String message);
}

List<ChatMessage> messagesWithKlaus = assistant.getChatMemory(1).messages();
//获取 memoryId 为 1 的会话记忆，并取出其中保存的所有消息（用户和 AI 的对话）。当前代码把结果赋给 messagesWithKlaus，但没有继续使用它。
boolean evicted = assistant.evictChatMemory(2); 
//删除 memoryId 为 2 的会话记忆。返回值 true 表示找到了并清除该记忆，false 表示没有可清除的记忆。
// 会话结束务必调用，防内存泄漏
```

> **注意 · 两个必须记住的默认行为**
>
> - 若 AI Service 方法没有 `@MemoryId` 参数，`ChatMemoryProvider` 收到的 `memoryId` 默认为字符串 `"default"`。
> - 严禁对同一个 `@MemoryId` 并发调用——会损坏 `ChatMemory`。目前框架没有任何机制阻止这种调用，需要你在业务层加锁或串行化。

### 返回类型与 Result<T>

方法可以返回 `String`，或结构化输出章节列出的任意类型。此外任何类型都能再包一层 `Result<T>`，拿到调用过程的元数据：

```java
interface Assistant {

    @UserMessage("Generate an outline for the article on the following topic: {{it}}")
    Result<List<String>> generateOutlineFor(String topic);
}

Result<List<String>> result = assistant.generateOutlineFor("Java");

List<String> outline      = result.content();
TokenUsage    tokenUsage   = result.tokenUsage();     // 含所有轮次（如工具调用）的累计用量
List<Content> sources      = result.sources();        // RAG 检索到的来源
List<ToolExecution> tools  = result.toolExecutions(); // 执行过的工具及结果
FinishReason  finishReason = result.finishReason();
// 还有：所有中间 ChatResponse、最终 ChatResponse
```

> **提示 · Result<T> 的实用价值**
>
> 做「AI 回答 + 引用来源」的产品功能、做成本归因分析、做工具调用审计，都靠它。建议所有面向用户的功能接口都返回 `Result<T>` 而不是裸 `String`。

### 其他可配置项

| 构建器方法 | 作用 |
| --- | --- |
| `.moderationModel(...)` | 自动内容审核，命中不当内容抛 `ModerationException`（内含被标记文本） |
| `.chatRequestTransformer(UnaryOperator<ChatRequest>)` | 发送前编程式改写请求，例如追加额外上下文 |
| `.chatRequestTransformer(BiFunction<ChatRequest, Object, ChatRequest>)` | 同上，第二个参数是 memoryId，可用于按会话改写 |
| `.contentRetriever(...)` | 启用朴素 RAG |
| `.retrievalAugmentor(...)` | 启用高级 RAG（查询改写、路由、重排序） |
| `.tools(...)` | 注册工具对象 |

### 把复杂需求拆成多个 AI Service

这是本章最有工程价值的一段。逻辑越复杂，越应该拆小——理由和普通软件设计完全一样：**更小、更专一的组件更容易开发、测试、维护，也更便宜**。把几十条指令塞进一个系统提示，模型很可能忽略其中一部分；而指令的排列顺序还会影响效果。

拆分的收益很具体：

- 不同子任务可以用**不同价位的模型**（简单判断用小模型，复杂生成用大模型）。
- 工具和 RAG 只在需要时挂载——每次调用都带上几十个工具，既烧 token 又增加模型被误导的风险。
- AI Service 是接口，**可以在单元测试里 mock**，也能单独做集成测试与参数调优。

示例：客服机器人。打招呼用固定话术，提问才走 LLM + 知识库检索。

```java
interface GreetingExpert {

    @UserMessage("Is the following text a greeting? Text: {{it}}")
    boolean isGreeting(String text);
}

interface ChatBot {

    @SystemMessage("You are a polite chatbot of a company called Miles of Smiles.")
    String reply(String userMessage);
}

class MilesOfSmiles {

    private final GreetingExpert greetingExpert;
    private final ChatBot chatBot;

    MilesOfSmiles(GreetingExpert greetingExpert, ChatBot chatBot) {
        this.greetingExpert = greetingExpert;
        this.chatBot = chatBot;
    }

    public String handle(String userMessage) {
        if (greetingExpert.isGreeting(userMessage)) {   // LLM 驱动的 if
            return "Greetings from Miles of Smiles! How can I make your day better?";
        } else {
            return chatBot.reply(userMessage);
        }
    }
}

// 组装：便宜的小模型做分类，贵的模型 + RAG 做生成
GreetingExpert greetingExpert = AiServices.create(GreetingExpert.class, cheapModel);

ChatBot chatBot = AiServices.builder(ChatBot.class)
        .chatModel(strongModel)
        .contentRetriever(milesOfSmilesContentRetriever)
        .build();

MilesOfSmiles milesOfSmiles = new MilesOfSmiles(greetingExpert, chatBot);
```

这种「确定性代码 + LLM 判断」的混合写法可以推广到各种控制流：

| 控制流 | 实现方式 |
| --- | --- |
| `if` / `else` | AI Service 返回 `boolean` |
| `switch` | AI Service 返回 `enum` |
| `for` / `while` | AI Service 返回 `int` 等数值类型 |
| 顺序编排 | 一个接一个调用多个 AI Service |

> **说明 · 一个关键决策**
>
> 你到底想要「高度确定的程序控制流程，LLM 只是其中一环」，还是「LLM 高度自主、驱动整个应用」？把应用拆成小的 AI Service 之后，**两种方案都变得可选**，甚至可以按场景混搭。

---

## 07 结构化输出

从非结构化文本里抽出 Java 对象——这是 LLM 在业务系统里最有价值的用法之一。

目标：把下面这段文字抽成一个 `Person` 对象。

**`输入文本`**

```text
John is 42 years old and lives an independent life.
He stands 1.75 meters tall and carries himself with confidence.
Currently unmarried, he enjoys the freedom to focus on his personal goals.
```

**`目标类型`**

```java
record Person(String name, int age, double height, boolean married) {
}
```

### 三种实现方式，可靠性从高到低

| 方式 | 原理 | 可靠性 |
| --- | --- | --- |
| **JSON Schema** | 在请求的专用字段里下发 schema，不走提示词 | 最高，推荐 |
| **提示 + JSON 模式** | 提示词要求 + 厂商的 `json_object` 模式 | 中等 |
| **纯提示** | 框架自动在用户消息末尾追加格式说明，再自行解析 | 较差，兜底方案 |

用 AI Services 写，代码量极小——切到 JSON Schema 的关键是**在构建模型时显式开启该能力**（默认关闭）：

```java
interface PersonExtractor {
    Person extractPersonFrom(String text);
}

ChatModel chatModel = OpenAiChatModel.builder()
        .apiKey(System.getenv("OPENAI_API_KEY"))
        .modelName("gpt-4o-mini")
        .supportedCapabilities(RESPONSE_FORMAT_JSON_SCHEMA)  // 必须显式开启
        .strictJsonSchema(true)
        .logRequests(true)
        .logResponses(true)
        .build();

PersonExtractor personExtractor = AiServices.create(PersonExtractor.class, chatModel);

Person person = personExtractor.extractPersonFrom(text);
System.out.println(person); // Person[name=John, age=42, height=1.75, married=false]
```

当以下三个条件同时满足时，框架会**根据返回类型自动生成** `ResponseFormat` 和 `JsonSchema`，你什么都不用写：

1. AI Service 方法返回 POJO；
2. 所用的 `ChatModel` 支持 JSON Schema 能力；
3. 该能力已在该 `ChatModel` 上启用。

生成的 schema 名称取返回类型的简单类名（此处为 `Person`）。

### 添加描述：让抽取更准

模型抽不对时，首选手段是补描述。类和字段都可以用 `@Description`：

@Description 用来给模型可见的 Java 类型或字段添加语义说明。LangChain4j 在需要把结构化数据提供给模型（例如 AI Service 的工具参数、结构化输出 schema）时，会利用这些描述帮助模型理解字段含义和预期格式。

可以理解为：@Description 像是给模型看的说明注释，用于解释类型和字段的含义；但它是运行时可读取的注解。

```java
@Description("a person")
record Person(
        @Description("person's first and last name, for example: John Doe") String name,
        @Description("person's age, for example: 42") int age,
        @Description("person's height in meters, for example: 1.78") double height,
        @Description("is person married or not, for example: false") boolean married) {
}
//@Description("a person") 描述整个 Person 类型。
//name、age、height、married 上的注解分别说明字段含义，并提供示例值。
```

嵌套结构同理：

```java
class Person {
    @Description("first name of a person")
    String firstName;
    String lastName;
    LocalDate birthDate;
    Address address;
}

@Description("an address")
class Address {
    String street;
    Integer streetNumber;
    String city;
}
```

### 必填与可选：这里是反直觉的

> **注意 · 默认值方向完全相反，务必记牢**
>
> - **结构化输出**：所有字段和子字段默认**可选**。原因是模型信息不足时会倾向于编造内容填满字段（比如没有名字就填 "John Doe"），默认可选反而减少胡说。
> - **工具参数**：所有字段和子字段默认**必填**。
>
> 要显式声明必填，用 `@JsonProperty(required = true)`。

```java
record Person(@JsonProperty(required = true) String name, String surname) {
}

interface PersonExtractor {
    Person extractPersonFrom(String text);
}
```

另外注意：可选的基本类型字段若模型没给值，会被初始化为默认值（`int` 为 0，`boolean` 为 false）。开启严格模式（`strictJsonSchema(true)`）后，可选的 `enum` 字段仍可能被填入虚构值。

> **警告 · 无效写法**
>
> 把 `@Description` 放到 `enum` 的**取值**上没有效果，**不会**进入生成的 JSON Schema。想让模型理解各枚举的含义，得写在 enum 类本身的 `@Description` 或者字段描述里。

### 支持的类型

| 类型 | JSON Schema | 纯提示模式 |
| --- | --- | --- |
| `POJO` | ✓ | ✓ |
| `List<POJO>` / `Set<POJO>` | ✓ | ✗ |
| `Enum` / `List<Enum>` / `Set<Enum>` | ✓ | ✓ |
| `List<String>` / `Set<String>` | ✓ | ✓ |
| `boolean` / `Boolean` | ✓ | ✓ |
| `int` / `long` / `float` / `double` 及装箱类型 | ✓ | ✓ |
| `byte` / `short` / `BigInteger` / `BigDecimal` | ✗ | ✓ |
| `Date` / `LocalDate` / `LocalTime` / `LocalDateTime` | ✗ | ✓ |
| `Map<?, ?>` | ✗ | ✓ |

常见返回类型示例：

```java
record Person(String firstName, String lastName) {}

enum Sentiment { POSITIVE, NEGATIVE, NEUTRAL }

interface Assistant {

    Person extractPersonFrom(String text);

    Set<Person> extractPeopleFrom(String text);

    Sentiment extractSentimentFrom(String text);

    List<Sentiment> extractSentimentsFrom(String text);

    List<String> generateOutline(String topic);

    boolean isSentimentPositive(String text);

    Integer extractNumberOfPeopleMentionedIn(String text);
}
```

> **提示 · 返回 boolean / enum 的妙用**
>
> 把 LLM 当成一个能理解自然语言的判断器：`boolean` 可以当 `if` 用，`enum` 可以当 `switch` 用。这是第 06 章「拆分成多个 AI Service」的技术基础。

### 限制清单

- JSON Schema 目前仅受 Azure OpenAI、Google AI Gemini、Mistral、Ollama、OpenAI 支持，需在构建 `ChatModel` 时**显式启用**。
- **不适用于流式模式**（OpenAI 侧尤其如此）。
- POJO 可包含：标量类型、`enum`、嵌套 POJO、以及 `List<T>` / `Set<T>` / `T[]`（T 为标量、enum 或 POJO）。
- 不支持多态：返回的 POJO 及其嵌套 POJO 必须是**具体类**，不能用接口或抽象类。
- 递归结构目前仅 Azure OpenAI、Mistral、OpenAI 支持。
- 当模型不支持、未启用、或类型不受支持时，AI Service 会**自动退回**纯提示模式——不会报错，但成功率下降，注意观察日志。

### 底层写法（需要时再看）

不用 AI Services 时，手工构造 schema：

```java
ResponseFormat responseFormat = ResponseFormat.builder()
        .type(JSON)  // 可选 TEXT（默认）或 JSON
        .jsonSchema(JsonSchema.builder()
        .name("Person")  // OpenAI 要求给 schema 起名
                .rootElement(JsonObjectSchema.builder()
                        .addStringProperty("name")
                        .addIntegerProperty("age")
                        .addNumberProperty("height")
                        .addBooleanProperty("married")
                        .required("name", "age", "height", "married")
                        .build())
                .build())
        .build();

ChatRequest chatRequest = ChatRequest.builder()
        .responseFormat(responseFormat)
        .messages(UserMessage.from(text))
        .build();

ChatResponse chatResponse = model.chat(chatRequest);

String output = chatResponse.aiMessage().text();
// {"name":"John","age":42,"height":1.75,"married":false}

Person person = new ObjectMapper().readValue(output, Person.class);
```

> **说明 · JsonSchemaElement 家族**
>
> `JsonObjectSchema`（对象，通常是根）、`JsonStringSchema`、`JsonIntegerSchema`、`JsonNumberSchema`、`JsonBooleanSchema`、`JsonEnumSchema`、`JsonArraySchema`、`JsonReferenceSchema`（递归）、`JsonAnyOfSchema`（多态）、`JsonNullSchema`（可空）、`JsonRawSchema`（手写完整 schema）。绝大多数情况用 `JsonObjectSchema` 加若干 `addXxxProperty` 就够了。

> **注意 · JSON 模式 ≠ 工具调用**
>
> 两者功能相似但用途不同。当你**始终**需要结构化 JSON、且每次交互相互独立（通常不需要记忆）时，用 JSON Schema——典型场景是信息抽取、自由文本转结构化字段。当模型需要**执行动作**（查数据库、搜网页、取消预订）时，用工具/函数调用。历史上函数调用常被用来做数据抽取，现在应该优先用 JSON Schema。

---

## 08 工具与函数调用

工具是让 LLM 从「会说」变成「能做」的关键机制，也是构建 Agent 的基础。

### 原理：模型不会执行任何东西

必须先明确一件事：**LLM 本身无法执行工具**。它只是在响应中**表达调用意图**（而不是返回纯文本），由你的代码真正执行，再把结果回传，形成闭环。

看一个直观对比。问「475695037565 的平方根是多少」：

**`没有工具时`**

```text
Request:
- messages:
    - UserMessage: What is the square root of 475695037565?

Response:
- AiMessage:
    - text: The square root of 475695037565 is approximately 689710.   ← 接近，但错了
```

给它加上工具：

```java
@Tool("Sums 2 given numbers")
double sum(double a, double b) {
    return a + b;
}

@Tool("Returns a square root of a given number")
double squareRoot(double x) {
    return Math.sqrt(x);
}
```

**`有工具时的两轮交互`**

```text
Request 1:
- UserMessage: What is the square root of 475695037565?
- tools:
    - sum(double a, double b): Sums 2 given numbers
    - squareRoot(double x): Returns a square root of a given number

Response 1:
- AiMessage:
    - toolExecutionRequests: [ squareRoot(475695037565) ]

... 你的代码执行 squareRoot("475695037565")，得到 "689706.486532" ...

Request 2:
- UserMessage: What is the square root of 475695037565?
- AiMessage: [ squareRoot(475695037565) ]
- ToolExecutionResultMessage: 689706.486532

Response 2:
- AiMessage:
    - text: The square root of 475695037565 is 689706.486532.   ← 正确
```

可以看到：模型自主决定调用哪个工具，你负责执行，它再基于结果作答。把工具换成 `googleSearch` 和 `sendEmail`，就能实现「搜到最新 AI 新闻并总结后发邮件给我朋友」这类多步任务。部分模型（如 OpenAI）还支持一次并行调用多个工具。

### 两层抽象

| 层次 | 方式 | 你需要自己做 |
| --- | --- | --- |
| 底层 | `ChatModel` + `ToolSpecification` | 解析 `toolExecutionRequests`、执行方法、构造结果消息、发起第二轮请求 |
| 高层 | AI Services + `@Tool` 注解 | 什么都不用做，框架自动完成整条闭环 |

### 高层用法：给 Java 方法加个注解就行

```java
interface MathGenius {
    String ask(String question);
}

class Calculator {

    @Tool
    double add(int a, int b) {
        return a + b;
    }

    @Tool
    double squareRoot(double x) {
        return Math.sqrt(x);
    }
}

MathGenius mathGenius = AiServices.builder(MathGenius.class)
        .chatModel(model)
        .tools(new Calculator())
        .build();

String answer = mathGenius.ask("What is the square root of 475695037565?");
// The square root of 475695037565 is 689706.486532.
```

调用 `ask` 时，底层发生了两轮 LLM 交互，中间框架自动调用了 `squareRoot`。你完全感知不到。

### 三个注解

| 注解 | 作用 | 字段 |
| --- | --- | --- |
| `@Tool` | 标记一个方法可被 LLM 执行 | `name`（默认取方法名）、`value`（工具描述） |
| `@P` | 描述方法参数 | `value`（参数描述，必填）、`required`（默认 true） |
| `@Description` | 描述类和字段（用于复杂参数对象） | 值即描述文本 |

```java
@Tool("Searches Google for relevant URLs, given the query")
public List<String> searchGoogle(@P("search query") String query) {
    return googleSearchService.search(query);
}

@Tool("Returns the content of a web page, given the URL")
public String getWebPageContent(@P("URL of the page") String url) throws IOException {
    Document jsoupDocument = Jsoup.connect(url).get();
    return jsoupDocument.body().text();
}
```

给复杂参数对象加描述：

```java
@Description("要执行的查询")
class Query {

    @Description("要选择的字段")
    private List<String> select;

    @Description("过滤条件")
    private List<Condition> where;
}

@Tool
Result executeQuery(Query query) { ... }
```

> **提示 · 描述写不写？**
>
> 像 `add(a, b)` 这么直观的方法，不给描述模型也能懂。但多数情况下**务必提供清晰的名称和描述**——模型是靠这些判断「该不该用这个工具、怎么用」的。工具描述写得含糊，是工具调用失败最常见的原因。

### 方法规则速查

| 维度 | 规则 |
| --- | --- |
| 方法修饰 | 可以是静态或非静态，任意可见性（public、private 均可） |
| 参数类型 | 基本类型、包装类型、自定义 POJO（可嵌套）、enum、`List<T>` / `Set<T>`、`Map<K,V>`（需用 `@P` 明确 K 和 V 的类型）；无参方法也支持 |
| 必填性 | 默认**全部必填**；用 `@P(required = false)` 设为可选，对象字段用 `@JsonProperty(required = false)` |
| 返回 `void` | 执行成功后向 LLM 返回字符串 `"Success"` |
| 返回 `String` | 原样返回 |
| 返回其他类型 | 自动转成 JSON 字符串再返回 |
| 抛异常 | `e.getMessage()` 作为工具结果传给 LLM，让它有机会自我修正或重试 |
| 递归参数 | 例如 `Person` 含 `Set<Person> children`，目前仅 OpenAI 支持 |

**`java · 可选参数`**

```java
@Tool
void getTemperature(String location,
                    @P(value = "Unit of temperature", required = false) Unit unit) {
    ...
}

record User(String name, @JsonProperty(required = false) String email) {}

@Tool
void add(User user) { ... }
```

### @ToolMemoryId：多用户会话的关键

如果 AI Service 方法有 `@MemoryId` 参数，那么 `@Tool` 方法的参数上可以用 `@ToolMemoryId`，框架会把值自动传进去。这让工具能感知「当前是哪个用户/哪次会话」：

```java
interface ShoppingAssistant {
    String chat(@MemoryId String userId, @UserMessage String message);
}

class OrderTools {

    @Tool("查询当前用户的订单列表")
    List<Order> listOrders(@ToolMemoryId String userId) {
        return orderService.findByUser(userId);   // 无需让模型传 userId，更安全
    }
}
```

> **注意 · 为什么不要让模型传 userId**
>
> 如果把 userId 设计成普通工具参数，模型就有可能在参数里填入别的用户 ID——这是越权访问的风险点。用 `@ToolMemoryId` 由框架注入，模型碰不到这个值。涉及权限的数据查询，一律用这个方式。

### 并发执行工具

模型并行调用多个工具时，AI Service **默认顺序执行**。要改成并发：

```java
Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(model)
        .tools(new MyTools())
        .executeToolsConcurrently()          // 使用默认线程池
        // 或 .executeToolsConcurrently(customExecutor)
        .build();
```

| 场景 | 多个工具 | 单个工具 |
| --- | --- | --- |
| ChatModel | 并发执行，在不同线程中 | 在**当前线程**执行，不占用线程池 |
| StreamingChatModel | 在 `onCompleteToolCall` 触发时立即执行，不必等响应流结束 | 也在独立线程执行（因为此时无法确定是否还会有更多工具调用） |

### 工具即 Agent：AI Service 作为其他 AI Service 的工具

一个 AI Service 可以注册为另一个 AI Service 的工具，从而把请求路由给更专业的「专家」。这是 Agentic AI 的常见模式：

```java
interface RouterAgent {

    @UserMessage("""
            Analyze the following user request and categorize it as 'legal', 'medical' or 'technical',
            then forward the request as it is to the corresponding expert provided as a tool.
            Finally return the answer that you received from the expert without any modification.

            The user request is: '{{it}}'.
            """)
    String askToExpert(String request);
}

interface MedicalExpert {
    @UserMessage("You are a medical expert. Analyze the following user request under a medical point of view and provide the best possible answer. The user request is {{it}}.")
    @Tool("A medical expert")
    String medicalRequest(String request);
}

interface LegalExpert {
    @UserMessage("You are a legal expert. ... The user request is {{it}}.")
    @Tool("A legal expert")
    String legalRequest(String request);
}

interface TechnicalExpert {
    @UserMessage("You are a technical expert. ... The user request is {{it}}.")
    @Tool("A technical expert")
    String technicalRequest(String request);
}
```

组装成路由：

```java
MedicalExpert   medicalExpert   = AiServices.builder(MedicalExpert.class).chatModel(model).build();
LegalExpert     legalExpert     = AiServices.builder(LegalExpert.class).chatModel(model).build();
TechnicalExpert technicalExpert = AiServices.builder(TechnicalExpert.class).chatModel(model).build();

RouterAgent routerAgent = AiServices.builder(RouterAgent.class)
        .chatModel(model)
        .tools(medicalExpert, legalExpert, technicalExpert)
        .build();

routerAgent.askToExpert("I broke my leg what should I do");
```

### 编程式与动态工具

工具不必都是注解方法，也可以从数据库或配置里加载，通过 `(ToolSpecification, ToolExecutor)` 配对注册：

```java
ToolSpecification toolSpecification = ToolSpecification.builder()
        .name("get_booking_details")
        .description("返回预订详情")               .parameters(JsonObjectSchema.builder()                      .addProperty("bookingNumber", JsonStringSchema.builder()
.description("预订编号，格式为 B-12345")                     .build())
        .required("bookingNumber")
        .build())
 .build();

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

Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(chatModel)
        .tools(Map.of(toolSpecification, toolExecutor))
        .build();
```

更进一步，用 `ToolProvider` 在**每次调用时**动态决定暴露哪些工具。例如只在用户提到 "booking" 时才挂上预订工具：

```java
ToolProvider toolProvider = (toolProviderRequest) -> {
    if (toolProviderRequest.userMessage().singleText().contains("booking")) {
        ToolSpecification spec = ToolSpecification.builder()
                .name("get_booking_details")
                .description("返回预订详情")
                .parameters(JsonObjectSchema.builder()
                        .addStringProperty("bookingNumber")
                        .build())
                .build();
        return ToolProviderResult.builder()
                .add(spec, toolExecutor)
                .build();
    }
    return null;   // 不暴露任何工具，省 token
};

Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(model)
        .toolProvider(toolProvider)
        .build();
```

> **提示 · 动态工具的真实收益**
>
> 每次调用携带的工具都会消耗大量 token。一个聊天机器人不该在任何时候都手握几十上百个工具——用户只是打个招呼时，让模型看到全部工具既贵又可能诱发幻觉甚至被操纵。动态工具是成本与安全双重优化，也是官方文档反复强调「拆分 AI Service」的具体手段。

### 工具幻觉处理

模型有时会「幻觉」出不存在的工具名。默认行为是抛异常，但更优雅的做法是把错误信息回传，引导模型重试：

```java
Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(chatModel)
        .tools(new HelloWorld())
        .hallucinatedToolNameStrategy(toolExecutionRequest -> ToolExecutionResultMessage.from(
                toolExecutionRequest,
                "Error: there is no tool called " + toolExecutionRequest.name()))
        .build();
```

### 查看执行过的工具

```java
interface Assistant {
    Result<String> chat(String userMessage);
}

Result<String> result = assistant.chat("Cancel my booking 123-456");

String answer = result.content();
List<ToolExecution> toolExecutions = result.toolExecutions();   // 请求 + 结果都在里面
```

### 从 MCP 服务器导入工具

除了自己写，还可以从 [MCP 服务器](https://modelcontextprotocol.io/docs/concepts/tools)导入现成工具集。LangChain4j 提供了一个 MCP 工具提供者，把远端 MCP 服务暴露的工具直接接进 AI Service——这是接入第三方能力（文件系统、数据库、浏览器等）成本最低的路径。具体用法见官方文档的 MCP 章节。

---

## 09 RAG：检索增强生成

让模型了解你的专有数据。这就是 RAG 存在的全部理由。

模型的知识只到训练数据为止。想让它懂你的内部文档，有三条路：微调、RAG、或两者结合。本章讲 RAG——**在把提示词发给 LLM 之前，先从你的数据里找出相关信息片段并注入进去**，从而大幅降低幻觉。

### 两个阶段

| 分层 | 组成 |
| --- | --- |
| 阶段一 · 索引（Indexing）—— 通常离线，用户无需等待 | `加载文档` · `清洗与丰富` · `切分为片段` · `计算 Embedding` · `写入向量库` |
| 阶段二 · 检索（Retrieval）—— 在线，用户提问时触发 | `嵌入用户查询` · `相似度搜索` · `注入提示词` · `发送给 LLM` |

索引可以做成独立的定时任务（例如每周重新索引一次公司文档），也可以在线执行——当终端用户要上传自己的文档时，就必须在线做。

### 检索方法简介

| 方法 | 原理 | 特点 |
| --- | --- | --- |
| 全文（关键词）搜索 | TF-IDF、BM25 等，按关键词在文档中的频率与相关性排序 | 精确匹配强，语义泛化弱 |
| 向量搜索（语义搜索） | 用嵌入模型把文本转成向量，按余弦相似度排序 | 能捕捉深层语义，LangChain4j 当前的主力 |
| 混合搜索 | 同时用多种方法，通常效果更好 | 目前仅 Azure AI Search 集成支持 |

### 三个入门档次

| 档次 | 适用 | 你需要做什么 |
| --- | --- | --- |
| **Easy RAG** | 学概念、做 POC | 指向文档目录即可，切分/嵌入/存储全自动 |
| **Naive RAG** | 轻量生产 | 自己选嵌入模型和向量库，用 `EmbeddingStoreContentRetriever` |
| **Advanced RAG** | 对效果有要求 | 组装查询改写、路由、多源检索、重排序、注入等模块 |

### Easy RAG：四步跑通

先加依赖（注意它自带 Apache Tika 解析器和内置嵌入模型）：

**`pom.xml`**

```xml
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-easy-rag</artifactId>
</dependency>
```

```java
// 1) 加载文档：底层会自动选用 ApacheTikaDocumentParser（通过 SPI 提供）
List<Document> documents = FileSystemDocumentLoader.loadDocuments("/home/langchain4j/documentation");

// 2) 切分 + 嵌入 + 存入向量库，一行搞定
InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
EmbeddingStoreIngestor.ingest(documents, embeddingStore);

// 3) 定义 AI Service 并挂上检索器
interface Assistant {
    String chat(String userMessage);
}

ChatModel chatModel = OpenAiChatModel.builder()
        .apiKey(System.getenv("OPENAI_API_KEY"))
        .modelName(GPT_4_O_MINI)
        .build();

Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(chatModel)
        .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
        .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
        .build();

// 4) 提问
String answer = assistant.chat("How to do Easy RAG with LangChain4j?");
```

> **说明 · Easy RAG 背后偷偷做了什么**
>
> - 通过 SPI 加载 `DocumentSplitter`，把每个 `Document` 切成**最多 300 token、重叠 30 token** 的 `TextSegment`。
> - 通过 SPI 加载 `EmbeddingModel`，默认是 **bge-small-en-v1.5**。它量化后仅约 24 MB，用 ONNX Runtime 加载，**可以在同一个 JVM 进程内完全离线把文本转成向量**，无需任何外部服务。
> - 所有 `TextSegment` + `Embedding` 对写入 `EmbeddingStore`。
>
> 质量当然低于定制化 RAG，但它是理解 RAG 和做 POC 最省力的起点，之后可以平滑地逐步替换其中每一环。

加载文档的常用变体：

```java
// 递归加载所有子目录
List<Document> documents = FileSystemDocumentLoader.loadDocumentsRecursively("/home/langchain4j/documentation");

// 用 glob 过滤，只要 PDF
// 注意：配合 loadDocumentsRecursively 时应该用双星号 glob:**.pdf
PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.pdf");
List<Document> documents = FileSystemDocumentLoader.loadDocuments("/home/langchain4j/documentation", pathMatcher);

// 显式指定解析器
Document document = FileSystemDocumentLoader.loadDocument("/home/langchain4j/file.txt", new TextDocumentParser());
```

### 核心 API 全貌

RAG 的数据管线由这几个领域对象串起来，理解它们就理解了整个模块：

| 类 / 接口 | 职责 | 关键方法 |
| --- | --- | --- |
| `Document` | 一个完整文档（一个 PDF、一个网页） | `text()`、`metadata()`、`toTextSegment()`、`from(String, Metadata)` |
| `Metadata` | 文档元信息，键值对。值类型限 String / Integer / Long / Float / Double / UUID | `put/getString/getInteger`、`containsKey`、`merge`、`toMap` |
| `DocumentLoader` | 从各种来源加载文档 | 见下方清单 |
| `DocumentParser` | 解析具体格式 | `TextDocumentParser`、`ApachePdfBoxDocumentParser`、`ApachePoiDocumentParser`、`ApacheTikaDocumentParser` |
| `DocumentTransformer` | 清洗 / 过滤 / 丰富 / 摘要文档 | 自定义实现；官方仅提供 `HtmlToTextDocumentTransformer` |
| `DocumentSplitter` | 把文档切成片段 | `split(Document)`、`splitAll(List)`、`DocumentSplitters.recursive(...)` |
| `TextSegment` | 文档的一个片段 | `text()`、`metadata()`、`from(...)` |
| `EmbeddingModel` | 文本 → 向量 | `embed(String)`、`embedAll(List)`、`dimension()` |
| `EmbeddingStore` | 向量数据库 | `add/addAll`、`search(EmbeddingSearchRequest)`、`removeAll(Filter)` |
| `EmbeddingStoreIngestor` | 完整摄取管线（转换 → 切分 → 嵌入 → 存储） | `ingest(...)`，返回 `IngestionResult`（含嵌入 token 用量） |
| `ContentRetriever` | 按查询检索相关内容 | `EmbeddingStoreContentRetriever`、`WebSearchContentRetriever`、`SqlDatabaseContentRetriever` 等 |
| `RetrievalAugmentor` | 高级 RAG 管线入口 | `DefaultRetrievalAugmentor` |

#### 可用的文档加载器

- `FileSystemDocumentLoader`、`ClassPathDocumentLoader`、`UrlDocumentLoader`（核心模块自带）
- `AmazonS3DocumentLoader`、`AzureBlobStorageDocumentLoader`、`GoogleCloudStorageDocumentLoader`、`TencentCosDocumentLoader`
- `GitHubDocumentLoader`、`SeleniumDocumentLoader`、`PlaywrightDocumentLoader`

### 切分策略：不切行不行？

为什么要切分而不是把整份文档塞进提示词？因为：

- 模型上下文窗口有限，整个知识库塞不进去；
- 上下文越长，响应越慢、成本越高；
- 提示词里的无关内容会分散模型注意力，**反而增加幻觉概率**；
- 上下文越多，越难解释模型到底是依据哪条信息作答的。

| 策略 | 优点 | 缺点 |
| --- | --- | --- |
| **整个文档作为原子单位** <br>检索到最相关的 N 个文档整体注入 | 不丢失上下文 | token 消耗大；文档常含多个主题，无关部分会造成干扰；各种长度的文档被压成单个定长向量，**向量搜索质量下降**。适合需要长上下文模型、且「绝对不能漏细节」的场景 |
| **切成更小片段** <br>按章节、段落甚至句子切 | 向量检索质量更好；省 token | 片段可能缺乏足够上下文，导致模型误读并产生幻觉 |

实践中的常见缓解手段是**带重叠切分**。更高级的方案还有「句子窗口检索」「自动合并检索」「父文档检索」——本质上都是让检索到的片段能带上它前后的额外上下文。

内置的切分器：

```java
// 按段落（两个及以上连续换行分隔）
new DocumentByParagraphSplitter(...);

// 其他可选：DocumentByLineSplitter / DocumentBySentenceSplitter
//          DocumentByWordSplitter / DocumentByCharacterSplitter
//          DocumentByRegexSplitter

// 递归切分，最常用
DocumentSplitters.recursive(1000, 200, new OpenAiTokenCountEstimator("gpt-4o-mini"));
```

切分器的工作逻辑：先按规则把文档拆成更小的「单元」（段落、句子、词），再把这些单元尽量多地组合进一个 `TextSegment`，同时不超过你设定的大小限制。放不下的单元会交给子切分器进一步细分。所有 `Metadata` 都会从 `Document` 复制到每个 `TextSegment`，并额外添加一个从 0 递增的 `index` 条目。

### 组装一条完整的摄取管线

这是本章最实用的一段代码，三个 hook 各解决一个问题：

```java
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

ingestor.ingest(document1);
IngestionResult result = ingestor.ingest(List.of(document2, document3));
```

> **提示 · 两个低成本高回报的技巧**
>
> - **把文件标题拼进每个片段**。单独一个片段常常看不出自己在讲什么主题，加上标题能显著改善检索质量。这就是上面 `textSegmentTransformer` 在做的事。
> - **给文档打元数据标签**，之后就能在检索时按 user_id / 部门 / 密级过滤，天然实现数据隔离。

### Naive RAG：自己掌控检索参数

```java
ContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
        .embeddingStore(embeddingStore)
        .embeddingModel(embeddingModel)
        .maxResults(5)        // 返回最多 5 条
        .minScore(0.75)       // 相似度阈值，低于此分不返回
        .build();

Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(model)
        .contentRetriever(contentRetriever)
        .build();
```

三个参数都能根据查询动态决定，这在多租户场景非常关键：

```java
ContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
        .embeddingStore(embeddingStore)
        .embeddingModel(embeddingModel)
        .dynamicMaxResults(query -> 3)
        .dynamicMinScore(query -> 0.75)
        .dynamicFilter(query -> {
            String userId = getUserId(query.metadata().chatMemoryId());
            return metadataKey("userId").isEqualTo(userId);   // 只检索该用户自己的文档
        })
        .build();
```

#### 可用过滤器

`IsEqualTo`、`IsNotEqualTo`、`IsGreaterThan`、`IsGreaterThanOrEqualTo`、`IsLessThan`、`IsLessThanOrEqualTo`、`IsIn`、`IsNotIn`、`ContainsString`、`And`、`Or`、`Not`。

> **注意 · 过滤器支持度因存储而异**
>
> 不是所有向量库都支持按元数据过滤，支持的那些也未必支持全部操作符。例如 `ContainsString` 目前仅 Milvus、PgVector、Qdrant 支持。选型前先查官方文档对比表的「按 Metadata 过滤」列。

### Advanced RAG：五个可插拔组件

当检索质量不达标时，就需要在管线的不同位置插入处理逻辑。完整流程是：

| 分层 | 组成 |
| --- | --- |
| ① 用户消息 → 转换为 Query | `Query` · `Metadata.userMessage()` · `Metadata.chatMemoryId()` · `Metadata.chatMemory()` |
| ② QueryTransformer —— 把 1 个 Query 变成多个 | `DefaultQueryTransformer`（原样透传） · `CompressingQueryTransformer` · `ExpandingQueryTransformer` |
| ③ QueryRouter —— 决定每个 Query 走哪些检索器 | `DefaultQueryRouter`（全部检索器） · `LanguageModelQueryRouter` |
| ④ ContentRetriever —— 各数据源并行检索 | `EmbeddingStore` · `WebSearch` · `SQL Database` · `Azure AI Search` · `Neo4j` |
| ⑤ ContentAggregator —— 合并多路结果并排序 | `DefaultContentAggregator`（两阶段 RRF） · `ReRankingContentAggregator` |
| ⑥ ContentInjector —— 注入到 UserMessage | `DefaultContentInjector` |
| ⑦ 增强后的 UserMessage → 发送给 LLM | `ChatModel` |

**`java · 组装高级管线`**

```java
RetrievalAugmentor retrievalAugmentor = DefaultRetrievalAugmentor.builder()
        .queryTransformer(...)
        .queryRouter(...)
        .contentAggregator(...)
        .contentInjector(...)
        .executor(...)
        .build();

Assistant assistant = AiServices.builder(Assistant.class)
        .chatModel(model)
        .retrievalAugmentor(retrievalAugmentor)
        .build();
```

#### 查询改写：解决「他」指代不明

多轮对话中，用户的追问常常缺少主语：

**`对话记录`**

```text
用户：告诉我关于 John Doe 的事
AI  ：John Doe 是一个...
用户：他住在哪里？          ← 这个查询单独拿去检索，检索不到东西
```

`CompressingQueryTransformer` 会让 LLM 读取整个对话，把它改写成 `John Doe 住在哪里？` 再做检索。`ExpandingQueryTransformer` 则把一个查询扩写成多个不同表述，提高召回。

#### 重排序：精度换成本

```java
ReRankingContentAggregator   // 使用 ScoringModel（如 Cohere）对结果重新打分排序
DefaultContentAggregator     // 无外部依赖，做两阶段倒数排名融合（RRF）
```

#### 自定义注入格式

默认注入器只是在用户消息末尾追加 `Answer using the following information:` 加内容。三种自定义方式：

```java
// 方式一：替换提示词模板（必须包含 {{userMessage}} 和 {{contents}} 两个变量）
DefaultContentInjector.builder()
        .promptTemplate(PromptTemplate.from("{{userMessage}}\n{{contents}}"))
        .build();

// 方式二：扩展 DefaultContentInjector 并重写 format 方法
// 方式三：自行实现 ContentInjector

// 额外收益：把来源文件名一并注入，方便模型与用户核对出处
DefaultContentInjector.builder()
        .metadataKeysToInclude(List.of("source"))
        .build();
```

启用 `metadataKeysToInclude` 后，最终发给模型的消息形如：

**`实际提示词`**

```text
我如何取消预订？

Answer using the following information:
content: To cancel a reservation, go to ...
source: ./cancellation_procedure.html

content: Cancellation is allowed for ...
source: ./cancellation_policy.html
```

#### 并行化

只有一个 Query 和一个 ContentRetriever 时，路由与检索在**同一线程**执行；否则用 `Executor` 并行。默认是用 `keepAliveTime` 改为 1 秒的 `Executors.newCachedThreadPool()`，你也可以传入自定义线程池。

### 把来源返回给前端

做「回答 + 引用出处」的产品体验就靠它：

```java
interface Assistant {
    Result<String> chat(String userMessage);
}

Result<String> result = assistant.chat("How to do Easy RAG with LangChain4j?");

String answer = result.content();
List<Content> sources = result.sources();   // 检索到的原始片段
```

### 其他内容检索器

- **WebSearchContentRetriever**：接搜索引擎（如 Google Custom Search），把互联网当知识库。适合需要实时信息的场景。
- **SqlDatabaseContentRetriever**（实验性，`langchain4j-experimental-sql` 模块）：用 LLM 把自然语言 `Query` 翻译成 SQL 并执行。做「自然语言查数据库」很方便，但**务必注意只读权限与 SQL 注入风险**。
- **AzureAiSearchContentRetriever**：支持全文、向量、混合搜索与重排序。
- **Neo4jContentRetriever**：把自然语言转成 Cypher 查询图数据库。

### 知识图谱：GraphTransformer

另一个方向是把非结构化文档转成结构化语义图。默认实现 `LLMGraphTransformer` 用 LLM 抽取实体与关系，输出 `GraphDocument`（含 `GraphNode` 节点集、`GraphEdge` 关系集和源文档），可直接导入图数据库或知识图谱。

> **注意 · 社区模块不在 BOM 管理范围内**
>
> 该实现在 `langchain4j-community-llm-graph-transformer` 模块中，属于社区模块，**不受 `langchain4j-bom` 管理**，必须自己显式写 `<version>`，否则 Maven 会报缺少版本。

---

## 10 流式输出

把「等 8 秒后一次性出现」变成「几乎立刻开始逐字出现」。这是聊天类产品体验的分水岭。

LLM 是逐个 token 生成文本的，所以很多服务商提供了流式返回的能力。对应的接口是 `StreamingChatModel`（以及 `StreamingLanguageModel`）。

### 回调式写法

**`java · StreamingChatResponseHandler`**

```java
public interface StreamingChatResponseHandler {

    void onPartialResponse(String partialResponse);

    default void onPartialThinking(PartialThinking partialThinking) {}

    default void onPartialToolCall(PartialToolCall partialToolCall) {}

    default void onCompleteToolCall(CompleteToolCall completeToolCall) {}

    void onCompleteResponse(ChatResponse completeResponse);

    void onError(Throwable error);
}
```

| 回调 | 触发时机 |
| --- | --- |
| `onPartialResponse` | 生成出下一段文本时。据服务商不同，一段可能含一个或多个 token。UI 增量渲染写在这里 |
| `onPartialThinking` | 生成出下一段推理/思考文本时 |
| `onPartialToolCall` | 工具调用的参数正在流式输出（参数是分片到达的） |
| `onCompleteToolCall` | 某个工具调用的参数接收完毕，可以执行了 |
| `onCompleteResponse` | 整个响应生成结束，拿到完整 `ChatResponse` |
| `onError` | 发生错误 |

```java
StreamingChatModel model = OpenAiStreamingChatModel.builder()
        .apiKey(System.getenv("OPENAI_API_KEY"))
        .modelName(GPT_4_O_MINI)
        .build();

model.chat("Tell me a joke", new StreamingChatResponseHandler() {

    @Override
    public void onPartialResponse(String partialResponse) {
        System.out.print(partialResponse);   // 边生成边输出
    }

    @Override
    public void onPartialThinking(PartialThinking partialThinking) {
        System.out.println("thinking: " + partialThinking);
    }

    @Override
    public void onCompleteResponse(ChatResponse completeResponse) {
        System.out.println("\n[done] " + completeResponse.metadata().tokenUsage());
    }

    @Override
    public void onError(Throwable error) {
        error.printStackTrace();
    }
});
```

### 极简写法：LambdaStreamingResponseHandler

```java
import static dev.langchain4j.model.LambdaStreamingResponseHandler.onPartialResponse;
import static dev.langchain4j.model.LambdaStreamingResponseHandler.onPartialResponseAndError;

// 只处理部分响应
model.chat("Tell me a joke", onPartialResponse(System.out::print));

// 同时处理部分响应和错误
model.chat("Tell me a joke", onPartialResponseAndError(System.out::print, Throwable::printStackTrace));
```

### AI Service 中的流式：TokenStream

把返回类型声明为 `TokenStream` 即可，链式注册回调，最后必须调用 `start()`：

```java
interface Assistant {
    TokenStream chat(String message);
}

StreamingChatModel model = OpenAiStreamingChatModel.builder()
        .apiKey(System.getenv("OPENAI_API_KEY"))
        .modelName(GPT_4_O_MINI)
        .build();

Assistant assistant = AiServices.create(Assistant.class, model);

TokenStream tokenStream = assistant.chat("Tell me a joke");

tokenStream
    .onPartialResponse(partial -> System.out.print(partial))
    .onPartialThinking(thinking -> System.out.println(thinking))
    .onRetrieved(contents -> System.out.println(contents))           // RAG 检索到的内容
    .onIntermediateResponse(resp -> System.out.println(resp))
    .beforeToolExecution(tool -> System.out.println(tool))           // 工具执行前，含工具名与参数
    .onToolExecuted(tool -> System.out.println(tool))                // 工具执行后，含请求与结果
    .onCompleteResponse(resp -> System.out.println(resp))
    .onError(Throwable::printStackTrace)
    .start();
```

> **提示 · 流式 + 工具调用：体验提升最明显的组合**
>
> 用 `beforeToolExecution` 把「正在查询订单系统…」这类状态推给前端，用户就知道系统真的在干活，而不是卡住了。这比任何加载动画都有说服力。

### Reactor 集成：返回 Flux

响应式技术栈里可以用 `Flux<String>` 替代 `TokenStream`：

**`pom.xml`**

```xml
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-reactor</artifactId>
</dependency>
```

```java
interface Assistant {
    Flux<String> chat(String message);
}
```

> **注意 · 流式模式的三个限制**
>
> - **JSON Schema 结构化输出不支持流式**（OpenAI 侧尤其如此）。需要结构化结果就别用流式。
> - 流式下 `onCompleteToolCall` 触发即执行工具，不等响应流结束——工具的执行顺序不再有保证。
> - 部分服务商的分片边界不可控，做「逐字打字机效果」时前端要能容忍一次收到多个 token。

---

## 11 Spring Boot 集成

Spring 项目里几乎不用手写构建代码，声明式配置会替你创建 Bean。

### 依赖：命名规律要记牢

所有 starter 的命名规则是 `langchain4j-{integration-name}-spring-boot-starter`。先引入某个具体集成的 starter，再引入声明式 AI Services 的 starter。

**`pom.xml`**

```xml
<!-- ① 先用 BOM 统一版本（与第 02 章一致） -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>dev.langchain4j</groupId>
            <artifactId>langchain4j-bom</artifactId>
            <version>1.20.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <!-- ② 具体模型集成，以 OpenAI 为例 -->
    <dependency>
        <groupId>dev.langchain4j</groupId>
        <artifactId>langchain4j-open-ai-spring-boot-starter</artifactId>
    </dependency>

    <!-- ③ 声明式 AI Services 支持（@AiService） -->
    <dependency>
        <groupId>dev.langchain4j</groupId>
        <artifactId>langchain4j-spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

> **提示 · 关于 starter 的版本号**
>
> 不用手写 `<version>`。BOM 内部已经把各类集成模块映射到对应的 beta 版本线（starter 类模块为 `1.20.0-beta30`），导入 BOM 后 Maven 会自动选对版本——这也是推荐做法，能避免核心库与集成模块版本错配。

> **说明 · 版本要求**
>
> Spring Boot 集成要求 **Java 17** 与 **Spring Boot 3.2** 及以上。

### 用配置文件创建模型 Bean

**`application.properties`**

```properties
langchain4j.open-ai.chat-model.api-key=${OPENAI_API_KEY}
langchain4j.open-ai.chat-model.model-name=gpt-4o
langchain4j.open-ai.chat-model.log-requests=true
langchain4j.open-ai.chat-model.log-responses=true
```

这样 `OpenAiChatModel` 就被自动创建好了，直接注入使用：

```java
@RestController
public class ChatController {

    private final ChatModel chatModel;

    public ChatController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/chat")
    public String model(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return chatModel.chat(message);
    }
}
```

要用 `StreamingChatModel`，配置项换成 `streaming-chat-model` 前缀即可。

### @AiService：声明式 AI Service

这个注解的作用类似于 `@Service`，但自带 AI 能力。启动时 Starter 会扫描所有 `@AiService` 接口，生成实现并注册为 Bean：

```java
@AiService
interface Assistant {

    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
}

@RestController
class AssistantController {

    private final Assistant assistant;

    AssistantController(Assistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return assistant.chat(message);
    }
}
```

#### 自动组件注入

如果 Spring 上下文里存在下列组件，会被**自动注入**到 AI Service 中，无需显式声明：

- `ChatModel`、`StreamingChatModel`
- `ChatMemory`、`ChatMemoryProvider`
- `ContentRetriever`、`RetrievalAugmentor`
- 所有 `@Component` / `@Service` 类中带 `@Tool` 注解的方法

**`java · 工具类只需是普通 Bean`**

```java
@Component
public class BookingTools {

    private final BookingService bookingService;

    public BookingTools(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Tool
    public Booking getBookingDetails(String bookingNumber, String customerName, String customerSurname) {
        return bookingService.getBookingDetails(bookingNumber, customerName, customerSurname);
    }

    @Tool
    public void cancelBooking(String bookingNumber, String customerName, String customerSurname) {
        bookingService.cancelBooking(bookingNumber, customerName, customerSurname);
    }
}
// 只需标注 @Component，Assistant 便能自动用上这两个工具
```

#### 显式注入：多个模型共存时

当配置了多个 `ChatModel`，需要为不同 AI Service 指定不同模型时：

**`application.properties`**

```properties
langchain4j.open-ai.chat-model.api-key=${OPENAI_API_KEY}
langchain4j.open-ai.chat-model.model-name=gpt-4o-mini

langchain4j.ollama.chat-model.base-url=http://localhost:11434
langchain4j.ollama.chat-model.model-name=llama3.1
```

```java
@AiService(wiringMode = EXPLICIT, chatModel = "openAiChatModel")
interface OpenAiAssistant {
    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
}

@AiService(wiringMode = EXPLICIT, chatModel = "ollamaChatModel")
interface OllamaAssistant {
    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
}
```

> **提示 · 这个特性直接对应第 06 章的拆分策略**
>
> 用便宜的小模型做分类判断、贵的大模型做最终生成——在 Spring Boot 里就是两个 `@AiService` 加不同的 `chatModel`，非常干净。

### 可观测性：声明一个 Listener 就行

```java
@Configuration
class MyConfiguration {

    @Bean
    ChatModelListener chatModelListener() {
        return new ChatModelListener() {

            private static final Logger log = LoggerFactory.getLogger(ChatModelListener.class);

            @Override
            public void onRequest(ChatModelRequestContext requestContext) {
                log.info("onRequest(): {}", requestContext.chatRequest());
            }

            @Override
            public void onResponse(ChatModelResponseContext responseContext) {
                log.info("onResponse(): {}", responseContext.chatResponse());
            }

            @Override
            public void onError(ChatModelErrorContext errorContext) {
                log.info("onError(): {}", errorContext.error().getMessage());
            }
        };
    }
}
```

上下文里所有 `ChatModelListener` Bean 都会被自动注入到 Starter 创建的 `ChatModel` 与 `StreamingChatModel` 中——这是把 AI 调用接入 Micrometer / OpenTelemetry 的标准切入点。

### 监听 AI Service 注册事件

想在启动时拿到「有哪些 AI Service、各自挂了哪些工具」，可以实现 `ApplicationListener<AiServiceRegisteredEvent>`：

```java
@Component
class AiServiceRegisteredEventListener implements ApplicationListener<AiServiceRegisteredEvent> {

    @Override
    public void onApplicationEvent(AiServiceRegisteredEvent event) {
        Class<?> aiServiceClass = event.aiServiceClass();
        List<ToolSpecification> toolSpecifications = event.toolSpecifications();

        for (int i = 0; i < toolSpecifications.size(); i++) {
            System.out.printf("[%s]: [Tool-%s]: %s%n",
                    aiServiceClass.getSimpleName(), i + 1, toolSpecifications.get(i));
        }
    }
}
```

> **提示 · 一个很实用的启动自检**
>
> 用这个监听器在应用启动时把所有 Agent 暴露的工具打到日志里。工具挂载出问题（多挂了、少挂了、名字重复）是 Agent 类应用的常见故障，启动时一眼看穿比线上排查便宜得多。

### 流式接口

```java
@AiService
interface Assistant {

    @SystemMessage("You are a polite assistant")
    Flux<String> chat(String userMessage);
}
// 需要引入 langchain4j-reactor，配合 WebFlux 使用
```

---

## 12 可观测性与成本控制

AI 应用上线后，最大的运维意外通常来自两件事：不知道钱花在哪，以及不知道模型看到了什么。

### 第一层：开发期日志

始终从最简单的工具开始。构建模型时打开：

```java
ChatModel model = OpenAiChatModel.builder()
        .apiKey(System.getenv("OPENAI_API_KEY"))
        .modelName(GPT_4_O_MINI)
        .logRequests(true)
        .logResponses(true)
        .build();
```

> **说明 · 你会亲眼看到的东西**
>
> - RAG 往提示词里插了哪些片段（顺序、数量、长度一目了然）
> - 结构化输出时框架自动追加的格式指令
> - 工具定义是怎么被序列化后发给模型的
> - 模型返回的原始 JSON，而不是被解析后的对象
>
> 排查「模型为什么不按我说的做」时，这是唯一高效的手段。

### 第二层：ChatModelListener

生产环境不能靠 `System.out`。用 `ChatModelListener` 把每次调用的请求、响应、错误接入你的监控体系（第 11 章给了完整示例）。典型用途：

- 记录耗时分布，定位慢调用（长上下文、工具多次往返都会显著拉长延迟）
- 把 `TokenUsage` 打成指标，按用户/功能/模型维度聚合
- 错误率告警，捕获限流、超时、内容审核拒绝
- 采样保存请求响应，用于事后复盘与评测集建设

### 第三层：TokenUsage 与成本核算

`ChatResponseMetadata` 里的 `TokenUsage` 是计费的唯一依据，包含输入 token、输出 token 和总量。

```java
ChatResponse response = model.chat(userMessage);
TokenUsage usage = response.metadata().tokenUsage();

System.out.printf("in=%d, out=%d, total=%d%n",
        usage.inputTokenCount(), usage.outputTokenCount(), usage.totalTokenCount());
```

> **注意 · AI Service 的用量必须用 Result<T> 拿**
>
> 一次 AI Service 调用可能触发**多轮** LLM 请求（例如执行了工具）。此时 `result.tokenUsage()` 返回的是**所有轮次的累加值**，而不是最后一轮。用单次 `ChatResponse` 统计会严重低估实际成本——这是工具类 Agent 计费最容易出错的地方。

#### 成本优化的五个着力点

| 手段 | 效果 | 对应章节 |
| --- | --- | --- |
| 用 `TokenWindowChatMemory` 替代 `MessageWindowChatMemory` | 把上下文开销变成可控上限 | 05 |
| 用动态工具 `ToolProvider` 按需暴露工具 | 工具定义本身就很占 token，按需挂载收益直接 | 08 |
| 拆分 AI Service，简单任务用小模型 | 分类、判断这类任务没必要用贵模型 | 06 |
| 合理切分片段，设置 `maxResults` 与 `minScore` | 少注入无关内容，同时提升准确率 | 09 |
| 只在需要时开流式、只在开发期开日志 | 避免无谓开销 | 10 / 12 |

### 测试与评估

AI 应用的测试和传统应用不一样，可以分两层做：

- **单元测试**：AI Service 是接口，直接 mock 掉，测试你的业务编排逻辑（第 06 章的 `MilesOfSmiles` 就是范例）。
- **集成测试**：真实调用模型，验证端到端效果。官方提供了客户支持 Agent 的集成测试示例可参考。

另外因为 AI Service 是可独立调用的接口，你可以**单独为每个子任务评估并调参**（temperature、模型选择、提示词），甚至长期为特定子任务微调一个小专用模型。这是把 AI 能力真正工程化的关键——不要把一个巨型提示词当成黑盒来调。

---

## 13 工程实践与常见坑

这一章是从文档各处汇总的「踩过才知道」清单，建议上线前逐条对照。

### 最容易踩的十个坑

| # | 坑 | 正确做法 |
| --- | --- | --- |
| 1 | 同一个 `@MemoryId` 被并发调用 | 会损坏 `ChatMemory`。框架**没有任何**防并发机制。按会话 ID 串行化，或对同一 memoryId 加锁 |
| 2 | 忘记 `evictChatMemory`，内存持续增长 | 会话结束时调用清除；用 `ChatMemoryAccess` 暴露能力，或自己维护 Map 时同步移除 |
| 3 | 以为 `ChatMemory` 能当对话历史用 | 记忆会被淘汰和改写。**审计、质检、界面回放必须另行落库** |
| 4 | 结构化输出的必填规则记反了 | 结构化输出默认**全可选**（防模型编造），工具参数默认**全必填**。方向完全相反 |
| 5 | 忘记了 `supportedCapabilities(RESPONSE_FORMAT_JSON_SCHEMA)` | JSON Schema 能力**默认关闭**。不开会静默退化为纯提示模式，成功率下降但不报错 |
| 6 | 用流式接口拿结构化输出 | 不支持。需要 `POJO` / `enum` 返回类型时，AI Service 方法别声明成 `TokenStream` |
| 7 | 把 `@Description` 加在 enum 的取值上 | 无效，不会进 JSON Schema。要写就写在枚举类或字段描述上 |
| 8 | 工具参数里让模型传 userId 之类的身份标识 | 用 `@ToolMemoryId` 由框架注入。让模型决定身份＝越权风险 |
| 9 | 系统消息的内容来自用户输入 | 提示词注入的经典入口。系统消息必须由开发者定义在代码或资源文件中 |
| 10 | 在 AI Service 里期待多模态 | AI Services 目前不支持多模态。发图片/音频/PDF 必须用底层 `ChatModel` API |

### 再补几条零碎的

- `@V` 只在编译时**未开** `-parameters` 的情况下才必要。Spring Boot / Quarkus 项目不需要它。
- 没有 `@MemoryId` 参数时，`ChatMemoryProvider` 收到的 ID 是字符串 `"default"`——所有用户会共用一份记忆，多用户场景务必显式加 `@MemoryId`。
- 启用严格模式后，可选的 `enum` 字段仍可能被填入虚构值；可选的基本类型字段会被初始化为默认值（`int` 为 0、`boolean` 为 false），难以区分「模型没给」和「模型给了 0」。
- 向量库的元数据过滤能力差异很大，部分存储根本不支持过滤，支持的也未必支持全部操作符。选型前查官方对比表。
- `SqlDatabaseContentRetriever` 是实验性模块，会让 LLM 生成并执行 SQL。生产使用请配**只读账号**，并限制可访问的表。
- 集成模块普遍使用 beta 版本号（如 `1.20.0-beta30`），API 存在变动可能。用 BOM 锁死版本，升级前跑回归测试。

### 一份上线前的检查清单

- **记忆**：每会话独立、有淘汰上限、会话结束会释放、同 ID 不并发
- **成本**：TokenUsage 已按维度打点；工具类调用用 Result 统计累加值
- **安全**：系统消息不可被用户注入；身份标识用 @ToolMemoryId；工具最小权限
- **检索**：片段带标题；元数据可过滤；maxResults 与 minScore 已调优
- **可观测**：Listener 接入监控；启动时打印各 Agent 的工具清单
- **测试**：编排逻辑用 mock 单测；关键链路有真实模型的集成测试

---

## 14 学习路线与资源

### 建议的学习顺序

不要一上来就啃 RAG。这个顺序的基础是：**每一层都建立在上一层的认知上**。

| 阶段 | 目标 | 对应章节 |
| --- | --- | --- |
| 1 · 打通链路 | 能让模型回一句话，理解 ChatModel 与 ChatMessage | 01 → 02 → 03 → 04 |
| 2 · 可用对话 | 能维持多轮上下文，理解记忆与历史的区别 | 05 |
| 3 · 业务落地 | 用 AI Services 把 LLM 调用写成像本地方法调用 | 06 |
| 4 · 接结构化数据 | 能稳定抽取 JSON 到 POJO，能返回 boolean/enum 做控制流 | 07 |
| 5 · 让 AI 干活 | 会写工具、会拆多 Agent、知道怎么防止越权 | 08 |
| 6 · 用自己的数据 | 跑通 Easy RAG，再逐步替换成高级 RAG | 09 |
| 7 · 产品化 | 流式体验、Spring Boot 集成、成本与可观测性 | 10 → 11 → 12 |
| 8 · 上线 | 对照检查清单过一遍 | 13 |

> **提示 · 给你的一条建议**
>
> 每学完一章就写一个能跑的最小 demo，比通读十遍文档有用得多。尤其是**务必打开 `logRequests(true)`**——看见框架到底发了什么给模型，很多疑惑会当场消失。

### 官方资源

| 资源 | 地址 | 用途 |
| --- | --- | --- |
| 中文文档（教程） | `langchain4j.cn/tutorials` | 本教程的主要依据，逐章深入的最佳入口 |
| 英文官方文档 | `docs.langchain4j.dev` | 版本更新最快，查新特性看这里 |
| GitHub 主仓库 | `github.com/langchain4j/langchain4j` | 源码、Issue、Release Notes |
| 官方示例集 | `github.com/langchain4j/langchain4j-examples` | 可运行代码：RAG、工具、记忆、Spring Boot 全覆盖 |
| 语言模型集成清单 | `langchain4j.cn/integrations/language-models` | 各厂商能力对比表（模态支持、JSON Schema 支持） |
| 向量库集成清单 | `langchain4j.cn/integrations/embedding-stores` | 选型必看，含「按 Metadata 过滤」支持情况 |

### 官方文档的完整章节目录

本教程覆盖了主干路径。以下章节按需深入：

- **agents**：Agents 与 Agentic AI，自主性更强的编排模式
- **guardrails**：护栏机制，输入输出校验与拦截
- **mcp**：模型上下文协议，接入外部工具生态
- **model-parameters**：各模型的参数详解
- **embedding-stores**：向量库集成与选型
- **image-models**：图像生成与编辑
- **testing-and-evaluation**：测试与评估方法论
- **observability**：可观测性深度配置
- **logging**：日志配置
- **json**：JSON 编解码器定制
- **customizable-http-client**：替换底层 HTTP 客户端
- **quarkus / micronaut / helidon / payara**：非 Spring 框架的集成方案
- **kotlin**：Kotlin 支持与协程扩展（chatAsync 等）
- **classification**：文本分类

> **说明 · 关于 Kotlin 读者**
>
> LangChain4j 提供了 Kotlin 扩展，基于协程实现非阻塞调用。`ChatModel.chatAsync(request)` 会同步的 `chat` 包装到 `Dispatchers.IO` 的协程作用域中；还有类型安全的 builder DSL 版本 `ChatModel.chat { ... }`。注意这些方法标记为实验性，未来可能变化。

---

*本教程依据官方中文文档 langchain4j.cn/tutorials 整理编写，代码示例已校准至 LangChain4j 1.20.0 主线版本。API 细节请以官方文档与 Javadoc 为准。*
