package study.step3.input;

import study.step3.common.InputMessage;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerName() {
        return getStringInput(scanner, InputMessage.INPUT_PLAYER_NAME);
    }

    public static int getCarCount() {
        return getPositiveIntInput(scanner, InputMessage.INPUT_CAR_COUNT);
    }

    public static int getRaceCount() {
        return getPositiveIntInput(scanner, InputMessage.INPUT_RACE_COUNT);
    }

    public static void scannerClose() {
        scanner.close();
    }

    private static String getStringInput(Scanner scanner, String message) {
        String value;
        while (true) {
            System.out.println(message);

            // 빈문자열 검사
            value = scanner.nextLine().trim();
            if (value.isBlank()) {
                System.out.println("Input cannot be empty. Please enter again.");
                continue;
            }

            return value; // 정상 값만 반환
        }
    }

    private static int getPositiveIntInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();

            // 빈 문자열이 들어온 경우 먼저 걸러내기
            if (input.isBlank()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }

            try {
                int value = Integer.parseInt(input); // 문자를 숫자로 변환
                if (value <= 0) {
                    System.out.println("Negative numbers are not allowed. Please enter a number greater than 0.");
                    continue;
                }
                return value; // 정상 값이면 반환
            } catch (NumberFormatException e) {
                // 숫자가 아닌 문자가 들어와서 변환에 실패한 경우
                System.out.println("Please enter numbers only.");
            }
        }
    }
}
