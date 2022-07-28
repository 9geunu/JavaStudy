package day5;

public class EagerSingleton {
    static {
        System.out.println("Class Loaded!");
    }

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("Instantiated!");
    }

    public static EagerSingleton getInstance() {
        System.out.println("getInstance called!");
        return instance;
    }
}
