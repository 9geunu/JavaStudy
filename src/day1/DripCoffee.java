package day1;

public class DripCoffee implements Coffee {
    private final CoffeeBean coffeeBean;

    public DripCoffee(CoffeeBean coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    @Override
    public String toString() {
        return coffeeBean.getFlavor() + " 쳐직이는 드립커피";
    }
}
