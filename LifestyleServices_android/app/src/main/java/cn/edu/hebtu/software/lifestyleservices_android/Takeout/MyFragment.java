package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class MyFragment extends Fragment {
    private TextView dizhi;
    private TextView jianyi;
    private TextView zhaopin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View newView = inflater.inflate(R.layout.fragment_wode, container, false );
        dizhi = newView.findViewById( R.id.my_dizhi );
        jianyi = newView.findViewById( R.id.my_jianyi );
        zhaopin = newView.findViewById( R.id.my_zhaopin );
        dizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AddressActivity.class);
                startActivity(intent);
            }
        });
        jianyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("111","jianyi");
                Intent intent=new Intent(getActivity(), AdviceActivity.class);
                startActivity(intent);
            }
        });
        zhaopin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), RecruitActivity.class);
                startActivity(intent);
            }
        });
        return newView;

    }
}
