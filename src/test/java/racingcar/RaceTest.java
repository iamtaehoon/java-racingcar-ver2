package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

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

	@Test
	void 참가_자동차_이름_중복() {
		Race race = new Race();
		String[] names = {"pobi", "car2", "3car", "kimth", "pobi", "qwer"};
		assertThatThrownBy(() -> Arrays.stream(names).forEach(name -> race.participate(new Car(name))))
			.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차의 이름은 중복될 수 없습니다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {1,20,100,2})
	void 입력받는_횟수만큼_반복(int round) { //검증 어떻게 하지.... 문제가 안생겼다는 게 검증이 된건가,.?
		Race race = new Race();
		String[] names = {"pobi", "car2", "3car", "kimth"};
		for (String name : names) {
			race.participate(new Car(name));
		}
		race.repeatGamePhase(round);
	}
}