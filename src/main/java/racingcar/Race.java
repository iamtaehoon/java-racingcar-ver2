package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	ArrayList<Car> cars = new ArrayList<>();

	public void participate(Car car) {
		if (cars.contains(car)) {
			throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
		}
		cars.add(car);
	}

	public ArrayList<String> showAllCarName() {
		ArrayList<String> allCarsName = new ArrayList<>();
		cars.stream().forEach(car -> allCarsName.add(car.getName()));
		return allCarsName;
	}

	public void repeatGamePhase(int inputValue) {
		for (int i = 0; i < inputValue; i++) {
			cars.stream().forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
		}
	}
}