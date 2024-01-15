import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class UPFTest {

    @Test
    public void testUqun() {
        UPF upf = new UPF();
        GraphWelcome mockGraphWelcome = Mockito.mock(GraphWelcome.class);
        SignUp mockSignUp = Mockito.mock(SignUp.class);
        upf.setGraphWelcome(mockGraphWelcome);
        upf.setSignUp(mockSignUp);

        Mockito.when(mockGraphWelcome.unpanel()).thenReturn("john_doe");

        Mockito.when(mockSignUp.checkAvailability("john_doe")).thenReturn(false);

        String result = upf.uqun();

        assertEquals("john_doe", result);
    }
}
