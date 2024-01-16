package gr.aueb.dmst.ecg.eprog;
//contains test for method genAnswer of AIModel

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class AIModelTest2 {

    @Test
    public void testGenAnswer() {
        AIModel aiModel = new AIModel();
        String apikey = System.getenv("API_KEY");
        String result = aiModel.genAnswer(null, null, null);
        assertThat(result).isNotNull();
        System.out.println(result);
    }
    }
