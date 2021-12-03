package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

	@Test
	void 참가하는_자동차들_모두_저장() {
		Race race = new Race();
		String[] names = {"pobi", "car2", "3car", "kimth"};
		for (String name : names) {
			race.participate(new Car(name));
		}
		ArrayList<String> allCarsName = race.showAllCarName();
		assertThat(allCarsName).containsExactly("pobi", "car2", "3car", "kimth");
		assertThat(allCarsName).hasSize(4);
	}
}