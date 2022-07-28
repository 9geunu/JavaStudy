package day5;

import day1.CoffeeMachine;
import day1.NuttyCoffeeBean;

public class Component {
    private final CoffeeMachine coffeeMachine;

    public Component(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void doSingletonThing() {
        LazyHolderSingleton instance = LazyHolderSingleton.getInstance();
        System.out.println(instance);
    }

    public String doCoffeeThing() {
        return coffeeMachine.getCoffee(new NuttyCoffeeBean()).toString();
    }
}
