package cn.edu.hebtu.software.lifestyleservices_android.Express;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.lifestyleservices_android.Express.address.ChangeAddressPopwindow;
import cn.edu.hebtu.software.lifestyleservices_android.R;

public class ReceiveActivity extends Activity {

    private LinearLayout lladdressFrom;
    private LinearLayout lladdressTo;
    private TextView tvPickupCode;
    private TextView tvName;
    private Button btnFinish;
    private TextView tvAddressFrom;
    private TextView getTvAddressTo;
    private LinearLayout llBack;

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
                    mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
                    mChangeAddressPopwindow.showAtLocation(tvAddressFrom, Gravity.BOTTOM, 0, 0);
                    mChangeAddressPopwindow
                            .setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {

                                @Override
                                public void onClick(String province, String city, String area) {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(ReceiveActivity.this, province + "-" + city + "-" + area, Toast.LENGTH_LONG).show();
                                    tvAddressFrom.setText(province + city + area);
                                }
                            });
                    break;
                case R.id.ll_address_to:
                    ChangeAddressPopwindow mChangeAddressPopwindow1 = new ChangeAddressPopwindow(ReceiveActivity.this);
                    mChangeAddressPopwindow1.setAddress("广东", "深圳", "福田区");
                    mChangeAddressPopwindow1.showAtLocation(getTvAddressTo, Gravity.BOTTOM, 0, 0);
                    mChangeAddressPopwindow1
                            .setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {

                                @Override
                                public void onClick(String province, String city, String area) {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(ReceiveActivity.this, province + "-" + city + "-" + area, Toast.LENGTH_LONG).show();
                                    getTvAddressTo.setText(province + city + area);
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
                    String pickupCode = tvPickupCode.getText().toString();
                    String name = tvName.getText().toString();
                    String phone = "";
                    break;
                case R.id.ll_back:
                    finish();
                    break;
            }
        }
    }

    public void findview() {
        lladdressFrom = findViewById(R.id.ll_address_from);
        lladdressTo = findViewById(R.id.ll_address_to);
        tvPickupCode = findViewById(R.id.tv_pickupCode);
        tvName = findViewById(R.id.tv_name);
        btnFinish = findViewById(R.id.btn_finish);
        tvAddressFrom = findViewById(R.id.tv_address_from);
        getTvAddressTo = findViewById(R.id.tv_address_to);
        llBack=findViewById(R.id.ll_back);
    }

}
