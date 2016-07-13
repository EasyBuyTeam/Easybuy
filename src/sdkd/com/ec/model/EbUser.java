package sdkd.com.ec.model;

import java.util.Date;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {
    private String euID;
    private String euName;
    private String euPassword;
    private String euSex;
    private Date euBrithday;
    private String euidCode;
    private String euEmail;
    private String euMobile;
    private String euAddress;
    private String euStatue;

    public String getEuID() {
        return euID;
    }

    public void setEuID(String euID) {
        this.euID = euID;
    }

    public String getEuName() {
        return euName;
    }

    public void setEuName(String euName) {
        this.euName = euName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public String getEuSex() {
        return euSex;
    }

    public void setEuSex(String euSex) {
        this.euSex = euSex;
    }

    public Date getEuBrithday() {
        return euBrithday;
    }

    public void setEuBrithday(Date euBrithday) {
        this.euBrithday = euBrithday;
    }

    public String getEuidCode() {
        return euidCode;
    }

    public void setEuidCode(String euidCode) {
        this.euidCode = euidCode;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public String getEuMobile() {
        return euMobile;
    }

    public void setEuMobile(String euMobile) {
        this.euMobile = euMobile;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public String getEuStatue() {
        return euStatue;
    }

    public void setEuStatue(String euStatue) {
        this.euStatue = euStatue;
    }
}
