package racingcar.domain;

import static racingcar.Constant.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        name = validate(name);
        this.name = name;
    }

    private String validate(String name) {
        name = removeBlank(name);
        if (isNull(name)) {
            throw new IllegalArgumentException("자동차의 이름으로 공백이 들어갈 수 없다.");
        }
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 한다.");
        }
        return name;
    }

    private boolean isNull(String name) {
        return name == null || name.isEmpty();
    }

    private String removeBlank(String name) {
        name = name.trim();
        return name;
    }

    public int move(int randomValue) {
        validateIsInRange(randomValue);
        if (randomValue >= MOVING_CAR_STANDARD) {
            position += 1;
        }
        return position;
    }

    private void validateIsInRange(int randomValue) {
        if (randomValue < RANDOM_MIN_VALUE || randomValue > RANDOM_MAX_VALUE) {
            throw new IllegalArgumentException("Car 객체의 move 메서드의 인자는 해당 값이 나올 수 없습니다.(0~9 사이 랜덤값)");
        }
    }

    public int getMovingDistance() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        Car temp = (Car) obj;
        if (temp.getName().equals(this.getName())) {
            return true;
        }
        return false;
    }
}
