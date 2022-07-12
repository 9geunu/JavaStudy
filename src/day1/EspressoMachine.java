package day1;

public class EspressoMachine implements CoffeeMachine {
    @Override
    public Coffee getCoffee(CoffeeBean coffeeBean) {
        return new Espresso(coffeeBean);
    }
}
