package delivery;

import java.text.DecimalFormat;

public class DeliveryCost {

    /**
     * Calculate cost for delivery
     *
     * @param distance distance to the destination in kilometers
     * @param pack     pack to deliver
     * @param workLoad current workload of the delivery service
     * @return cost of delivery in rubles
     */
    public double calculateDeliveryCost(double distance, Pack pack, DeliveryServiceWorkLoad workLoad) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (pack.isFragile() && distance > 30)
            throw new RuntimeException("Fragile pack can't be delivered over a distance of 30km");

        double cost = calculateDistanceCost(distance);
        cost += pack.isLarge() ? 200 : 100;
        cost += pack.isFragile() ? 300 : 0;
        cost *= workLoad.getIndex();
        cost = cost > 400 ? cost : 400;
        return Double.parseDouble(decimalFormat.format(cost));
    }

    private int calculateDistanceCost(double distance) {
        if (distance < 2)
            return 50;
        else if (distance < 10)
            return 100;
        else if (distance < 30)
            return 200;
        else return 300;
    }

}
