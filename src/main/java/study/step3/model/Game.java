package study.step3.model;

import java.util.List;
import java.util.Objects;

public class Game {
    private final PlayerName name;
    private final int carCount;
    private final int raceCount;

    public Game(String name, int carCount, int raceCount) {
        this(new PlayerName(name), carCount, raceCount);
    }

    public Game(PlayerName name, int carCount, int raceCount) {
        this.name = name;
        this.carCount = carCount;
        this.raceCount = raceCount;
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
