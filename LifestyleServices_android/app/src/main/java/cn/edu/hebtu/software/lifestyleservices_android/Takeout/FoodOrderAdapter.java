package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class FoodOrderAdapter extends BaseAdapter {
    private List<Map<String,Object>> dataSource=null;
    private Context context;
    private int item_layout_id;
    public  FoodOrderAdapter( Context context,List<Map<String,Object>> dataSource,int item_layout_id){
        this.context=context;
        this.dataSource=dataSource;
        this.item_layout_id=item_layout_id;
    }
    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View  newView= inflater.inflate(item_layout_id,null);

        TextView geshu=  newView.findViewById(R.id.geshu);
        TextView tvname=  newView.findViewById(R.id.fname);
        TextView tvprice=  newView.findViewById(R.id.fprice);

        Map<String,Object> map=dataSource.get(position);
        tvname.setText(map.get("name").toString());
        tvprice.setText(map.get("price").toString());
        geshu.setText(map.get("geshu").toString());
        return  newView;
    }
}
