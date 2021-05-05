package cn.edu.hebtu.software.lifestyleservices_android.Express;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.lifestyleservices_android.Express.util.DataCleanManager;
import cn.edu.hebtu.software.lifestyleservices_android.R;


public class MineFragment extends Fragment {
    //编辑资料
    private RelativeLayout rlChangeMsg;
    //推荐给好友
    private RelativeLayout rlShare;
    //意见反馈
    private RelativeLayout rlSuggest;
    //关于我们
    private RelativeLayout rlAboutUs;
    //隐私协议
    private RelativeLayout rlSecret;
    //检测更新
    private RelativeLayout rlCheck;
    //用户协议
    private RelativeLayout rlUserDeal;
   //清空缓存
    private RelativeLayout rlCleanCache;
    private TextView tvCacheSize;
    //安全退出
    private Button btnSafeOut;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View newView = inflater.inflate(R.layout.fragment_mine, container, false );
        findViews(newView);

        //意见反馈
         rlSuggest.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//                 Intent intent = new Intent(newView.getContext(), FeedbackActivity.class);
//                 startActivity(intent);
             }
         });

        //清空缓存
       rlCleanCache.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder adBuilder = new AlertDialog.Builder(newView.getContext());
               adBuilder.setTitle("确定清空数据");
               adBuilder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       cleanCache(newView);
                       Toast.makeText(newView.getContext(), "清理成功", Toast.LENGTH_SHORT).show();
                       tvCacheSize.setText(getCacheSize(newView));
                   }
               });
               adBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       // 选中“取消”按钮，取消界面
                   }
               });
               adBuilder.create().show();
           }
       });
        //安全退出
         btnSafeOut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//                 Intent intent = new Intent(EidtCenterActivity.this, LoginActivity.class);
//                 cleanSp();
//                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                 /* intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);*/
//                 // ListenIndexActivity.activity.finish();
//                 startActivity(intent);
//                 Toast.makeText(getApplication(), "退出成功", Toast.LENGTH_SHORT).show();
//                 //finish();
             }
         });
        return newView;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
    }


    //获取缓存大小
    private String getCacheSize(View newView) {
        String str = "";
        try {
            str = DataCleanManager.getTotalCacheSize(newView.getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    //清空缓存
    private void cleanCache(View newView) {
        DataCleanManager.clearAllCache(newView.getContext());
    }

    // 清空SharedPreferences数据
//    private void cleanSp() {
//        SharedPreferences sp = getSharedPreferences(Constant.SP_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putBoolean(Constant.AUTO_LOGIN_KEY, false);
//        editor.commit();
//    }

    private void findViews(View view) {
        rlChangeMsg = view.findViewById(R.id.rl_edit_center_change_my_msg);
        rlShare = view.findViewById(R.id.rl_edit_center_share);
        rlSuggest =view. findViewById(R.id.rl_edit_center_back_suggest);
        rlAboutUs = view.findViewById(R.id.rl_edit_center_about_us);
        rlSecret = view.findViewById(R.id.rl_edit_center_secret);
        rlCheck = view.findViewById(R.id.rl_edit_center_check_update);
        rlUserDeal = view.findViewById(R.id.rl_edit_center_user_deal);
        btnSafeOut = view.findViewById(R.id.btn_safe_exit);
        rlCleanCache = view.findViewById(R.id.rl_edit_center_clean_cache);
        tvCacheSize =view. findViewById(R.id.tv_size_cache);
    }

}