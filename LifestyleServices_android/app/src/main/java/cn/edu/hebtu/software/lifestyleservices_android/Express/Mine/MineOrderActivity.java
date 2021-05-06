package cn.edu.hebtu.software.lifestyleservices_android.Express.Mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.Express.address.ChangeAddressPopwindow;
import cn.edu.hebtu.software.lifestyleservices_android.Express.util.CustomDialogFinish;
import cn.edu.hebtu.software.lifestyleservices_android.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MineOrderActivity extends AppCompatActivity{
    private MyOrderAdapter adapter;
    private ListView listView;
    private Activity context;
    private List<Map<String,Object>> dataSource=null;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_order);
        imgBack=findViewById(R.id.iv_edit_center_exit);
        listView=findViewById(R.id.lv_my_orders);
        initData();
        adapter = new MyOrderAdapter(this, dataSource, R.layout.activity_mine_order_listview_item,MineOrderActivity.this);
        listView.setAdapter(adapter);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private  void initData(){
        int[] imgs={R.drawable.o1,R.drawable.o2};
        String[] names={"花匠集·北欧风进口藤编休闲椅","花匠集·北欧风进口手工藤编椅"};
        String[] address={"取件(国培——启智园3号）","寄件(诚朴园——一食堂)"};
        dataSource=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",imgs[i]);
            map.put("name",names[i]);
            map.put("address",address[i]);
            dataSource.add(map);
        }
    }

}
