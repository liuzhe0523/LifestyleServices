package cn.edu.hebtu.software.lifestyleservices_android.Express.enquiry;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.Express.entity.DeliveryMessages;
import cn.edu.hebtu.software.lifestyleservices_android.Express.entity.Message;
import cn.edu.hebtu.software.lifestyleservices_android.R;


public class SearchFragment extends Fragment implements DeliveryMessageGetter.DeliveryMessageGetterListener {

    public List<Map<String, String>> mQueryData = new ArrayList<>();
    public SimpleAdapter mQueryAdapter;
    public Spinner mDeliveryCompanySpinner;
    public EditText mDeliveryNoEditText;
    public ProgressDialog mQueryWaitDialog;
    public Button queryButton;
    public ListView messagesListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View newView = inflater.inflate(R.layout.fragment_enquiry, container, false);
        findView(newView);

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //没有输入快递单号
                if (0 == mDeliveryNoEditText.getText().length()) {
                    Toast.makeText(getActivity(), "请输入快递单号", Toast.LENGTH_SHORT).show();
                    return;
                }

                //创建ProgressDialog对象
                mQueryWaitDialog = new ProgressDialog(getActivity());
                mQueryWaitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mQueryWaitDialog.setMessage("正在查询...");
                mQueryWaitDialog.show();

                //准备请求参数
                int selectedPosition = mDeliveryCompanySpinner.getSelectedItemPosition();
                String deliveryCompanyName =
                        getResources().getStringArray(R.array.delivery_company)[selectedPosition];
                Map<String, String> params = new HashMap<>();
                params.put("type", ((MyApplication) getActivity().getApplication()).getDeliveryCompanyNo(deliveryCompanyName));
                params.put("postid", mDeliveryNoEditText.getText().toString());

                //清空数据
                mQueryData.clear();

                //发送请求
                DeliveryMessageGetter getter = new DeliveryMessageGetter();
                getter.getAsync(getResources().getString(R.string.query_url), params, new DeliveryMessageGetter.DeliveryMessageGetterListener() {
                    @Override
                    public void onSuccess(DeliveryMessages deliveryMessages) {
                        List<Message> messages = deliveryMessages.getData();
                        Log.e("rr2", messages.toString());
                        for (Message message : messages) {
                            Map<String, String> map = new HashMap<>();
                            map.put("time", message.getTime());
                            map.put("context", message.getContext());
                            mQueryData.add(map);
                        }

                        queryComplete("查询完成");
                    }

                    @Override
                    public void onFailure(String errorStr) {
                        final String hint = errorStr;
                        queryComplete("查询失败");
                    }
                });
            }
        });

        mQueryAdapter = new SimpleAdapter(getContext(), mQueryData, R.layout.fragment_enquiry_listview_item, new String[]{"time", "context"}, new int[]{R.id.time_text_view, R.id.context_text_view});
        messagesListView.setAdapter(mQueryAdapter);

        return newView;
    }

    @Override
    public void onSuccess(DeliveryMessages deliveryMessages) {
        List<Message> messages = deliveryMessages.getData();
        Log.e("rr2", messages.toString());
        for (Message message : messages) {
            Map<String, String> map = new HashMap<>();
            map.put("time", message.getTime());
            map.put("context", message.getContext());
            mQueryData.add(map);
        }

        queryComplete("查询完成");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void findView(View view) {
        mDeliveryCompanySpinner = (Spinner) view.findViewById(R.id.delivery_company_spinner);
        mDeliveryNoEditText = (EditText) view.findViewById(R.id.delivery_no_edit_text);
        queryButton = (Button) view.findViewById(R.id.query_button);
        messagesListView = (ListView) view.findViewById(R.id.messages_list_view);
    }

    @Override
    public void onFailure(String errorStr) {
        final String hint = errorStr;
        queryComplete("查询失败");
    }


    public void queryComplete(final String toast) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mQueryAdapter.notifyDataSetChanged();
                mQueryWaitDialog.dismiss();
                Toast.makeText(getContext(), toast, Toast.LENGTH_SHORT).show();
            }
        });
    }

}