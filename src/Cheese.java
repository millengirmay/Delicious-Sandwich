public class Cheese extends Topping{
    public Cheese(String name){
        super(name);
    }

    public double getPrice(String size, boolean isExtra){
        return switch(size){
            case Size.Four -> isExtra ? 0.3: 0.75;
            case Size.Eight -> isExtra ? 0.6: 1.5;
            case Size.Twelve -> isExtra ? 0.9: 2.25;
            default -> 0;
        };
    }
}
