package sdkd.com.ec.service;

import sdkd.com.ec.dao.impl.EbOrderDao;
import sdkd.com.ec.dao.impl.EbOrderDetailDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.*;
import sdkd.com.ec.util.ConstantUtil;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/11.
 */
public class EbOrderService {

    //调用EbOrderDao & EbOrderDetailDao
    EbOrderDao orderDao = new EbOrderDao();
    EbOrderDetailDao orderDetailDao = new EbOrderDetailDao();
    EbProductDao productDao = new EbProductDao();

    /**
     * 支付订单
     * @param cart
     * @param user
     */
    public void payOrder(ShoppingCart cart, EbUser user){
        EbOrder order = new EbOrder();
        order.setEo_user_id(user.getEuID());
        order.setEo_user_name(user.getEuName());
        order.setEo_user_address(user.getEuAddress());
        order.setEo_cost(cart.getTotalCost());
        order.setEo_create_time(new Date());
        order.setEo_status(ConstantUtil.ORDER);
        order.setEo_type(ConstantUtil.ONLINEPAY);

        int genId = orderDao.saveOrder(order);   //保存订单?

        if(cart.getItems()!=null && cart.getItems().size()>0) {
            for(ShoppingCartItem item : cart.getItems()) {
                EbOrderDetail detail = new EbOrderDetail();
                detail.setEo_id(genId);   //?能否取到Order_id?
                detail.setEod_cost(item.getCost());
                detail.setEod_quantity(Integer.parseInt(item.getQuantity().toString()));
                detail.setEp_id(item.getProduct().getEpId());

                orderDetailDao.saveOrderDetail(detail);   //保存订单详情
                //更新库存
                productDao.updateStock(item.getProduct().getEpId(), Integer.parseInt(item.getQuantity().toString()));
            }
        }
    }



}
