package delivery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeliveryCostTest {

    private DeliveryCost deliveryCost = new DeliveryCost();

    @ParameterizedTest
    @MethodSource("dataProvider")
    void checkCalculationOfDeliveryCost(double distance, Pack pack, DeliveryServiceWorkLoad workLoad, double cost) {
        assertEquals(cost, deliveryCost.calculateDeliveryCost(distance, pack, workLoad));
    }

    @Test
    void checkRefusalForFragilePackInLongDistance() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                deliveryCost.calculateDeliveryCost(
                        30.1,
                        new Pack(100, 100, 100, true),
                        DeliveryServiceWorkLoad.EXTRA));
        assertEquals("Fragile pack can't be delivered over a distance of 30km", exception.getMessage());
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                arguments(10, new Pack(100, 100, 100, true), DeliveryServiceWorkLoad.HIGH, 980),
                arguments(31, new Pack(30, 30, 30, false), DeliveryServiceWorkLoad.EXTRA, 480),
                arguments(2, new Pack(30, 30, 30, true), DeliveryServiceWorkLoad.VERY_HIGH, 800),
                arguments(1.1, new Pack(30, 30, 30, false), DeliveryServiceWorkLoad.HIGH, 400),
                arguments(9.9, new Pack(100, 100, 100, false), DeliveryServiceWorkLoad.USUAL, 400),
                arguments(400, new Pack(100, 100, 100, false), DeliveryServiceWorkLoad.VERY_HIGH, 800),
                arguments(11, new Pack(30, 30, 30, false), DeliveryServiceWorkLoad.USUAL, 400),
                arguments(29, new Pack(100, 100, 100, true), DeliveryServiceWorkLoad.EXTRA, 840),
                arguments(3, new Pack(100, 100, 100, true), DeliveryServiceWorkLoad.EXTRA, 720),
                arguments(1, new Pack(100, 100, 100, true), DeliveryServiceWorkLoad.VERY_HIGH, 880),
                arguments(0.5, new Pack(100, 100, 100, true), DeliveryServiceWorkLoad.USUAL, 550),
                arguments(2, new Pack(30, 30, 30, true), DeliveryServiceWorkLoad.HIGH, 700),
                arguments(0.5, new Pack(100, 100, 100, true), DeliveryServiceWorkLoad.EXTRA, 660),
                arguments(45, new Pack(30, 30, 30, false), DeliveryServiceWorkLoad.HIGH, 560),
                arguments(10, new Pack(30, 30, 30, true), DeliveryServiceWorkLoad.VERY_HIGH, 960)
        );
    }

}