package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
	public static List<String> parseByComma(String input) {
		return Arrays.asList(input.split(","));
	}
}
