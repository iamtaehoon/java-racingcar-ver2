package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

	public void repeatGamePhase(Round round) {

		System.out.println("\n실행 결과");
		for (int i = 0; i < round.getRepeatCnt(); i++) {
			cars.stream().forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
			OutputView.showThisPhaseResult(cars);
		}
	}

	public void showWinners() {
		List<Car> winners = findWinner();
		OutputView.showWinners(winners);

	}

	private List<Car> findWinner() {
		int maxDistance
			= cars.stream().mapToInt(car -> car.getMovingDistance()).max().orElseThrow(NoSuchElementException::new);
		return cars.stream()
			.filter(car -> car.getMovingDistance() == maxDistance)
			.collect(Collectors.toList());

	}

	//최종 우승자를 보여주는 메서드.
}
