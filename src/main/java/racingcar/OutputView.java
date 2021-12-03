package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class OutputView {

	static void showThisPhaseResult(ArrayList<Car> cars) {
		cars.stream()
			.forEach(
				car -> System.out.println(car.getName() + " : " + StringUtils.showMovingmark(car.getMovingDistance())));
		System.out.println();
	}

	public static void showWinners(List<Car> winners) {
		String string = "최종 우승자 : ";
		for (Car winner : winners) {
			string += winner.getName();
			if (winner != winners.get(winners.size() - 1)) {
				string += ", ";
			}
		}
		System.out.println(string);
	}
}
