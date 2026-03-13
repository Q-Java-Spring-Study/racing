package study.step3.output;

import study.step3.common.RandomNumber;
import study.step3.model.Game;
import study.step3.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class OutputMethod {

    public static List<Integer> getRandomList(int size) {
        List<Integer> randomNumberList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomNumberList.add(RandomNumber.generate());
        }
        return randomNumberList;
    }

    public static void printRacingCarPosition(Game game) {
        for (RacingCar car : game.getCars()) {
            System.out.println("-".repeat(car.getPosition()));
        }
    }


}
