package cn.edu.hebtu.software.lifestyleservices_android.Express.util;


import cn.edu.hebtu.software.lifestyleservices_android.MyApplication;

/**
 * 公共工具类
 **/
public class CommonUtils {

    /**
     * 获取dimens定义的大小
     *
     * @param dimensionId
     * @return
     */
    public static int getPixelById(int dimensionId) {
        return MyApplication.getInstance().getResources().getDimensionPixelSize(dimensionId);
    }

}
