package gr.aueb.dmst.ecg.eprog;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;
import static dev.langchain4j.model.openai.OpenAiModelName.GPT_3_5_TURBO;

public class AIModel {
    public ChatMemory chatMemory;
    // use api key
    String apikey = System.getenv("API_KEY");

    public String genAnswer(String in_g, String in_oc, String in_d) {
        try {
            // open chat with AI
            ChatLanguageModel model = OpenAiChatModel.withApiKey(apikey);
            ChatMemory chatMemory = TokenWindowChatMemory.withMaxTokens(300, new OpenAiTokenizer(GPT_3_5_TURBO));

            // send appropriate prompt to AI
            UserMessage userMessage = new UserMessage(
                    "generate a playlist with 10 " + in_g + " songs from the " + in_d + "'s for " + in_oc);
            chatMemory.add(userMessage);

            // get message from AI
            AiMessage answer = model.generate(chatMemory.messages()).content();
            chatMemory.add(answer);
            return answer.text();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
