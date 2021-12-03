package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
	@ParameterizedTest
	@ValueSource(strings = {"pobi","car2","3car","kimth"})
	@DisplayName("이름이 조건을 만족할 때 정상적으로 생성되는가 확인한다.")
	void 여러개_차_이름_입력(String name) {
		assertThat(new Car(name));
	}

	@ParameterizedTest
	@ValueSource(strings = {"kimth2","1234567"})
	@DisplayName("이름이 5글자를 넘어가 조건을 위반할 때 예외를 발생시켜야 한다.")
	void 차_이름_초과(String name) {
		assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5글자 이하여야 한다.");
	}
}