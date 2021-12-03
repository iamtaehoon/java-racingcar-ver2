package racingcar;

import java.util.ArrayList;

public class Race {
	ArrayList<Car> cars = new ArrayList<>();

	public void participate(Car car) {
		cars.add(car);
	}

	public ArrayList<String> showAllCarName() {
		ArrayList<String> allCarsName = new ArrayList<>();
		cars.stream().forEach(car -> allCarsName.add(car.getName()));
		return allCarsName;
	}
}
