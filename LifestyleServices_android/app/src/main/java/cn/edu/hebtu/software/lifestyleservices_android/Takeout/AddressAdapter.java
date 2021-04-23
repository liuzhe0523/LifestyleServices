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

public class AddressAdapter extends BaseAdapter {
    private List<Map<String,Object>> AddressdataSource;
    private Context context;
    private int item_layout_id;
    public  AddressAdapter( Context context,List<Map<String,Object>> dataSource,int item_layout_id){
        this.context=context;
        this.AddressdataSource=dataSource;
        this.item_layout_id=item_layout_id;
    }
    @Override
    public int getCount() {
        return AddressdataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return AddressdataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("adapter","adpter222");
        LayoutInflater inflater=LayoutInflater.from(context);
        View  newView= inflater.inflate(item_layout_id,null);

        TextView address_dizhi=  newView.findViewById(R.id.address_dizhi);
        TextView address_name=  newView.findViewById(R.id.address_name);
        TextView address_phone=  newView.findViewById(R.id.address_phone);
        ImageView address_delete=newView.findViewById(R.id.address_delete);

        Map<String,Object> map=AddressdataSource.get(position);
        address_dizhi.setText(map.get("dizhi").toString());
        address_name.setText(map.get("name").toString());
        address_phone.setText(map.get("phone").toString());
        return  newView;
    }
}

