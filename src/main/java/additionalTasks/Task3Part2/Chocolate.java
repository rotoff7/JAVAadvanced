package additionalTasks.Task3Part2;

public class Chocolate extends Sweets {
    private String companyName;

    public Chocolate() {
    }

    public Chocolate(String name, double price, int weight, String companyName) {
        super(name, price, weight);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return super.toString() + " Компания: \"" + companyName + "\".";
    }
}
