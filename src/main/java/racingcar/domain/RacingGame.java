package racingcar.domain;

import java.util.List;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.StringUtils;

public class RacingGame {
	Race race = new Race();
	Round round;
	String input;

	public void start() {
		initializeGame();
		playGame();
	}

	private void playGame() {
		race.repeatGamePhase(round);
		race.showWinners();
	}

	private void initializeGame() {
		inputCarsName();
		inputRoundCnt();
	}

	private void inputRoundCnt() {
		try {
			input = InputView.inputRoundCnt();
			round = new Round(input);
		} catch (IllegalArgumentException e) {
			OutputView.showErrorMessage(e);
			inputRoundCnt();
		}
	}

	private void inputCarsName() {
		try {
			input = InputView.inputCarsName();
			List<String> names = StringUtils.parseByComma(input);
			names.stream().forEach(name -> race.participate(new Car(name)));
		} catch (IllegalArgumentException e) {
			race.clearIncorrectValues();
			OutputView.showErrorMessage(e);
			inputCarsName();
		}
	}
}
