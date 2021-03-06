package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.Constant.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

class CarTest {
	@ParameterizedTest
	@ValueSource(strings = {"pobi", "car2", "3car", "kimth"})
	@DisplayName("이름이 조건을 만족할 때 정상적으로 생성되는가 확인한다.")
	void 여러개_차_이름_입력(String name) {
		assertThat(new Car(name));
	}

	@ParameterizedTest
	@ValueSource(strings = {"kimth2", "1234567"})
	@DisplayName("이름이 5글자를 넘어가 조건을 위반할 때 예외를 발생시켜야 한다.")
	void 차_이름_초과(String name) {
		assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5글자 이하여야 한다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " "})
	@DisplayName("자동차 이름으로 null값, 혹은 공백이 들어갈 수 없다.")
	void 차_이름_공백_불가(String name) {
		assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름으로 공백이 들어갈 수 없다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("랜덤값이 4 이상으로 주어지면, 차를 이동시킨다.")
	void 차_이동_랜덤값이_4이상(int randomValue) {
		Car car = new Car("pobi");
		int movingDistance = car.move(randomValue);
		assertThat(movingDistance).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("랜덤값이 4보다 작은 값으로 주어지면, 차는 이동하지 않는다.")
	void 차_이동_랜덤값이_4미만(int randomValue) {
		Car car = new Car("pobi");
		int movingDistance = car.move(randomValue);
		assertThat(movingDistance).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -10, -113, 10, 20, 412})
	@DisplayName("랜덤값이 4보다 작은 값으로 주어지면, 차는 움직이지 않는다.")
	void 차_이동_랜덤값이_불가능한_수(int randomValue) {
		Car car = new Car("pobi");
		assertThatThrownBy(() -> car.move(randomValue)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("Car 객체의 move 메서드의 인자는 해당 값이 나올 수 없습니다.(0~9 사이 랜덤값)");
	}

	@Test
	@DisplayName("자동차가 여러 번 움직인 뒤 움직인 거리를 출력한다.")
		//TODO : 테스트 결과창에 왜 DisplayName 안나오는지 확인하고 fix 하기.
	void 차_이동거리_확인() {
		Car car = new Car("pobi");
		ArrayList<Integer> randomValues = new ArrayList<>();
		for (int i = 0; i < 1000; i++) { //충분히 큰 수
			randomValues.add(Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE));
		}
		int result = (int)randomValues.stream().filter(randomValue -> randomValue >= MOVING_CAR_STANDARD).count();
		randomValues.stream().forEach(randomValue -> car.move(randomValue));
		assertThat(car.getMovingDistance()).isEqualTo(result);
	}
}