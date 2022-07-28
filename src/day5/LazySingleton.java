package day5;

public class LazySingleton {
    static {
        System.out.println("Class Loaded!");
    }

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Instantiated!");
    }

    public static LazySingleton getInstance() {
        System.out.println("getInstance Called!");

        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }

    @Override
    public String toString() {
        return "LazySingleton instance Hash : " + instance.hashCode();
    }
}
