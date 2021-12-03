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
		race.repeatGamePhase(new Round(input));
		race.showWinners();
	}

	private void initializeGame() {
		inputCarsName();
		inputRoundCnt();
	}

	private void inputRoundCnt() {
		input = InputView.inputRoundCnt();
	}

	private void inputCarsName() {
		input = InputView.inputCarsName();
		List<String> names = StringUtils.parseByComma(input);
		names.stream().forEach(name -> race.participate(new Car(name)));
	}
}
