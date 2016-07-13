package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpy on 2016/7/7.
 */
public class EbUserDao extends BaseDao {
    /**
     * 用户登录
     * @param uname
     * @param pwd
     * @return
     */
    public EbUser login(String uname,String pwd){
        EbUser user = null;
        String sql = "select * from easybuy_user where eu_user_name = ? and eu_password = ?";
        List<String> params = new ArrayList<String>();
        params.add(uname);
        params.add(pwd);
        List<EbUser> userList = this.buildList(sql,params);
        if(userList!=null && userList.size()>0){
            user = userList.get(0);
        }
        return user;
    }

    /**
     * 独立获取结果集
     * @param
     * @return
     */
    private List<EbUser> buildList(String sql, List<String> params){
        List<EbUser> userList = new ArrayList<EbUser>();
        ResultSet rs = this.executeSearch(sql,params);
        try {
            while(rs.next()){
                EbUser user = new EbUser();
                user.setEuID(rs.getString("eu_user_id"));
                user.setEuName(rs.getString("eu_user_name"));
                user.setEuPassword(rs.getString("eu_password"));
                user.setEuSex(rs.getString("eu_sex"));
                user.setEuAddress(rs.getString("eu_address"));
                user.setEuBrithday(rs.getDate("eu_birthday"));
                user.setEuEmail(rs.getString("eu_email"));
                user.setEuidCode(rs.getString("eu_identity_code"));
                user.setEuStatue(rs.getString("eu_status"));
                user.setEuMobile(rs.getString("eu_mobile"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private Object Sring;

    public List<EbUser> getUser(){
        List<EbUser> usersList = new ArrayList<EbUser>();
        String sql = "select * from easybuy_user order by eu_user_id ";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbUser user = new EbUser();
                user.setEuName(rs.getString("eu_user_name"));
                user.setEuPassword(rs.getString("eu_password"));
                user.setEuStatue(rs.getString("eu_status"));

                //添加到集合中
                usersList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
    public void setUser(int useId,String useName,String passWord){
        // String sql = "insert into  easybuy_user(eu_user_id) value(useId) ";
        String sql = "insert into  easybuy_user(eu_user_id,eu_user_name,eu_password) value(?,?,?) ";
        List<String> list = new ArrayList<String>();
        list.add(useId+"");
        list.add(useName);
        list.add(passWord);

        this.exeucteModify(sql, list);
    }















}

