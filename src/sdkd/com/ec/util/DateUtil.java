package sdkd.com.ec.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SDUST-132 on 2016/7/11.
 */
public class DateUtil {
    /**
     * 将Date转换为String
     * @param date
     * @param format
     * @return
     */
    public static String parseDateToStr(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
