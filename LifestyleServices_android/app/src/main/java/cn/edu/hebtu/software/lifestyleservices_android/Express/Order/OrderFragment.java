package cn.edu.hebtu.software.lifestyleservices_android.Express.Order;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;


public class OrderFragment extends Fragment {
    private OrderAdapter adapter;
    private ListView listView;
    private Activity context;
    private List<Map<String,Object>> dataSource=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View newView = inflater.inflate(R.layout.fragment_order, container, false );
        listView=newView.findViewById(R.id.lv_orders);
        initData();
        adapter = new OrderAdapter(getContext(), dataSource, R.layout.fragment_order_listview_item,getActivity());
        listView.setAdapter(adapter);
        return newView;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
    }

    private  void initData(){
        int[] imgs={R.drawable.o1,R.drawable.o3,R.drawable.o2,R.drawable.o4};
        String[] names={"花匠集·北欧风进口藤编休闲椅","笔记本电脑床上折叠懒人小桌子","花匠集·北欧风进口手工藤编椅","小苍兰洗发水套装"};
        String[] address={"取件(国培——启智园3号）","寄件(诚朴园3号——一食堂)","取件(一食堂—启智园10号)","取件(西门——诚朴园2号)"};
        String[] user={"张三—13935283045","李丽—15254891258","王强-15847952251","卢梦—15987425699"};
        dataSource=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",imgs[i]);
            map.put("name",names[i]);
            map.put("address",address[i]);
            map.put("users",user[i]);
            dataSource.add(map);
        }
    }



}