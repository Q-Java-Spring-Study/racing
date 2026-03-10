package study.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1")
    void size() {
        // Set의 크기를 확인한다. (중복 무시)
        /*int result = numbers.size();
        assertThat(result).isEqualTo(3);*/
        assertThat(numbers).hasSize(3);
    }

   /* @Test
    @DisplayName("요구사항 2")
    void containsTest() {
        // 1, 2, 3의 값이 존재하는지를 확인
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();

        // 중복 반복 되는 코드 제거
        assertThat(numbers.contains(numbers)).isTrue();
    }*/

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3}) // 이 값들이 파라미터로 한 번씩 들어감
    @DisplayName("요구사항 2")
    void contains(int input) {
        // ValueSource 덕분에 중복 코드 없이 한 줄로 처리 가능
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3")
    void containsAdvanced(int input, boolean expected) {
        // 요구사항 3: CsvSource의 값이 input과 expected에 각각 짝지어 들어옵니다.
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
