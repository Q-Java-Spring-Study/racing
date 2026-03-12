package study.step3;

import org.junit.jupiter.api.Test;
import study.step3.common.RandomNumber;
import study.step3.model.Game;
import study.step3.model.PlayerName;
import study.step3.model.RacingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private static final int RANDOM_MIN_NUMBER = 3;
    private static final int RANDOM_MAX_NUMBER = 5;
    private static final String PLAYER_NAME = "minseon";
    private static final int CAR_COUNT = 3;
    private static final int RACE_COUNT = 5;

    @Test
    void carDoesNotMove_whenRandomNumberLessThanFour() {
        RacingCar car = new RacingCar();
        car.move(RANDOM_MIN_NUMBER);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void carMoves_whenRandomNumberGreaterOrEqualFour() {
        RacingCar car = new RacingCar();
        car.move(RANDOM_MAX_NUMBER);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
