package sdkd.com.ec.model;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ShoppingCartItem {

    private  EbProduct product;
    private   Long quantity;
    private  double cost;

    public  ShoppingCartItem(EbProduct product, long quantity){

        this.quantity=quantity;
        this.product=product;
        this.cost=product.getEpPrice()*quantity;

    }

    public  Long getQuantity() {
        return quantity;
    }

    public void setQuantity( Long quantity) {
        this.quantity = quantity;
        this.cost=product.getEpPrice()*quantity;
    }

    public EbProduct getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    public void setProduct(EbProduct product) {
        this.product = product;
    }



}
