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

    @Test
    void GameStarts() {
        Game game = new Game(new PlayerName(PLAYER_NAME), CAR_COUNT, RACE_COUNT);

        // Game 내부에서 만들어진 자동차 목록을 가져와서 사이즈가 3인지 검증
        assertThat(game.getCars().size()).isEqualTo(CAR_COUNT);
    }
}
