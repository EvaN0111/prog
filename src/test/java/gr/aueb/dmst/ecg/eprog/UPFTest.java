package gr.aueb.dmst.ecg.eprog;

import static org.junit.Assert.*;
import org.junit.Test;

public class UPFTest {

    @Test
    public void testUqun() {
        UPF upf = new UPF();
        // Call the method under test
        String result = upf.uqun();

        // Add assertions
        assertNotNull(result);
    }

    @Test
    public void testDatain() {
        UPF upf = new UPF();
        // Call the method under test
        upf.datain("John Doe", "john_doe", "password123");
    }

    @Test
    public void testIncounters() {
        UPF upf = new UPF();
        // Call the method under test
        upf.incounters("john_doe");
    }
}
