package day2;

import day1.*;

import java.util.stream.Stream;

public class Day2 {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = Espresso::new;

        Stream<CoffeeBean> coffeeBeanStream =
                Stream.of(new NuttyCoffeeBean(), new FruityCoffeeBean(), new DecaffeinatedCoffeeBean());

        coffeeBeanStream.map(coffeeMachine::getCoffee)
                .forEach(System.out::println);
    }
}
