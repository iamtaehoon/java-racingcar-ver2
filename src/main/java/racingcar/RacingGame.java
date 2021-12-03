package racingcar;

import java.util.List;

public class RacingGame {
	Race race = new Race();
	String input;

	public void start() {
		initializeGame();
		playGame();
	}

	private void playGame() {
		while (true) {
			try {
				race.repeatGamePhase(new Round(input));
				race.showWinners();
				return;
			} catch (IllegalArgumentException e) {
				OutputView.showErrorMessage(e);
				inputRoundCnt();
			}
		}
	}

	private void initializeGame() {
		inputCarsName();
		inputRoundCnt();
	}

	private void inputRoundCnt() {
		input = InputView.inputRoundCnt();
	}

	private void inputCarsName() {
		while (true) {
			try {
				input = InputView.inputCarsName();
				List<String> names = StringUtils.parseByComma(input);
				names.stream().forEach(name -> race.participate(new Car(name)));
				return;
			} catch (IllegalArgumentException e) {
				race.cars.clear(); //TODO: 객체가 아니라 메서드로 만들어야 함.
				OutputView.showErrorMessage(e);
			}
		}
	}
}
