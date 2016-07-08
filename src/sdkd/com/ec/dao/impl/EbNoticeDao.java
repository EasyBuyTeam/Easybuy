package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNotice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Night Watch on 2016/7/7.
 */
public class EbNoticeDao extends BaseDao{
    public List<EbNotice> getNotice(){
        List<EbNotice> noticeList = new ArrayList<EbNotice>();
        String sql = "select * from easybuy_notice order by ent_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbNotice notice = new EbNotice();
                notice.setEntId(rs.getInt("ent_id"));
                notice.setEntContent(rs.getString("ent_content"));
                //添加到集合中
                noticeList.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noticeList;
    }
}
