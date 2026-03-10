# 자바 문법에 대한 학습 테스트

1. 1부터 20까지 입력 받아서 모두 더한(+) 후 콘솔에 결과 출력해보기
2. 0~100점 중 입력 받은 학점 출력하기

- 90 이상 : A
- 80~89 : B
- 나머지 : C

3. 가장 큰 수 구해 콘솔에 결과 출력하기
    - 아래 변수를 직접 지역변수로 선언해서 사용하세요
   ```java 
   String[] arr = {3, 7, 2, 9, 4};
   ```

4. 1부터 10중 짝수만 콘솔에 한줄로 출력하기
    - 아래 변수를 직접 지역변수로 선언해서 사용하세요
   ```java 
   String[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
   ``` 


### 힌트
- 값을 입력 받는 API는 Scanner를 이용한다.
- https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
- AI 통해 검색하기 전 > 구글링 부터 > 구글링하기 전 문서부터 찾아보는 습관 갖기 !

```java 
Scanner scanner = new Scanner(System.in);
String value = scanner.nextLine();
int number = scanner.nextInt();
```