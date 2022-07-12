package day1;

public class DripMachine implements CoffeeMachine {
    @Override
    public Coffee getCoffee(CoffeeBean coffeeBean) {
        return new DripCoffee(coffeeBean);
    }
}
