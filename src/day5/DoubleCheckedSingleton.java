package day5;

public class DoubleCheckedSingleton {
    static {
        System.out.println("Class Loaded!");
    }

    private static DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
        System.out.println("Instantiated!");
    }

    public static DoubleCheckedSingleton getInstance() {
        System.out.println("getInstance Called!");

        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }

        return instance;
    }
}
