package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import cn.edu.hebtu.software.lifestyleservices_android.R;

public class HeadFragment extends Fragment {
    private Banner banner;
    private ArrayList<Integer > ImgList ;
    private ArrayList<String> imageTitle;
    private  ImageView firCateen;
    private  ImageView secCateen;
    private  ImageView thirCateen;
    private  ImageView fourCateen;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View newView = inflater.inflate(R.layout.fragment_shouye, container, false );
        banner =newView.findViewById(R.id.home_play_banner);
        firCateen=newView.findViewById(R.id.first);
        secCateen=newView.findViewById(R.id.second);
        thirCateen=newView.findViewById(R.id.third);
        fourCateen=newView.findViewById(R.id.forth);
        setAdapter();
        BannerSet();
        return newView;

    }

    //跳转到菜品界面
    private void setAdapter() {
       MyListener myListener = new MyListener();
        firCateen.setOnClickListener( myListener );
        secCateen.setOnClickListener( myListener );
        thirCateen.setOnClickListener( myListener );
        fourCateen.setOnClickListener( myListener );
    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.first:
                    Intent intent = new Intent( getContext(), FoodActivity.class );
                    startActivity( intent );
                    break;
                case R.id.second:
                    Intent intent1 = new Intent( getContext(), FoodActivity.class );
                    startActivity( intent1 );
                    break;
                case R.id.third:
                    Intent intent2 = new Intent( getContext(), FoodActivity.class );
                    startActivity( intent2 );
                    break;
                case R.id.forth:
                    Intent intent3 = new Intent( getContext(), FoodActivity.class );
                    startActivity(intent3);
                    break;
            }
        }
    }



//轮播图
    private void BannerSet() {
            ImgList=new ArrayList<>();
            imageTitle=new ArrayList<>();
            ImgList.add(R.drawable.lun2);
            ImgList.add(R.drawable.lun3);
            ImgList.add(R.drawable.lun4);
            ImgList.add(R.drawable.lun1);
            imageTitle.add("谁知盘中餐");
            imageTitle.add("粒粒皆辛苦");
            imageTitle.add("光盘行动");
            imageTitle.add("节约粮食");
            banner.setImages(ImgList);
            banner.setBannerTitles(imageTitle);

        // 显示圆形指示器和标题（水平显示
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new MyLoader());
        //设置图片集合
        // banner.setImages(mImgList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(mTitleList);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
    // 图片加载器
    public class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }




}
