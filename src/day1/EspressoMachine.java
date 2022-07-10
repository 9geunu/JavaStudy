package day1;

public class EspressoMachine implements CoffeeMachine {
    @Override
    public void getCoffee(CoffeeBean coffeeBean) {
        System.out.println(coffeeBean.getFlavor() + " 쳐직이는 에스프레소가 추출되었습니다.");
    }
}
