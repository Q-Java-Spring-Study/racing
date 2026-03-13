package study.step3;

import org.junit.jupiter.api.Test;
import study.step3.common.RandomNumber;
import study.step3.model.Game;
import study.step3.model.PlayerName;
import study.step3.model.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private static final int RANDOM_MIN_NUMBER = 3;
    private static final int RANDOM_MAX_NUMBER = 5;
    private static final String PLAYER_NAME = "minseon";
    private static final int CAR_COUNT = 3;
    private static final int RACE_COUNT = 5;
    private static final List<Integer> RANDOM_NUMBERS = List.of(RANDOM_MAX_NUMBER, RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);

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
    void createsCarsWithGivenCarCount() {
        Game game = new Game(new PlayerName(PLAYER_NAME), CAR_COUNT, RACE_COUNT);
        // Game 내부에서 만들어진 자동차 목록을 가져와서 사이즈가 3인지 검증
        assertThat(game.getCars().size()).isEqualTo(CAR_COUNT);
    }

    @Test
    void randomNumberGenerator() throws Exception {
        assertThat(RandomNumber.generate(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER)).isBetween(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);

        assertThatThrownBy(() -> RandomNumber.generate(-1, 10)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void carsAttemptMoveForRaceCount() throws Exception {
        Game game = new Game(new PlayerName(PLAYER_NAME), CAR_COUNT, RACE_COUNT);

        // 첫 번째 차는 전진(5), 두 번째 차는 멈춤(3), 세 번째 차는 전진(5)하도록 고정된 값 리스트 생성
        game.playOneRound(RANDOM_NUMBERS);

        // 검증
        assertThat(game.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(game.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(game.getCars().get(2).getPosition()).isEqualTo(1);
    }
}
