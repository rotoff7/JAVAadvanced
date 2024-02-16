package additionalTasks.Task3Part2;

public class Candy extends Sweets{
    private int amount;

    public Candy() {
    }

    public Candy(String name, double price, int weight, int amount) {
        super(name, price, weight);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + " Кол-во в упаковке = " + amount + ".";
    }
}
