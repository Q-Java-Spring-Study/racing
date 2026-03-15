package study.step3.output;

import study.step3.constant.ConsoleMessage;
import study.step3.model.Game;
import study.step3.model.RacingCar;


public class OutputMethod {

    public static void printRacingCarPositions(Game game) {
        for (RacingCar car : game.getCars()) {
            System.out.println(
                    ConsoleMessage.CAR_POSITION_MARK.getMessage()
                            .repeat(car.getPosition())
            );
        }
    }

    public static void playGame(Game game, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            System.out.println(ConsoleMessage.START_ROUND.getMessage() + (i + 1));
            if (i == raceCount - 1) {
                System.out.println(ConsoleMessage.EXECUTION_RESULT.getMessage());
            }
            game.moveAllCars();
            OutputMethod.printRacingCarPositions(game);
            System.out.println();
        }
    }
}
