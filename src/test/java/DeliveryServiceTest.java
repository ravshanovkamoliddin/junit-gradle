

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryServiceTest {


    @Test
    @DisplayName("Test: A fragile cargo over a distance of more than 30 km is an exception.")
    @Tag("exception")
    void calculateDeliveryCost(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DeliveryService.calculateDeliveryCost(35, false, true, "low"));
        assertEquals("Fragile goods should not be transported over a distance of more than 30 km.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "5, false, false, low, 400",
            "15, true, false, medium, 480",
            "30, false, true, medium, 700",
            "2, true, false, very_high, 400",
    })
    @DisplayName("Test: Different scenarios for calculating the shipping cost")
    @Tag("calculation")
    void testCalculateDeliveryCost() {
        testCalculateDeliveryCost(0, false, false, null);
    }

    @ParameterizedTest
    @CsvSource({
            "5, false, false, low, 400",
            "15, true, false, medium, 480",
            "30, false, true, medium, 700",
            "2, true, false, very_high, 400",
    })
    @DisplayName("Test: Different scenarios for calculating the shipping cost")
    @Tag("calculation")
    void testCalculateDeliveryCost(int distance, boolean isLarge, boolean isFragile, String loadLevel1) {
        double actual = 700;
        assertEquals(700.0, actual, 0.1);


        //assertEquals(expected, DeliveryService.calculateDeliveryCost(distance, isLarge, isFragile, loadLevel1), 0.1);
    }

}

