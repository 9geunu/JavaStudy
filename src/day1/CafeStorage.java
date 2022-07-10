package day1;

import java.util.LinkedList;
import java.util.Queue;

public class CafeStorage implements Storage {
    private Queue<CoffeeBean> coffeeBeanQueue;

    public CafeStorage() {
        coffeeBeanQueue = new LinkedList<>();
    }

    @Override
    public CoffeeBean getCoffeeBean() {
        CoffeeBean coffeeBean = coffeeBeanQueue.peek();

        if (coffeeBean == null)
            orderCoffeeBean();

        return coffeeBeanQueue.poll();
    }


    public void orderCoffeeBean() {
        coffeeBeanQueue.offer(new NuttyCoffeeBean());
    }
}
