package day5;

public class SynchronizedSingleton {
    static {
        System.out.println("Class Loaded!");
    }

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        System.out.println("Instantiated!");
    }

    public static synchronized SynchronizedSingleton getInstance() {
        System.out.println("getInstance Called!");

        if (instance == null) {
            instance = new SynchronizedSingleton();
        }

        return instance;
    }
}
