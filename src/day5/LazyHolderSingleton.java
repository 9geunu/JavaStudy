package day5;

public class LazyHolderSingleton {
    static {
        System.out.println("Class Loaded!");
    }

    private LazyHolderSingleton() {
        System.out.println("Instantiated!");
    }

    private static final class Holder {
        private static final LazyHolderSingleton instance = new LazyHolderSingleton();
    }

    public static LazyHolderSingleton getInstance() {
        System.out.println("getInstance Called!");

        return Holder.instance;
    }
}
