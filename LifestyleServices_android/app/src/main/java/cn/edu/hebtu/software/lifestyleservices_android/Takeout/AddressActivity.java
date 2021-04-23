package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class AddressActivity extends Activity {
    public static List<Map<String,Object>> AddressdataSource;
    private ImageView address_return;
    private ListView listView;
    private  AddressAdapter addressAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_wode);

        address_return=findViewById(R.id.address_return);
        listView=findViewById(R.id.address_list);

        initData();
        addressAdapter = new AddressAdapter(AddressActivity.this, AddressdataSource, R.layout.listview_address_item);
        listView.setAdapter(addressAdapter);

        address_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private  void initData(){
        String[] addresss={"河北师范大学启智园三号楼","师大西门蓝调理发馆"};
        String[] names={"王女士","王女士"};
        String[] phones={"15262785637","15262785637"};
        AddressdataSource=new ArrayList<>();
        for(int i=0;i<addresss.length;i++){
            Log.e("address便利","bianli111");
            Map<String,Object> map=new HashMap<>();
            map.put("dizhi",addresss[i]);
            map.put("name",names[i]);
            map.put("phone",phones[i]);
            AddressdataSource.add(map);
        }
    }
}
