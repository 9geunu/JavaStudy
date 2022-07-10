package day1;

import java.util.LinkedList;
import java.util.Queue;

public class OtherCafeStorage implements Storage {
    private Queue<CoffeeBean> coffeeBeanQueue;

    public OtherCafeStorage() {
        this.coffeeBeanQueue = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            coffeeBeanQueue.offer(new FruityCoffeeBean());
        }
    }

    @Override
    public CoffeeBean getCoffeeBean() {
        return coffeeBeanQueue.poll();
    }
}
