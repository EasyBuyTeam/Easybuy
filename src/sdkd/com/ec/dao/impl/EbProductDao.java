package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
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
                products.setEpId(rs.getInt("en_id"));
                products.setEpName(rs.getString("ep_name"));
                products.setEpPrice(rs.getDouble("ep_price"));
                //添加到集合中
                productsList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }
    public List<EbProduct> getSaleOfGoods(){

        List<EbProduct> saleOfGoodsList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()) {
                if (rs.getInt("ep_selled_no")<500) {
                    EbProduct product=new EbProduct();
                    product.setEpId(rs.getInt("ep_id"));
                    product.setEpName(rs.getString("ep_name"));
                    product.setEpPrice(rs.getDouble("ep_price"));
                    product.setEpLook(rs.getString("ep_look"));
                    product.setEpSellOn(rs.getInt("ep_selled_no"));
                    product.setEpDescription(rs.getString("ep_description"));
                    product.setEpStock(rs.getInt("ep_stock"));
                    //添加到集合中
                    saleOfGoodsList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleOfGoodsList;
    }

    //热卖推荐
    public List<EbProduct> getHotProduct(){

        List<EbProduct> hotProductList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                if(rs.getInt("ep_selled_no")>500){
                    EbProduct product=new EbProduct();
                    product.setEpId(rs.getInt("ep_id"));
                    product.setEpName(rs.getString("ep_name"));
                    product.setEpPrice(rs.getDouble("ep_price"));
                    product.setEpLook(rs.getString("ep_look"));
                    product.setEpSellOn(rs.getInt("ep_selled_no"));
                    product.setEpDescription(rs.getString("ep_description"));
                    product.setEpStock(rs.getInt("ep_stock"));
                    //添加到集合中
                    hotProductList.add(product);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotProductList;
    }


    public EbProduct getProductById(int id){
        EbProduct product=new EbProduct();
        String sql = "select * from easybuy_product where ep_id=?";
        try {
            List<String> params= new ArrayList<String>();
            params.add(id+"");
            ResultSet rs = this.executeSearch(sql,params);
            while (rs.next()){
                product.setEpId(rs.getInt("ep_id"));
                product.setEpName(rs.getString("ep_name"));
                product.setEpPrice(rs.getDouble("ep_price"));
                product.setEpLook(rs.getString("ep_look"));
                product.setEpSellOn(rs.getInt("ep_selled_no"));
                product.setEpDescription(rs.getString("ep_description"));
                product.setEpStock(rs.getInt("ep_stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}

