package day5;

import day1.CoffeeMachine;
import day1.DripMachine;
import day1.EspressoMachine;

public class DIContainer {
    public Lazy<CoffeeMachine> espressoMachine = Lazy.of(EspressoMachine::new);
    public Lazy<CoffeeMachine> dripMachine = Lazy.of(DripMachine::new);

    private DIContainer() {
        System.out.println("Instantiated!");
    }

    private static final class Holder {
        private static final DIContainer instance = new DIContainer();
    }

    public static DIContainer getInstance() {
        System.out.println("getInstance Called!");

        return Holder.instance;
    }
}
