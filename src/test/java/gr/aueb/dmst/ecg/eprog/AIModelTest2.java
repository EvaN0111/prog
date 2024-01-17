package gr.aueb.dmst.ecg.eprog;
//contains test for method genAnswer of AIModel

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import gr.aueb.dmst.ecg.eprog.AIModel.AIException;

import static org.assertj.core.api.Assertions.assertThat;
public class AIModelTest2 {

    @Test
    public void testGenAnswer() {
        AIModel aiModel = new AIModel();
        String apikey = System.getenv("API_KEY");
        String result = null;
        assertThat(aiModel).isNotNull();
        try {
            // Testing the answer generation with a valid API key
            result = aiModel.genAnswer(null, null, null);
        } catch (AIException a) {
            
        }
        
        assertThat(result).isNotNull();
        System.out.println(result);
    }
}
