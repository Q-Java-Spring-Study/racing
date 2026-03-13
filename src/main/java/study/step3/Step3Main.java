package study.step3;

import study.step3.common.OutputMessage;
import study.step3.input.InputView;
import study.step3.model.Game;
import study.step3.output.OutputMethod;

import java.util.List;


public class Step3Main {
    public static void main(String[] args) {

        String playerName = InputView.getPlayerName();
        int carCount = InputView.getCarCount();
        int raceCount = InputView.getRaceCount();

        // 게임 시작
        Game game = new Game(playerName, carCount, raceCount);

        // 실행 및 출력
        for (int i = 0; i < raceCount; i++) {
            System.out.println("Start Round: " + (i + 1));
            if (i == raceCount - 1) {
                System.out.println(OutputMessage.EXECUTION_RESULT);
            }

            // 1. carCount 크기만큼의 랜덤 숫자 리스트 생성
            List<Integer> randomNumberList = OutputMethod.getRandomList(game.getCars().size());

            // 2. game.playOneRound(랜덤리스트) 호출 (한 번의 호출로 모든 차가 1회 이동 완료됨)
            game.playOneRound(randomNumberList);

            // 3. 현재 자동차들의 위치에 맞춰 "-" 출력
            OutputMethod.printRacingCarPosition(game);

            // 4. 한 줄 띄우기
            System.out.println();
        }

        System.out.println(game.getStringName() + "'s Game Over!");
        InputView.scannerClose();
    }
}

