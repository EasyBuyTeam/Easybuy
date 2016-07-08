package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Night Watch on 2016/7/6.
 */
public class EbProductDao extends BaseDao{
    public List<EbProduct> getProduct(){
        List<EbProduct> productsList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_id asc limit 0,8";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbProduct products = new EbProduct();
                //products.setEpId(rs.getInt("en_id"));
                products.setEpName(rs.getString("ep_name"));
                products.setEpPrice(rs.getInt("ep_price"));
                //添加到集合中
                productsList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }
}
