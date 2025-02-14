public class DeliveryService {

    public static void calculateDeliveryCost(int distance, boolean isLarge, boolean isFragile, String loadLevel1) throws IllegalArgumentException {
        if (isFragile && distance > 30) {
            throw new IllegalArgumentException("Хрупкие грузы нельзя возить на расстояние более 30 км");
        }
        double cost = 0;

        if (distance > 30) {
            cost += 300;
        } else if (distance > 10) {
            cost += 200;
        } else if (distance > 2) {
            cost += 100;
        } else {
            cost += 50;
        }

        cost += isLarge ? 200 : 100;

        if (isFragile) {
            cost += 300;
        }

        double coefficient = switch (loadLevel1) {
            case "ver_high", "very_high" -> 1.6;
           // case "high" -> 1.4;
            case "high" -> 1.1667;
            case "medium" -> 1.2;
            default -> 1.0;
        };

        cost *= coefficient;

    }
}
