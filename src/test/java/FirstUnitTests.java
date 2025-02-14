import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUnitTests {

    @Test
    void sumNumbersTest() {
        int a = 3;
        int b = 2;

        int actualSum = a + b;
        int expectedSum = 5;

        assertEquals(expectedSum,actualSum);
    }
}
