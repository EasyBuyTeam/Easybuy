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
public class EbProductDao extends BaseDao {

    //所有商品；
    public List<EbProduct> getProduct(){
        List<EbProduct> productsList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_id ";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbProduct products = new EbProduct();
//                products.setEpId(rs.getInt("en_id"));
                products.setEpName(rs.getString("ep_name"));
                products.setEpPrice(rs.getDouble("ep_price"));
                products.setEpPicture(rs.getString("ep_picture"));
                products.setEpPicture1(rs.getString("ep_picture1"));
                products.setEpPicture2(rs.getString("ep_picture2"));
                //添加到集合中
                productsList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }


    //今日特价
    public List<EbProduct> getSaleOfGoods(){

        List<EbProduct> saleOfGoodsList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_id limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()) {
                if (rs.getInt("ep_selled_no")<500) {
                    EbProduct product=new EbProduct();
                    product.setEpId(rs.getInt("ep_id"));
                    product.setEpName(rs.getString("ep_name"));
                    product.setEpPrice(rs.getDouble("ep_price"));
                    product.setEpDescription(rs.getString("ep_description"));
                    product.setEpSellOn(rs.getInt("ep_selled_no"));
                    product.setEpStock(rs.getInt("ep_stock"));
                    product.setEpPicture(rs.getString("ep_picture"));
                    product.setEpPicture1(rs.getString("ep_picture1"));
                    product.setEpPicture2(rs.getString("ep_picture2"));
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
        String sql = "select * from easybuy_product order by ep_id limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                if(rs.getInt("ep_selled_no")>500){
                    EbProduct product=new EbProduct();
                    product.setEpId(rs.getInt("ep_id"));
                    product.setEpName(rs.getString("ep_name"));
                    product.setEpPrice(rs.getDouble("ep_price"));
                    product.setEpDescription(rs.getString("ep_description"));
                    product.setEpSellOn(rs.getInt("ep_selled_no"));
                    product.setEpStock(rs.getInt("ep_stock"));
                    product.setEpPicture(rs.getString("ep_picture"));
                    product.setEpPicture1(rs.getString("ep_picture1"));
                    product.setEpPicture2(rs.getString("ep_picture2"));
                    //添加到集合中
                    hotProductList.add(product);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotProductList;
    }

    // 商品详情
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
                product.setEpDescription(rs.getString("ep_description"));
                product.setEpSellOn(rs.getInt("ep_selled_no"));
                product.setEpStock(rs.getInt("ep_stock"));
                product.setEpPicture(rs.getString("ep_picture"));
                product.setEpPicture1(rs.getString("ep_picture1"));
                product.setEpPicture2(rs.getString("ep_picture2"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    /**
     * 更新商品库存
     */
    public void updateStock(int proid,int quantity){
        String sql = "update easybuy_product set ep_stock=ep_stock-? where ep_id=?";
        List<String> params = new ArrayList<String>();
        params.add(quantity+"");
        params.add(proid+"");

        this.executeModify(sql,params);
    }

    /**
     * 所有商品列表（分页）
     * @return
     */
    public List<EbProduct> getProductPager(int pageIndex,int pageSize){
        //pageIndex 1 2 3 4 5 6
        List<EbProduct> productList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product limit ?,?";
        ResultSet rs = null;
        try {
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            int start = (pageIndex * pageSize)-pageSize;
            ps.setInt(1,start);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            try {
                while(rs.next()){
                    EbProduct product = new EbProduct();
                    product.setEpcId(rs.getInt("epc_id"));
                    product.setEpcchildId(rs.getInt("epc_child_id"));
                    product.setEpDescription(rs.getString("ep_description"));
                //    product.setEpSellOn(rs.getInt("ep_discount"));
                    product.setEpfileName(rs.getString("ep_file_name"));
                    product.setEpId(rs.getInt("ep_id"));
                    product.setEpName(rs.getString("ep_name"));
                    product.setEpPrice(rs.getDouble("ep_price"));
                    product.setEpStock(rs.getInt("ep_stock"));
                    product.setEpPicture(rs.getString("ep_picture"));
                    product.setEpPicture1(rs.getString("ep_picture1"));
                    product.setEpPicture2(rs.getString("ep_picture2"));
                    //product.setEpViews(rs.getInt("ep_views"));
                    productList.add(product);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    /**
     * 所有商品数量
     * @return
     */
    public int getProductCount(){
        int count = 0;
        String sql = "select count(ep_id) from easybuy_product";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}

