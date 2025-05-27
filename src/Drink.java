public class Drink implements MenuItem{
    private String size;
    private double price;
    private String flavor;

    public Drink(String size, double price, String flavor){
        this.size = size;
        this.price = price;
        this.flavor = flavor;
    }

    public String getName(){
        return size + " Drink - " + flavor;
    }
    public double getPrice(){
        return price;
    }
}
