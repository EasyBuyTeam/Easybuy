package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbComment;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/13.
 */
public class EbCommentDao extends BaseDao {
               public List<EbComment> getNews(){
                   List<EbComment> commentList=new ArrayList<>();
                   String sql = "select * from easybuy_comment order by ec_create_time desc limit 0,7";
                   try {
                       ResultSet rs = this.executeSearch(sql,null);
                       while (rs.next()){
                           EbComment comment = new EbComment();
                           comment.setEcId(rs.getInt("en_id"));
                           comment.setEcContent(rs.getString("ec_content"));
                           comment.setEccreateTime(rs.getDate("ec_create_time"));
                           comment.setEcnickName(rs.getString("ec_nick_name"));
                           comment.setEcReply(rs.getString("ec_reply"));
                           comment.setEcreplyTime(rs.getDate("ec_reply_time"));
                           //添加到集合中
                           commentList.add(comment);
                       }
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   return commentList;
               }

}
