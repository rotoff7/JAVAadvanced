package additionalTasks.Task3Part2;

public class Sweets {
    private String name;
    private double price;
    private int weight;

    public Sweets() {
    }
    public Sweets(String name, double price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ". Цена: " + price + ", Вес: " + weight + ".";
    }
}
