package cn.edu.hebtu.software.lifestyleservices_android.Express;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cn.edu.hebtu.software.lifestyleservices_android.Express.address.ChangeAddressPopwindow;
import cn.edu.hebtu.software.lifestyleservices_android.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReceiveActivity extends Activity {

    private LinearLayout lladdressFrom;
    private LinearLayout lladdressTo;
    private TextView tvPickupCode;
    private TextView tvName;
    private Button btnFinish;
    private TextView tvAddressFrom;
    private TextView getTvAddressTo;
    private LinearLayout llBack;
    private String pickupCode = "";
    private String name ="";
    private String phone = "";
    private String addressFrom="";
    private String addressTo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_receive);
        findview();
        setListeners();


    }

    private void setListeners() {
        MyListener myListener = new MyListener();
        lladdressFrom.setOnClickListener(myListener);
        lladdressTo.setOnClickListener(myListener);
        tvPickupCode.setOnClickListener(myListener);
        btnFinish.setOnClickListener(myListener);
        tvName.setOnClickListener(myListener);
        llBack.setOnClickListener(myListener);
    }

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_address_from:
                    ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(ReceiveActivity.this);
                    mChangeAddressPopwindow.setAddress("河北", "石家庄", "裕华区");
                    mChangeAddressPopwindow.showAtLocation(tvAddressFrom, Gravity.BOTTOM, 0, 0);
                    mChangeAddressPopwindow
                            .setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {

                                @Override
                                public void onClick(String province, String city, String area) {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(ReceiveActivity.this, province + "-" + city + "-" + area, Toast.LENGTH_LONG).show();
                                    tvAddressFrom.setText(province + city + area);
                                    addressFrom=province + city + area;
                                }
                            });
                    break;
                case R.id.ll_address_to:
                    ChangeAddressPopwindow mChangeAddressPopwindow1 = new ChangeAddressPopwindow(ReceiveActivity.this);
                    mChangeAddressPopwindow1.setAddress("河北", "石家庄", "裕华区");
                    mChangeAddressPopwindow1.showAtLocation(getTvAddressTo, Gravity.BOTTOM, 0, 0);
                    mChangeAddressPopwindow1
                            .setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {

                                @Override
                                public void onClick(String province, String city, String area) {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(ReceiveActivity.this, province + "-" + city + "-" + area, Toast.LENGTH_LONG).show();
                                    getTvAddressTo.setText(province + city + area);
                                    addressTo=province + city + area;
                                }
                            });
                    break;
                case R.id.tv_pickupCode:
                    tvPickupCode.setText("");
                    break;
                case R.id.tv_name:
                    tvName.setText("");
                    break;
                case R.id.btn_finish:
                    pickupCode = tvPickupCode.getText().toString();
                    name = tvName.getText().toString();
                    phone = "";
                    sendExpress();
                    break;
                case R.id.ll_back:
                    finish();
                    break;
            }
        }
    }

    private void sendExpress() {
//        SharedPreferences sp = getSharedPreferences(Constant.SP_NAME, MODE_PRIVATE);
//        User user = new Gson().fromJson(sp.getString(Constant.USER_KEEP_KEY, Constant.DEFAULT_KEEP_USER), User.class);
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody fb = new FormBody.Builder().add("", phone + "").add("", name + "").add("", pickupCode + "")
                .add("",addressFrom+"").add("",addressTo+"").build();
        Request request = new Request.Builder().url("").post(fb).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            /**
             * 未完待续
             * @param call
             * @param response
             * @throws IOException
             */
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String addResponse = response.body().string();
                Log.e("response", "" + addResponse);
            }
        });
    }


    public void findview() {
        lladdressFrom = findViewById(R.id.ll_address_from);
        lladdressTo = findViewById(R.id.ll_address_to);
        tvPickupCode = findViewById(R.id.tv_pickupCode);
        tvName = findViewById(R.id.tv_name);
        btnFinish = findViewById(R.id.btn_finish);
        tvAddressFrom = findViewById(R.id.tv_address_from);
        getTvAddressTo = findViewById(R.id.tv_address_to);
        llBack = findViewById(R.id.ll_back);
    }

}
