package study.step3.model;

public class RacingCar {
    private static final int FORWARD_CONDITION = 4;
    private int position = 0;

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_CONDITION){
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
