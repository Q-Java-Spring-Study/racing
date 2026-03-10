package study;

import java.util.Scanner;

public class Step0Main {

    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 1. 1부터 20까지 입력 받아서 모두 더한(+) 후 콘솔에 결과 출력해보기
        int num = 0;
        while (true) {
            System.out.println("1. [1~20] 사이의 숫자를 입력하세요: ");

            // 숫자가 아닌 값이 들어왔는지 확인
            if (!scanner.hasNextInt()) {
                System.out.println("숫자만 입력해주세요.\n");
                scanner.next();
                continue;
            }
            // 숫자라면 값을 안전하게 꺼내서 범위 확인
            num = scanner.nextInt();
            if (num < 1 || num > 20) {
                System.out.println("1-20 사이의 숫자만 입력해주세요.\n");
                // 해당 위치에 scanner.next();를 쓰지 않는 이유:
                // num = scanner.nextInt(); 여기서 이미 입력을 소비하기 때문에 next()를 하면 바로 입력을 기다리는 상태가 되어버힌다.
                continue;
            }
            // 정상 데이터로 루프끝
            break;
        }
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
            System.out.println("더하는 중.. -> " + sum);
        }
        System.out.println("결과: 1부터 " + num + "까지의 합은 " + sum + "입니다.");
        System.out.println();


        // 2. 0~100점 중 입력 받은 학점 출력하기
        int score = 0;
        while (true) {
            System.out.println("2. 0~100점 중 점수를 입력하세요 (등급 출력): ");

            if(!scanner.hasNextInt()){
                System.out.println("숫자만 입력해주세요.\n");
                scanner.next();
                continue;
            }
            score = scanner.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("0-100 사이의 숫자만 입력해주세요.\n");
                continue;
            }
            break;
        }
        if (score >= 90) {
            System.out.println("A \n");
        } else if (score >= 80) {
            System.out.println("B \n");
        } else {
            System.out.println("C \n");
        }

        scanner.close();
    }
}
