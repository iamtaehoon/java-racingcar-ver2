package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
	Race race = new Race();
	String input;

	public void start() {
		initializeGame();
		playGame();
	}

	private void playGame() {
	}

	private void initializeGame() {
		inputCarsName();
		inputRoundCnt();
	}

	private void inputRoundCnt() {
		input = InputView.inputRoundCnt();
		race.repeatGamePhase(new Round(input));
	}

	private void inputCarsName() {
		input = InputView.inputCarsName();
		List<String> names = StringUtils.parseByComma(input);
		names.stream().forEach(name -> race.participate(new Car(name)));
	}
}
