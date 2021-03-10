package cn.edu.hebtu.software.lifestyleservices_android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.Express.IndexFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Express.MineFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Express.OrderFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Express.enquiry.SearchFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Takeout.HeadFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Takeout.MyFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Takeout.RecordFragment;

public class TakeoutActivity extends FragmentActivity {

    private long mExitTime;


    private class MyTabSpec {
        private ImageView imageView = null;
        private TextView textView = null;
        private int normalImage;
        private int selectImage;
        private Fragment fragment = null;



        private void setSelect(boolean b) {
            if(b) {
                imageView.setImageResource(selectImage);
                textView.setTextColor(
                        Color.parseColor("#00FF00"));
            } else {
                imageView.setImageResource(normalImage);
                textView.setTextColor(
                        Color.parseColor("#000000"));
            }
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public int getNormalImage() {
            return normalImage;
        }

        public void setNormalImage(int normalImage) {
            this.normalImage = normalImage;
        }

        public int getSelectImage() {
            return selectImage;
        }

        public void setSelectImage(int selectImage) {
            this.selectImage = selectImage;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }
    }

    private Map<String, MyTabSpec> map = new HashMap<>();
    private String [] tabStrId = {"首页", "订单", "我的"};
    private Fragment curFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_takeout);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(0xff7adfb8 );
//        }
        initData();
        setListener();
        changeTab(tabStrId[0]);


    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tab_spec_1:
                    changeTab(tabStrId[0]);
                    break;
                case R.id.tab_spec_2:
                    changeTab(tabStrId[1]);
                    break;
                case R.id.tab_spec_3:
                    changeTab(tabStrId[2]);
                    break;
            }
        }
    }

    private void changeTab(String s) {
        changeFragment(s);
        changeImage(s);
    }

    private void changeFragment(String s) {
        Fragment fragment = map.get(s).getFragment();

        if(curFragment == fragment) return;

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        if(curFragment!=null)
            transaction.remove(curFragment);

        if(!fragment.isAdded()) {
            transaction.add(R.id.tab_content, fragment);
        }

        transaction.show(fragment);
        curFragment = fragment;

        transaction.commit();
    }

    private void changeImage(String s) {
        for (String key : map.keySet()) {
            map.get(key).setSelect(false);
        }
        map.get(s).setSelect(true);
    }

    private void setListener() {
        LinearLayout layout1 = findViewById(R.id.tab_spec_1);
        LinearLayout layout2 = findViewById(R.id.tab_spec_2);
        LinearLayout layout3 = findViewById(R.id.tab_spec_3);

        MyListener listener = new MyListener();
        layout1.setOnClickListener(listener);
        layout2.setOnClickListener(listener);
        layout3.setOnClickListener(listener);
    }

    private void initData() {
        map.put(tabStrId[0], new MyTabSpec());
        map.put(tabStrId[1], new MyTabSpec());
        map.put(tabStrId[2], new MyTabSpec());

        setFragment();

        findView();

        setImage();
    }

    private void setImage() {
        map.get(tabStrId[0]).setNormalImage(R.drawable.shouye);
        map.get(tabStrId[0]).setSelectImage(R.drawable.shouye1);
        map.get(tabStrId[1]).setNormalImage(R.drawable.dingdan );
        map.get(tabStrId[1]).setSelectImage(R.drawable.dingdan1);
        map.get(tabStrId[2]).setNormalImage(R.drawable.wode);
        map.get(tabStrId[2]).setSelectImage(R.drawable.wode1);
    }

    private void setFragment() {
        map.get(tabStrId[0]).setFragment(new HeadFragment());
        map.get(tabStrId[1]).setFragment(new RecordFragment());
        map.get(tabStrId[2]).setFragment(new MyFragment());

    }

    private void findView() {
        ImageView iv1 = findViewById(R.id.img_1);
        ImageView iv2 = findViewById(R.id.img_2);
        ImageView iv3 = findViewById(R.id.img_3);
        TextView tv1 = findViewById(R.id.tv_1);
        TextView tv2 = findViewById(R.id.tv_2);
        TextView tv3 = findViewById(R.id.tv_3);

        map.get(tabStrId[0]).setImageView(iv1);
        map.get(tabStrId[0]).setTextView(tv1);

        map.get(tabStrId[1]).setImageView(iv2);
        map.get(tabStrId[1]).setTextView(tv2);

        map.get(tabStrId[2]).setImageView(iv3);
        map.get(tabStrId[2]).setTextView(tv3);

    }
}

