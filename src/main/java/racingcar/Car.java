package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        name = validate(name);
        this.name = name;
    }

    private String validate(String name) {
        name = name.trim();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름으로 공백이 들어갈 수 없다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 한다.");
        }
        return name;
    }

    public int move(int randomValue) {
        validateIsInRange(randomValue);
        if (randomValue >= 4) {
            position += 1;
        }
        return position;
    }

    private void validateIsInRange(int randomValue) {
        if (randomValue < 0 || randomValue > 9) {
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
        if (temp.getName() == this.getName()) {
            return true;
        }
        return false;
    }
}
