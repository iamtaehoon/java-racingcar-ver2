package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class OutputView {

	static void showThisPhaseResult(ArrayList<Car> cars) {
		cars.stream()
			.forEach(
				car -> System.out.println(car.getName() + " : " + StringUtils.showMovingmark(car.getMovingDistance())));
		System.out.println();
	}
}
