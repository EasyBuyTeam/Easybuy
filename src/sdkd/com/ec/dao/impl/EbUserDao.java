package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpy on 2016/7/7.
 */
public class EbUserDao extends BaseDao{
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
                //news.setEnId(rs.getInt("en_id"));
                //news.setEnTitle(rs.getString("en_title"));
                //添加到集合中
                usersList.add(user);
                //System.out.println();
                // usersList.get(1).
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

