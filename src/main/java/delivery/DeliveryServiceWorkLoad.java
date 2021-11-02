package delivery;

public enum DeliveryServiceWorkLoad {

    VERY_HIGH(1.6), HIGH(1.4), EXTRA(1.2), USUAL(1);

    private double index;

    DeliveryServiceWorkLoad(double index) {
        this.index = index;
    }

    public double getIndex() {
        return index;
    }
}
