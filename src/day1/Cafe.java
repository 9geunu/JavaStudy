package day1;

public class Cafe {
    private CoffeeMachine coffeeMachine;
    private Storage storage;

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void orderCoffee() {
        CoffeeBean coffeeBean = storage.getCoffeeBean();
        this.coffeeMachine.getCoffee(coffeeBean);
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.setStorage(new CafeStorage());
        cafe.setCoffeeMachine(new EspressoMachine());

        cafe.orderCoffee();

        cafe.setStorage(new OtherCafeStorage());

        cafe.orderCoffee();
    }
}
