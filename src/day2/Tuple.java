package day2;

import java.util.List;

public class Tuple<F, S> {
    public final F first;
    public final S second;

    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public <K, V> Tuple<K, V> createNewTuple(K k, V v) {
        return new Tuple<>(k, v);
    }

    public static <F, S> Tuple<F, S> newInstance(F first, S second) {
        return new Tuple<>(first, second);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", firstType=" + first.getClass().getName() +
                ", second=" + second +
                ", secondType=" + second.getClass().getName() +
                '}';
    }

    static void copy(List<? extends Number> from, List<? super Number> to) {
        for(Number number : from) {
            to.add(number);
        }
    }

    public static void main(String[] args) {
        Tuple<String, Integer> tuple1 = new Tuple<>("Hello", 1);
        Tuple<Boolean, String> tuple2 = new Tuple<>(false, "World");
        Tuple<Integer, String> tuple3 = tuple1.createNewTuple(50, "Java");
        Tuple<Long, Double> tuple4 = Tuple.newInstance(0L, 0.1);

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
        System.out.println(tuple4);
    }
}
