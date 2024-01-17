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

    public String genAnswer(String in_g, String in_oc, String in_d) throws AIException {
        AiMessage answer = null;
        do {
            try {
                // open chat with AI
                ChatLanguageModel model = OpenAiChatModel.withApiKey(apikey);
                ChatMemory chatMemory = TokenWindowChatMemory.withMaxTokens(300, new OpenAiTokenizer(GPT_3_5_TURBO));

                // send appropriate prompt to AI
                UserMessage userMessage = new UserMessage(
                        "generate a playlist with 10 " + in_g + " songs from the " + in_d + "'s for " + in_oc
                                + "please do not include artists or song that include numbers in their name");
                chatMemory.add(userMessage);

                // get message from AI
                answer = model.generate(chatMemory.messages()).content();
                if (answer == null) {
                    throw new AIException("AI didnt provide answer");
                }
                chatMemory.add(answer);
            } catch (AIException e) {
                e.printStackTrace();
            }
        } while (answer == null);
        return (answer.text() != null) ? answer.text() : ""; // Check for text() to avoid NPE

    }

    // gets string from ai
    public String[] songSeperator(String str) throws Exception {
        String[] playlist = new String[10];
        for (int i=0 ; i < 10 ; i++) {
            playlist[i] = "";
        }
        try {
        
            playlist = str.split("[\\n\\r]+", 10);
            if (playlist[0] == null) {
                throw new Exception();
            } else {
                return playlist;
            }
        } catch (Exception e) {
            e.printStackTrace();
            playlist[0] = "";
            return playlist;
        }
    }

    public class AIException extends Exception {
        public AIException() {

        }
        public AIException(String a) {
            super(a);
        }
    }
}