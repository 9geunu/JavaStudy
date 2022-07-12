package day1;

public class Espresso implements Coffee{
    private final CoffeeBean coffeeBean;

    public Espresso(CoffeeBean coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    @Override
    public String toString() {
        return coffeeBean.getFlavor() + " 쳐직이는 에스프레소";
    }
}
