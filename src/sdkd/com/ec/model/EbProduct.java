package sdkd.com.ec.model;

/**
 * Created by Night Watch on 2016/7/6.
 */
public class EbProduct  {
    private int epId;
    private String epName;
    private String epDescription;
    private double epPrice;
    private int epStock;
    private int epcId;
    private int epcchildId;
    private String epfileName;
    private String epLook;

    private String epPicture;
    private String epPicture1;
    private String epPicture2;


    public int getEpSellOn() {
        return epSellOn;
    }

    public void setEpSellOn(int epSellOn) {
        this.epSellOn = epSellOn;
    }

    private int epSellOn;

    public String getEpLook() {
        return epLook;
    }

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

    public void setEpLook(String epLook) {
        this.epLook = epLook;
    }

    public String getEpPicture() {
        return epPicture;
    }

    public void setEpPicture(String epPicture) {
        this.epPicture = epPicture;
    }


    public String getEpPicture1() {
        return epPicture1;
    }
    public void setEpPicture1(String epPicture1) {
        this.epPicture1 = epPicture1;
    }


    public String getEpPicture2() {
        return epPicture2;
    }

    public void setEpPicture2(String epPicture2) {
        this.epPicture2 = epPicture2;
    }
}
