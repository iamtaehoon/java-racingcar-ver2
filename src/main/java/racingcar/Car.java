package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 한다.");
        }
        this.name = name;
    }

    // 추가 기능 구현
}
