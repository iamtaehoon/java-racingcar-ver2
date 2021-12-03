package racingcar;

import java.util.List;

public class RacingGame {
	//TODO : try/catch로 다시 입력받는거 InputView에서 처리하면 더 좋겠다. 검증을 어디서하지? 아니면 검증 클래스를 따로 만들거나
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
				race.clearIncorrectValues();
				OutputView.showErrorMessage(e);
			}
		}
	}
}
