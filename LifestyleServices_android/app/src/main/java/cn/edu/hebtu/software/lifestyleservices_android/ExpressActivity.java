package cn.edu.hebtu.software.lifestyleservices_android;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
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
import cn.edu.hebtu.software.lifestyleservices_android.Express.address.Order.OrderFragment;
import cn.edu.hebtu.software.lifestyleservices_android.Express.enquiry.SearchFragment;


public class ExpressActivity extends FragmentActivity {

    private long mExitTime;

    private class MyTabSpec {
        private ImageView imageView = null;
        private TextView textView = null;
        private int normalImage;
        private int selectImage;
        private Fragment fragment = null;

        private void setSelect(boolean b) {
            if (b) {
                imageView.setImageResource(selectImage);
                textView.setTextColor(Color.parseColor("#f17d66"));
            } else {
                imageView.setImageResource(normalImage);
                textView.setTextColor(Color.parseColor("#000000"));
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
    private String[] tabStrId = {"首页", "查询", "订单", "我的"};
    private Fragment curFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(0xff7adfb8);
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

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_index:
                    changeTab(tabStrId[0]);
                    break;
                case R.id.ll_search:
                    changeTab(tabStrId[1]);
                    break;
                case R.id.ll_order:
                    changeTab(tabStrId[2]);
                    break;
                case R.id.ll_me:
                    changeTab(tabStrId[3]);
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

        if (curFragment == fragment) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (curFragment != null)
            transaction.remove(curFragment);

        if (!fragment.isAdded()) {
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
        LinearLayout layout1 = findViewById(R.id.ll_index);
        LinearLayout layout2 = findViewById(R.id.ll_search);
        LinearLayout layout3 = findViewById(R.id.ll_order);
        LinearLayout layout4 = findViewById(R.id.ll_me);

        MyListener listener = new MyListener();
        layout1.setOnClickListener(listener);
        layout2.setOnClickListener(listener);
        layout3.setOnClickListener(listener);
        layout4.setOnClickListener(listener);
    }

    private void initData() {
        map.put(tabStrId[0], new MyTabSpec());
        map.put(tabStrId[1], new MyTabSpec());
        map.put(tabStrId[2], new MyTabSpec());
        map.put(tabStrId[3], new MyTabSpec());

        setFragment();

        findView();

        setImage();
    }

    private void setImage() {
        map.get(tabStrId[0]).setNormalImage(R.drawable.index0);
        map.get(tabStrId[0]).setSelectImage(R.drawable.index1);
        map.get(tabStrId[1]).setNormalImage(R.drawable.search0);
        map.get(tabStrId[1]).setSelectImage(R.drawable.search1);
        map.get(tabStrId[2]).setNormalImage(R.drawable.order0);
        map.get(tabStrId[2]).setSelectImage(R.drawable.order1);
        map.get(tabStrId[3]).setNormalImage(R.drawable.me0);
        map.get(tabStrId[3]).setSelectImage(R.drawable.me1);
    }

    private void setFragment() {
        map.get(tabStrId[0]).setFragment(new IndexFragment());
        map.get(tabStrId[1]).setFragment(new SearchFragment());
        map.get(tabStrId[2]).setFragment(new OrderFragment());
        map.get(tabStrId[3]).setFragment(new MineFragment());

    }

    private void findView() {
        ImageView iv1 = findViewById(R.id.iv_index);
        ImageView iv2 = findViewById(R.id.iv_search);
        ImageView iv3 = findViewById(R.id.iv_order);
        ImageView iv4 = findViewById(R.id.iv_me);
        TextView tv1 = findViewById(R.id.tv_index);
        TextView tv2 = findViewById(R.id.tv_search);
        TextView tv3 = findViewById(R.id.tv_order);
        TextView tv4 = findViewById(R.id.tv_me);

        map.get(tabStrId[0]).setImageView(iv1);
        map.get(tabStrId[0]).setTextView(tv1);

        map.get(tabStrId[1]).setImageView(iv2);
        map.get(tabStrId[1]).setTextView(tv2);

        map.get(tabStrId[2]).setImageView(iv3);
        map.get(tabStrId[2]).setTextView(tv3);

        map.get(tabStrId[3]).setImageView(iv4);
        map.get(tabStrId[3]).setTextView(tv4);
    }
}




