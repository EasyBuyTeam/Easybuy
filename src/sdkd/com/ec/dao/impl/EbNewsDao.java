package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsDao extends BaseDao {
    public List<EbNews> getNews(){
        List<EbNews> newsList = new ArrayList<EbNews>();
        String sql = "select * from easybuy_news order by en_create_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbNews news = new EbNews();
                news.setEnId(rs.getInt("en_id"));
                news.setEnTitle(rs.getString("en_title"));
                //添加到集合中
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }
    public EbNews getNewsById(int id){

        EbNews news = new EbNews();
        String sql = "select * from easybuy_news where en_id=?";
        try {
            List<String> params= new ArrayList<String>();
            params.add(id+"");
            ResultSet rs = this.executeSearch(sql,params);
            while (rs.next()){
              news.setEnId(rs.getInt("en_id"));
                news.setEnContent(rs.getString("en_content"));
                news.setEnTitle(rs.getString("en_title"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

}
