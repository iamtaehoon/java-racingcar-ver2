package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
	Race race = new Race();

	public void start() {
		String input = InputView.inputCarsName();
		System.out.println(input);
		List<String> names = StringUtils.parseByComma(input);
		names.stream().forEach(name -> {
			System.out.println(name);
			race.participate(new Car(name));
		});
		race.showAllCarName().stream().forEach(x -> System.out.println("x"+x));
	}
}
