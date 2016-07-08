package sdkd.com.ec.test;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.model.EbPCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class BaseTest {
    public static void main(String[] args) {
        EbPCategoryDao category = new EbPCategoryDao();
        category.getCategory();
    }
}
