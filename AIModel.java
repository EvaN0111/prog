package gr.aueb.dmst.ecg.eprog;

import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;

import java.io.IOException;

import static dev.langchain4j.data.message.UserMessage.userMessage;
import static dev.langchain4j.model.openai.OpenAiModelName.GPT_3_5_TURBO;

public class AIModel {
    public ChatMemory chatMemory;
    String apikey = System.getenv("API_KEY");
    public AiMessage genAnswer(String in_g, String in_oc, String in_d ) {

        ChatLanguageModel model = OpenAiChatModel.withApiKey(apikey);
        ChatMemory chatMemory = TokenWindowChatMemory.withMaxTokens(300, new OpenAiTokenizer(GPT_3_5_TURBO));
        
        UserMessage userMessage = new UserMessage("can you generate a playlist with 10 "+ in_g +" songs from the "+ in_d +"'s for "+ in_oc+ "?");
        
        AiMessage answer = model.generate(chatMemory.messages()).content();
        return answer;
    }

    public String modify(String genList) {
        genList =  genList.replaceAll("\\.\\s+", ".");
    
        int z = 0;
        for (int i = 0; i < genList.length() - 1; i++) {
            char current = genList.charAt(i);
            char next = genList.charAt(i+1);
            
            //case where num 10 is in the prologue
            if ((current == '1') && (next == '0') && (z==0)) {
                z = z + 1;
                genList = genList.substring(current , genList.length() );
                
            // case of the 1.song
            } else if ((current == '1') && (next == '.') && (z !=0 )) {
                genList = genList.substring(current-1, genList.length());   
            }
        }
        //return the final list
        genList = genList.replace(" ", "\n");
        return genList;
    }

    public void manageMemory(ChatMessage a) {
        chatMemory.add(a);
    }
}

