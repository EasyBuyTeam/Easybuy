package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by Night Watch on 2016/7/7.
 */
public class EbNotice {
    private int entId;
    private String entContent;
    private Date entTime;
    private String entInfo;

    public EbNotice(int entId, String entContent, Date entTime, String entInfo) {
        this.entId = entId;
        this.entContent = entContent;
        this.entTime = entTime;
        this.entInfo = entInfo;
    }

    public EbNotice() {

    }

    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    public String getEntContent() {
        return entContent;
    }

    public void setEntContent(String entContent) {
        this.entContent = entContent;
    }

    public Date getEntTime() {
        return entTime;
    }

    public void setEntTime(Date entTime) {
        this.entTime = entTime;
    }

    public String getEntInfo() {
        return entInfo;
    }

    public void setEntInfo(String entInfo) {
        this.entInfo = entInfo;
    }
}
