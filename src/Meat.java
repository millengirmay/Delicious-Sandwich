public class Meat extends Topping {
    public Meat(String name) {
        super(name);
    }
    public double getPrice(String size, boolean isExtra) {
        return switch (size) {
            case Size.Four -> isExtra ? 0.5 : 1.0;
            case Size.Eight -> isExtra ? 1.0 : 2.0;
            case Size.Twelve -> isExtra ? 1.5 : 3.0;
            default -> 0;
        };
    }
    }

