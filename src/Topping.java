public class Topping implements MenuItem{
    private String name;
    private double price;
    private boolean isExtra;

    public Topping(String name, double price, boolean isExtra){
        this.name = name;
        this.price = price;
        this.isExtra = isExtra;
    }

    public String getName(){
        return name + (isExtra? "+Extra" : "");
    }
    public double getPrice(){
        return price + (isExtra ? price/2 : 0);
    }
}
