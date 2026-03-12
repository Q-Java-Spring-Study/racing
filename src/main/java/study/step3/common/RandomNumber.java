package study.step3.common;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int DEFAULT_MIN = 1;
    private static final int DEFAULT_MAX = 10;

    public static int generate() {
        return generate(DEFAULT_MIN, DEFAULT_MAX);
    }

    public static int generate(int min, int max) {
        if (min > max) {
            return generate(max, min);
        }
        if (min == max) {
            return min;
        }
        if (min < 0 || max < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return random.nextInt(min, max + 1);
    }
}
