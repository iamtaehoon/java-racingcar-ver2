package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
	@ParameterizedTest
	@ValueSource(strings = {"pobi","car2","3car","kimth"})
	@DisplayName("이름이 조건을 만족할 때 정상적으로 생성되는가 확인한다.")
	void 여러개_차_이름_입력(String name) {
		Assertions.assertThat(new Car(name));
	}
}