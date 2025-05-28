public class Chips {
    private String type;

    public Chips(String type){
        this.type = type;
    }

    public double getPrice(){
        return 1.50;
    }

    public String toString(){
        return type + " chips - $1.50";
    }
}
