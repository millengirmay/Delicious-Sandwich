abstract class Topping {
    String name;
    public Topping(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double getPrice(String size, boolean isExtra);
}

