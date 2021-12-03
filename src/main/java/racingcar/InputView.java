package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	// 어차피 검증은 다른곳에서 해줌. 여기의 책임이 아님. 그래서 inputRepeatCnt 같은걸 만들어도 밑에거랑 같은 구조. 그냥 중복해서 계속 쓰는 게 나음.
	public String getInput() {
		return Console.readLine();
	}
}