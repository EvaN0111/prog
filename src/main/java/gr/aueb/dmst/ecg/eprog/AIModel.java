package gr.aueb.dmst.ecg.eprog;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;
import static dev.langchain4j.model.openai.OpenAiModelName.GPT_3_5_TURBO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AIModel {
    public ChatMemory chatMemory;
    // use api key
    String apikey = System.getenv("API_KEY");

    public String genAnswer(String in_g, String in_oc, String in_d) {
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
                chatMemory.add(answer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (answer == null);
        return (answer.text() != null) ? answer.text() : ""; // Check for text() to avoid NPE

    }

    public void StringToList(String str) {

        // Define the pattern for digit followed by a dot and a single alphabet
        // character
        Pattern pattern = Pattern.compile("(\\d+)\\.([a-zA-Z])");

        // Create a matcher object
        Matcher matcher = pattern.matcher(str);

        // Find all matches and print them in the specified format
        while (matcher.find()) {
            // Print the matched groups in the desired format
            System.out.println(matcher.group(1) + "." + matcher.group(2));
        }

    }

    // gets string from ai
    public String[] songSeperator(String str) {

        // Define the pattern for extracting title and artist
        Pattern pattern = Pattern.compile("\\d+\\. \"(.+)\" by (.+)");

        // Create a matcher object
        Matcher matcher = pattern.matcher(str);

        // Create an array to store songs
        String[] playlist = new String[10];

        // Process each match and store in the array
        int i = 0;
        while (matcher.find() && i < 10) {
            String title = matcher.group(1);
            String artist = matcher.group(2);
            playlist[i] = title + " by " + artist;
            i++;
        }
        if (playlist[1] != null) {
            return playlist;
        } else {
            System.out.println("error null playlist");
            return playlist;
        }
    }
}
