package additionalTasks.Task3Part2;

public class Lemonade extends Sweets {
    private int volume;

    public Lemonade() {
    }

    public Lemonade(String name, double price, int weight, int volume) {
        super(name, price, weight);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + " Объем = " + volume + ".";
    }
}
