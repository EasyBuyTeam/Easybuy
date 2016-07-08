package sdkd.com.ec.model;

/**
 * Created by Night Watch on 2016/7/6.
 */
public class EbProduct {
    private int epId;
    private String epName;
    private String epDescription;
    private double epPrice;
    private int epStock;
    private int epcId;
    private int epcchildId;
    private String epfileName;

    public int getEpId() {
        return epId;
    }

    public void setEpId(int epId) {
        this.epId = epId;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public String getEpDescription() {
        return epDescription;
    }

    public void setEpDescription(String epDescription) {
        this.epDescription = epDescription;
    }

    public double getEpPrice() {
        return epPrice;
    }

    public void setEpPrice(double epPrice) {
        this.epPrice = epPrice;
    }

    public int getEpStock() {
        return epStock;
    }

    public void setEpStock(int epStock) {
        this.epStock = epStock;
    }

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public int getEpcchildId() {
        return epcchildId;
    }

    public void setEpcchildId(int epcchildId) {
        this.epcchildId = epcchildId;
    }

    public String getEpfileName() {
        return epfileName;
    }

    public void setEpfileName(String epfileName) {
        this.epfileName = epfileName;
    }
}
