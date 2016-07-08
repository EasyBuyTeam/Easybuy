package sdkd.com.ec.model;

import java.util.List;

/**
 * Created by Night Watch on 2016/7/7.
 */
public class EbPCategory {
    private int epcId;
    private String epcName;
    private int epcparentId;

    @Override
    public String toString() {
        return "EbPCategory{" +
                "epcId=" + epcId +
                ", epcName='" + epcName + '\'' +
                ", epcparentId=" + epcparentId +
                '}';
    }

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public int getEpcparentId() {
        return epcparentId;
    }

    public void setEpcparentId(int epcparentId) {
        this.epcparentId = epcparentId;
    }

    public EbPCategory(int epcId, String epcName, int epcparentId) {

        this.epcId = epcId;
        this.epcName = epcName;
        this.epcparentId = epcparentId;
    }

    public EbPCategory() {

    }

}
