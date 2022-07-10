package day1;

public class DripMachine implements CoffeeMachine {
    @Override
    public void getCoffee(CoffeeBean coffeeBean) {
        System.out.println(coffeeBean.getFlavor() + " 쳐직이는 드립커피가 추출되었습니다.");
    }
}
