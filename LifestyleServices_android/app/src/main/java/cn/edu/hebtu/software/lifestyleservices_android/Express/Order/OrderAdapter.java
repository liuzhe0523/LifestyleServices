package cn.edu.hebtu.software.lifestyleservices_android.Express.Order;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;


public class OrderAdapter extends BaseAdapter {
    private PopupWindow popupWindow = null;
    private View popupView = null;
    private List<Map<String,Object>> dataSource=null;
    private Context context;
    private Activity activity;
    private int item_layout_id;
    public OrderAdapter(Context context, List<Map<String,Object>> dataSource, int item_layout_id, Activity activity){
        this.context=context;
        this.dataSource=dataSource;
        this.activity=activity;
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
        ImageView img=  newView.findViewById(R.id.img_order);
        TextView  name=  newView.findViewById(R.id.tv_order_name);
        TextView address=newView.findViewById(R.id.tv_order_address);
        Button btn=newView.findViewById(R.id.btn_jiedan);
        final Map<String,Object> map=dataSource.get(position);
        img.setImageResource ((int)map.get("img"));;
        name.setText(map.get("name").toString());
        address.setText(map.get("address").toString());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupView(v);
            }
        });



        return  newView;
    }

    private void showPopupView(View v) {
        popupView = LayoutInflater.from(context).inflate(R.layout.custom_popview, null);
        popupWindow = new PopupWindow(popupView, dip2px(context, 300), dip2px(context, 200), true);
        //设置PopupWindow显示内容视图
        popupWindow.setContentView(popupView);
        //设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(false);
        //设置PopupWindow是否能响内部点击事件
        popupWindow.setTouchable(true);
        TextView btnOk = popupView.findViewById(R.id.btn_pop_ok);
        TextView btnCancel = popupView.findViewById(R.id.btn_pop_cancel);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
    }
    //  将物理像素装换成真实像素
    private int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
