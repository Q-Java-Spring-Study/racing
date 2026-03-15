package study.step3.model;

import study.step3.common.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private final PlayerName name;
    private final SetCount setCount;
    private final List<RacingCar> cars;

    public Game(String name, int carCount, int raceCount) {
        this(new PlayerName(name), new SetCount(carCount, raceCount));
    }

    public Game(PlayerName name, int carCount, int raceCount) {
        this(name, new SetCount(carCount, raceCount));
    }

    public Game(PlayerName name, SetCount setCount) {
        this.name = name;
        this.setCount = setCount;
        this.cars = initCars(this.getCarCount());
    }

    public void moveAllCars() {
        for (RacingCar car : this.cars) {
            car.move(RandomNumber.generateLimitTen());
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
        return this.setCount.getCarCount();
    }

    public int getRaceCount() {
        return this.setCount.getRaceCount();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name) && Objects.equals(setCount, game.setCount) && Objects.equals(cars, game.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, setCount, cars);
    }
}
