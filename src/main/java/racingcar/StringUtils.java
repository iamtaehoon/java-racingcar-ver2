package racingcar;

import static racingcar.Constant.*;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
	public static List<String> parseByComma(String input) {
		if (input.endsWith(CAR_NAME_SPLIT_REGEX)) {
			throw new IllegalArgumentException("자동차의 이름으로 공백이 들어갈 수 없다.");
		}
		return Arrays.asList(input.split(CAR_NAME_SPLIT_REGEX));
	}

	public static String showMovingmark(int movingDistance) {
		String string = ""; //TODO : 버퍼로 대체하기
		for (int i = 0; i < movingDistance; i++) {
			string += "-";
		}
		return string;
	}
}
