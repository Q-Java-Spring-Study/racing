package study.step3;

import org.junit.jupiter.api.Test;
import study.step3.common.RandomNumber;
import study.step3.model.Game;
import study.step3.model.PlayerName;
import study.step3.model.RacingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    void 게임_생성() {
        Game game = new Game(new PlayerName("PLAYER_NAME"), 3, 5);
        assertThat(game).isNotNull();
    }

    @Test
    void 자동차_생성() {
        RacingCar car = new RacingCar();
        assertThat(car).isNotNull();
    }

    @Test
    void 값이_0_9_사이로_무작위_값_생성() {
        int randomNumber = RandomNumber.generateLimitTen();
        assertThat(randomNumber).isBetween(0, 10);
    }

    @Test
    void 랜덤_값이_3_이하일_경우_정지() {
        RacingCar car = new RacingCar();
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤_값이_4_이상일_경우_전진() {
        RacingCar car = new RacingCar();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 게임_생성시_carCount에_맞게_자동자_생성() {
        Game game = new Game(new PlayerName("PLAYER_NAME"), 3, 5);
        // Game 내부에서 만들어진 자동차 목록을 가져와서 사이즈가 3인지 검증
        assertThat(game.getCars().size()).isEqualTo(3);
    }
}
