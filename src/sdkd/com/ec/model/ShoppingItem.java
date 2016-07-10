package sdkd.com.ec.model;

/**
 * Created by Night Watch on 2016/7/9.
 */
public class ShoppingItem {
    private EbProduct product;
    private long quantity;
    private double cost;

    public ShoppingItem(EbProduct product, long quantity) {
        this.product = product;
        this.quantity = quantity;
        this.cost = product.getEpPrice()*quantity;
    }

    public EbProduct getProduct() {
        return product;
    }

    public void setProduct(EbProduct product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = product.getEpPrice()*quantity;
    }
}
