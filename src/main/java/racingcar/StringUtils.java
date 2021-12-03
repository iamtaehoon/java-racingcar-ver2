package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
	public static List<String> parseByComma(String input) {
		return Arrays.asList(input.split(","));
	}

	public static String showMovingmark(int movingDistance) {
		String string = ""; //TODO : 버퍼로 대체하기
		for (int i = 0; i < movingDistance; i++) {
			string += "-";
		}
		return string;
	}
}
