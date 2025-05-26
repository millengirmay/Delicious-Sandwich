public class Chips implements MenuItem{
    private String type;
    private double price = 1.50;

    public Chips(String type){
        this.type = type;
    }

    public String getName(){
        return type + " chips";
    }
    public double getPrice(){
        return price;
    }
}
