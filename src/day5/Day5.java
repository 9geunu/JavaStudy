package day5;

import day1.Coffee;
import day1.CoffeeMachine;
import day1.DripMachine;
import day1.EspressoMachine;
import org.junit.Test;

import javax.annotation.processing.Generated;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class Day5 {

    @Test
    public void testEagerSingleton() throws InterruptedException {

        //클래스 로딩 단계에서 인스턴스가 생성되어버림
        EagerSingleton e1 = EagerSingleton.getInstance();
        System.out.println(e1);

        EagerSingleton e2 = EagerSingleton.getInstance();
        System.out.println(e2);
    }

    @Test
    public void testEagerSingletonInMultiThread() throws InterruptedException {

        //클래스 로딩 단계에서 인스턴스가 생성되지만 멀티스레드에 안전함.
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(EagerSingleton.getInstance());
                latch.countDown();
            });
        }

        latch.await();
        assertEquals(0, latch.getCount());
    }

    @Test
    public void testLazySingleton() {

        //getInstance 호출 시 인스턴스가 생성됨
        LazySingleton e1 = LazySingleton.getInstance();
        System.out.println(e1);

        LazySingleton e2 = LazySingleton.getInstance();
        System.out.println(e2);
    }

    @Test
    public void testLazySingletonInMultiThread() throws InterruptedException {

        //멀티스레드에서 여러 인스턴스가 생성되어 버림
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(LazySingleton.getInstance());
                latch.countDown();
            });
        }

        latch.await();
    }

    @Test
    public void testSynchronizedSingletonInMultiThread() throws InterruptedException {

        //멀티스레드에 안전하지만 가장 느림
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                System.out.println(SynchronizedSingleton.getInstance());
                latch.countDown();
            });
        }

        latch.await();
        assertEquals(0, latch.getCount());
    }

    @Test
    public void testDoubleCheckedSingletonInMultiThread() throws InterruptedException {

        //멀티스레드에 안전하지만 두 번째로 느림
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                System.out.println(DoubleCheckedSingleton.getInstance());
                latch.countDown();
            });
        }

        latch.await();
        assertEquals(0, latch.getCount());
    }

    /**
     * <h2>Initialization on demand holder idiom</h2>
     *
     * 이 방법은 클래스안에 클래스(Holder)를 두어 JVM의 Class Loader 매커니즘과 Class가 로드되는 시점을 이용한 방법.
     * Lazy initialization 방식을 가져가면서 Thread간 동기화문제를 동시에 해결할 수 있음.
     * 중첩클래스 Holder는 getInstance 메서드가 호출되기 전에는 참조 되지 않으며,
     * 최초로 getInstance() 메서드가 호출 될 때 클래스 로더에 의해 싱글톤 객체를 생성하여 리턴함.
     * 우리가 알아둬야 할 것은 holder 안에 선언된 instance가 static이기 때문에 클래스 로딩 시점에 한번만 호출된다는 점을 이용한 것.
     * 또 final을 써서 다시 값이 할당되지 않도록 함.
     */
    @Test
    public void testLazyHolderSingleton() {
        LazyHolderSingleton e1 = LazyHolderSingleton.getInstance();
        System.out.println(e1);

        LazyHolderSingleton e2 = LazyHolderSingleton.getInstance();
        System.out.println(e2);
    }

    @Test
    public void testLazyHolderSingletonInMultiThread() throws InterruptedException {

        //멀티스레드에 안전하고 가장 빠름
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                System.out.println(LazyHolderSingleton.getInstance());
                latch.countDown();
            });
        }

        latch.await();
        assertEquals(0, latch.getCount());
    }

    @Test
    public void testComponentDripMachine() {
        Component component = new Component(new DripMachine());

        assertEquals("드립커피", component.doCoffeeThing().split(" ")[2]);
    }

    @Test
    public void testComponentEspressoMachine() {
        Component component = new Component(new EspressoMachine());

        assertEquals("에스프레소", component.doCoffeeThing().split(" ")[2]);
    }

    @Test
    public void testComponentCafeLatteMachine() {
        Component component = new Component((coffeeBean -> new Coffee() {
            @Override
            public String toString() {
                return "d d 카페라떼";
            }
        }));

        assertEquals("카페라떼", component.doCoffeeThing().split(" ")[2]);
    }

    @Test
    public void testComponentSingleton() {

        Component component = new Component(new EspressoMachine());

        component.doSingletonThing();
    }

    @Test
    public void testDIContainer() {

        CoffeeMachine espressoMachine = DIContainer.getInstance().espressoMachine.get();
        CoffeeMachine dripMachine = DIContainer.getInstance().dripMachine.get();
    }
}
