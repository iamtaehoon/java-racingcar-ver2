package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

	@Test
	@DisplayName("여러 자동차를 입력받아 ,로 구분한다.")
	void 입력값을_콤마로_분리() {
		List<String> names = StringUtils.parseByComma("car1,car2,sd1e,1rw2");
		assertThat(names).containsExactly("car1", "car2", "sd1e", "1rw2");
		assertThat(names).hasSize(4);
	}

}