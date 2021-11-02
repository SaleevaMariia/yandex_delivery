package delivery;

public class Pack {

    private double length;
    private double height;
    private double width;
    private boolean isFragile;

    /**
     * Create delivery.Pack
     *
     * @param length    pack length in centimeters
     * @param height    pack height in centimeters
     * @param width     pack width in centimeters
     * @param isFragile is pack fragile?
     */
    public Pack(double length, double height, double width, boolean isFragile) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.isFragile = isFragile;
    }

    public boolean isFragile() {
        return isFragile;
    }

    /**
     * Define whether pack is large
     * use https://www.ups.com/ru/ru/help-center/packaging-and-supplies/determine-billable-weight.page
     */
    public boolean isLarge() {
        return length + width * 2 + height * 2 > 300 ? true : false;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "length=" + length +
                ", height=" + height +
                ", width=" + width +
                ", isFragile=" + isFragile +
                '}';
    }
}
