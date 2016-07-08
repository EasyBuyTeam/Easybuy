package sdkd.com.ec.model;

import java.util.Date;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {
    private int euID;
    private String euName;
    private String euPassword;
    private String euSex;
    private Date euBrithday;
    private String euidCode;
    private String euEmail;
    private String euMobile;
    private String euAddress;
    private String euStatue;

    public void setEuID(int euID) {
        this.euID = euID;
    }

    public void setEuName(String euName) {
        this.euName = euName;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public void setEuSex(String euSex) {
        this.euSex = euSex;
    }

    public void setEuBrithday(Date euBrithday) {
        this.euBrithday = euBrithday;
    }

    public void setEuidCode(String euidCode) {
        this.euidCode = euidCode;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public void setEuMobile(String euMobile) {
        this.euMobile = euMobile;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public void setEuStatue(String euStatue) {
        this.euStatue = euStatue;
    }

    public int getEuID() {

        return euID;
    }

    public String getEuName() {
        return euName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public String getEuSex() {
        return euSex;
    }

    public Date getEuBrithday() {
        return euBrithday;
    }

    public String getEuidCode() {
        return euidCode;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public String getEuMobile() {
        return euMobile;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public String getEuStatue() {
        return euStatue;
    }
}
