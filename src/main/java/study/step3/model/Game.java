package study.step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private final PlayerName name;
    private final int carCount;
    private final int raceCount;
    private final List<RacingCar> cars;

    public Game(String name, int carCount, int raceCount) {
        this(new PlayerName(name), carCount, raceCount);
    }

    public Game(PlayerName name, int carCount, int raceCount) {
        this.name = name;
        this.carCount = carCount;
        this.raceCount = raceCount;
        this.cars = initCars(carCount);
    }

    public void playOneRound(List<Integer> randomNumbers) {
        // 방어 로직: 차 대수와 전달받은 랜덤 숫자 개수가 다르면 안 됩니다.
        if (this.cars.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("자동차 수와 전달된 랜덤 값의 개수가 일치하지 않습니다.");
        }

        for (int i = 0; i < this.cars.size(); i++) {
            this.cars.get(i).move(randomNumbers.get(i));
        }
    }

    // 입력받은 자동차 수만큼 RacingCar 객체를 생성
    private List<RacingCar> initCars(int count) {
        List<RacingCar> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carList.add(new RacingCar());
        }
        return carList;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public String getStringName() {
        return this.name.getName();
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getRaceCount() {
        return this.raceCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return carCount == game.carCount && raceCount == game.raceCount && Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carCount, raceCount);
    }
}
