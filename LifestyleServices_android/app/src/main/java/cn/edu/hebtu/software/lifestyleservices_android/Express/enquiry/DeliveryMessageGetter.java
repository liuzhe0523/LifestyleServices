package cn.edu.hebtu.software.lifestyleservices_android.Express.enquiry;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.edu.hebtu.software.lifestyleservices_android.Express.entity.DeliveryMessages;
import cn.edu.hebtu.software.lifestyleservices_android.Express.entity.Message;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeliveryMessageGetter {

    //异步请求监听接口
    public interface DeliveryMessageGetterListener {
        void onSuccess(DeliveryMessages deliveryMessages);

        void onFailure(String errorStr);
    }

    //okHttp
    private OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

    //异步GET请求
    public void getAsync(final String url,
                         final Map<String, String> params,
                         final DeliveryMessageGetterListener listener) {

        //构建请求URL
        String requestString = url;
        if (!params.isEmpty()) {
            requestString += "?";
            for (Map.Entry<String, String> entry : params.entrySet()) {
                requestString += entry.getKey() + "=" + entry.getValue() + "&";
            }
            requestString = requestString.substring(0, requestString.length() - 1);
        }

        //创建一个Request
        final Request request = new Request.Builder()
                .url(requestString)
                .build();

        //请求加入调度
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (e.getCause().equals(SocketTimeoutException.class)) {
                    listener.onFailure("查询超时");
                } else {
                    listener.onFailure("查询失败");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String messages = response.body().string();
                Gson gson = new Gson();
                DeliveryMessages deliveryMessages = gson.fromJson(messages, DeliveryMessages.class);
                Log.e("rr2", deliveryMessages + "");
                if (deliveryMessages != null) {
                    Log.e("rr1", deliveryMessages.toString());
                    listener.onSuccess(deliveryMessages);
                } else {
                    listener.onFailure("查询失败");
                }
            }
        });
    }

}
