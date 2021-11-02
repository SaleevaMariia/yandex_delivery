package delivery;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PackTest {

    @ParameterizedTest
    @MethodSource("packProvider")
    void checkSizePack(Pack pack, boolean isLarge) {
        assertEquals(isLarge, pack.isLarge());
    }

    static Stream<Arguments> packProvider() {
        return Stream.of(
                arguments(new Pack(297, 1, 1, true), true),
                arguments(new Pack(100, 100, 100, false), true),
                arguments(new Pack(296, 1, 1, true), false),
                arguments(new Pack(50, 100, 24, false), false)
        );
    }
}