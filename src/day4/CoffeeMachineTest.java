package day4;


import day1.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeMachineTest {

    @Test
    public void testEspressoMachine() {
        CoffeeMachine coffeeMachine = new DripMachine();
        Coffee coffee = coffeeMachine.getCoffee(new NuttyCoffeeBean());

        assertEquals("꼬소하이 쳐직이는 에스프레소", coffee.toString());
    }
}
