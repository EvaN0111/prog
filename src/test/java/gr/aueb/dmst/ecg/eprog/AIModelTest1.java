package gr.aueb.dmst.ecg.eprog;

import static dev.langchain4j.model.openai.OpenAiModelName.GPT_3_5_TURBO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;

import static org.assertj.core.api.Assertions.assertThat;

public class AIModelTest1 {
    private ChatMemory chatMemory;
    @BeforeEach
    public void setUp() {
        chatMemory = TokenWindowChatMemory.withMaxTokens(300, new OpenAiTokenizer(GPT_3_5_TURBO));
        UserMessage defMessage = new UserMessage("hi");
        this.chatMemory.add(defMessage);
    }

    @Test
    void should_generate_answer_and_return_token_usage_and_finish_reason_stop() {
        
        ChatLanguageModel model = OpenAiChatModel.withApiKey(System.getenv("API_KEY"));
        UserMessage userMessage = new UserMessage("generate a playlist with 10 pop songs from 2000 for a party");

        AiMessage answer = model.generate(chatMemory.messages()).content();
        System.out.println(answer);
        
        assertThat(answer.text()).isNotBlank();        
    }

}
