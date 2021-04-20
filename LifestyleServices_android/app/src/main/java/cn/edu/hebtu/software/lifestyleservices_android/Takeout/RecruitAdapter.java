package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.content.Context;
import android.content.Intent;
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

public class RecruitAdapter extends BaseAdapter {
    private List<Map<String,Object>> dataSource=null;
    private Context context;
    private int item_layout_id;

    public  RecruitAdapter( Context context,List<Map<String,Object>> dataSource,int item_layout_id){
        this.context=context;
        this.dataSource=dataSource;
        this.item_layout_id=item_layout_id;
    }

    public  void addItem(Map<String,Object> newData){
        dataSource.add(newData);
        notifyDataSetChanged();
    }

    public  void deleteItem(int pos){
        dataSource.remove(pos);
        notifyDataSetChanged();
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
        Log.e("2222","2222");
        LayoutInflater inflater=LayoutInflater.from(context);
        View  newView= inflater.inflate(item_layout_id,null);
       TextView employ=newView.findViewById(R.id.employ);
       TextView emprice=newView.findViewById(R.id.emprice);
       TextView needF=newView.findViewById(R.id.needF);
       TextView needS=newView.findViewById(R.id.needS);
       ImageView eming=newView.findViewById(R.id.eming);
       TextView emtea=newView.findViewById(R.id.emtea);
       TextView emadd=newView.findViewById(R.id.emadd);
        Map<String,Object> map=dataSource.get(position);
        eming.setBackgroundResource((int)map.get("img"));
        employ.setText(map.get("employ").toString());
        emprice.setText(map.get("price").toString());
        needF.setText(map.get("needf").toString());
        needS.setText(map.get("needs").toString());
        emtea.setText(map.get("tea").toString());
        emadd.setText(map.get("address").toString());
        newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ApplyRecruitActivity.class);
                context.startActivity(intent);
            }
        });
        return  newView;
    }
}
