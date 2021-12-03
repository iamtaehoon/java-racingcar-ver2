package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.StringUtils;
import racingcar.domain.Car;

public class OutputView {

	public static void showThisPhaseResult(ArrayList<Car> cars) {
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

	public static void showErrorMessage(IllegalArgumentException e) {
		System.out.println("[ERROR] : " + e.getMessage());
	}

	public static void showSentenceBeforeGame() {
		System.out.println("\n실행 결과");
	}
}
