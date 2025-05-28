public class Drink {
    String size;
    String flavor;

    public Drink(String size, String flavor){
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice(){
        return switch(size){
            case DrinkSize.Small -> 2.00;
            case DrinkSize.Medium -> 2.50;
            case DrinkSize.Large -> 3.00;
            default -> 0.0;
        };
    }

    public String toString(){
        return size + "drink ("+ flavor + ")-$" + String.format("%.2f", getPrice());
    }
}
