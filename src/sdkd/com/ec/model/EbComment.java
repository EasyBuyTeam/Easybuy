package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by Night Watch on 2016/7/6.
 */
public class EbComment {
    private int ecId;

    public int getEcId() {
        return ecId;
    }

    public void setEcId(int ecId) {
        this.ecId = ecId;
    }

    public String getEcReply() {
        return ecReply;
    }

    public void setEcReply(String ecReply) {
        this.ecReply = ecReply;
    }

    public String getEcContent() {
        return ecContent;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent;
    }

    public Date getEccreateTime() {
        return eccreateTime;
    }

    public void setEccreateTime(Date eccreateTime) {
        this.eccreateTime = eccreateTime;
    }

    public Date getEcreplyTime() {
        return ecreplyTime;
    }

    public void setEcreplyTime(Date ecreplyTime) {
        this.ecreplyTime = ecreplyTime;
    }

    public String getEcnickName() {
        return ecnickName;
    }

    public void setEcnickName(String ecnickName) {
        this.ecnickName = ecnickName;
    }

    private String ecReply;
    private String ecContent;
    private Date eccreateTime;
    private Date ecreplyTime;
    private String ecnickName;

}
