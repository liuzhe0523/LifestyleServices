package cn.edu.hebtu.software.lifestyleservices_android.Express.enquiry;

import cn.edu.hebtu.software.lifestyleservices_android.R;
import android.app.Application;
import java.util.HashMap;
import java.util.Map;

//主要通过资源，使用表驱动法动态构建一个快递公司中文名与请求时候的公司编码的映射表。
public class MyApplication extends Application {

    private Map<String, String> mDeliveryCompanyTable = new HashMap<>();

    public String getDeliveryCompanyNo(String deliveryCompanyName) throws RuntimeException {

        if (mDeliveryCompanyTable.isEmpty()) {
            String[] names = getResources().getStringArray(R.array.delivery_company);
            String[] ids = getResources().getStringArray(R.array.delivery_company_id);

            if (names.length != ids.length) {
                throw new RuntimeException();
            }

            for (int i = 0; i < names.length; i++) {
                mDeliveryCompanyTable.put(names[i], ids[i]);
            }
        }

        return mDeliveryCompanyTable.get(deliveryCompanyName);
    }
}