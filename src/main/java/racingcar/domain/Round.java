package racingcar.domain;

import static racingcar.Constant.*;

public class Round {
	int repeatCnt;

	public Round(String input) {
		if (!input.matches(NUMBER_JUDGE_REGEX)) {
			throw new IllegalArgumentException("반복 횟수는 숫자가 입력되어야 합니다.");
		}
		repeatCnt = Integer.parseInt(input);
		if (repeatCnt < MIN_REPEAT_CNT) {
			throw new IllegalArgumentException("반복 횟수는 1 이상이어야 합니다.");
		}
		this.repeatCnt = repeatCnt;
	}

	public int getRepeatCnt() {
		return repeatCnt;
	}
}
