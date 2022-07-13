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

    public Coffee orderCoffee() {
        CoffeeBean coffeeBean = storage.getCoffeeBean();
        return this.coffeeMachine.getCoffee(coffeeBean);
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.setStorage(new CafeStorage());
        cafe.setCoffeeMachine(new EspressoMachine());

        System.out.println(cafe.orderCoffee());

        cafe.setStorage(new OtherCafeStorage());

        System.out.println(cafe.orderCoffee());
    }
}
