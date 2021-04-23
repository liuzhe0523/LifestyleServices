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

public class FoodAdapter extends BaseAdapter {
    private List<Map<String,Object>> dataSource=null;
    private Context context;
    private int item_layout_id;
    private  int num;
    public  FoodAdapter( Context context,List<Map<String,Object>> dataSource,int item_layout_id){
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
        Log.e("222","222");
        LayoutInflater inflater=LayoutInflater.from(context);
        View  newView= inflater.inflate(item_layout_id,null);

        ImageView jia=  newView.findViewById(R.id.jia);
       final ImageView jian=  newView.findViewById(R.id.jian);
       final TextView geshu=  newView.findViewById(R.id.geshu);

        ImageView impic=  newView.findViewById(R.id.pic);
        TextView tvname=  newView.findViewById(R.id.fname);
        TextView tvnumber=  newView.findViewById(R.id.fnumber);
        TextView tvprice=  newView.findViewById(R.id.fprice);
        final Map<String,Object> map=dataSource.get(position);
        impic.setImageResource ((int)map.get("img"));;
        tvname.setText(map.get("name").toString());
        tvnumber.setText(map.get("number").toString());
        tvprice.setText(map.get("price").toString());

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jian.setVisibility(View.VISIBLE);
                geshu.setVisibility(View.VISIBLE);
                num=Integer.parseInt(geshu.getText().toString());
                num=num+1;
                geshu.setText(String.valueOf(num));
                Log.e("jia",num+"");
                Log.e("jia",String.valueOf(num));
                map.put("geshu",String.valueOf(num));
                FoodActivity.countData(dataSource);

            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=Integer.parseInt(geshu.getText().toString());
                if (num-1==0){
                    jian.setVisibility(View.INVISIBLE);
                    geshu.setVisibility(View.INVISIBLE);
                    geshu.setText(String.valueOf(0));
                    map.put("geshu",String.valueOf(0));
                }
                else{
                    num=num-1;
                    geshu.setText(String.valueOf(num));
                    map.put("geshu",String.valueOf(num));
                }
                Log.e("jian",num+"");
                Log.e("jian",String.valueOf(num));
                FoodActivity.countData(dataSource);
            }
        });
        return  newView;
    }
}
