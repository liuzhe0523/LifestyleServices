package cn.edu.hebtu.software.lifestyleservices_android.Express;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.edu.hebtu.software.lifestyleservices_android.R;


public class IndexFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View newView = inflater.inflate(R.layout.fragment_index, container, false );
        LinearLayout ll_send=newView.findViewById(R.id.ll_send);
        ll_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SendActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout ll_receive=newView.findViewById(R.id.ll_receive);
        ll_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ReceiveActivity.class);
                startActivity(intent);
            }
        });
        return newView;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
    }





}