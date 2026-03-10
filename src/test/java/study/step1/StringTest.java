package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("요구사항 1")
    void split() {

        // 1,2를 콤마로 분리하면 1과 2가 포함된 배열이 반환
        /*String input = "1,2";
        String[] result = input.split(",");*/
        assertThat("1,2".split(",")).contains("1", "2");

        // 1을 콤마로 분리하면 1만 포함된 배열이 반환
        /*input = "1";
        result = input.split(",");*/
        assertThat("1".split(",")).contains("1");

    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {

        // (1,2)에서 괄호를 제거하고 1,2를 반환한다
        /*String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);*/
        // 결과값 확인
        assertThat("(1,2)".substring(1, "(1,2)".length() - 1)).isEqualTo("1,2");

    }

    @Test
    @DisplayName("요구사항 3: 문자열의 특정 위치 문자를 가져올 때 예외가 발생하는지 확인한다")
    void charAtException() {
        // 0 1 2
        String input = "abc";

        // 예외가 발생하는지 확인 assertThatThrownBy
        // -> StringIndexOutOfBoundsException에 대한 예외가 발생하면 hasMessage 메세지 출력
        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("5");

        // 다른 예외
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                input.charAt(5);
            }).withMessageContaining("5");

    }
}
