package sxtlal.allenlucas.yohodemo.View;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import sxtlal.allenlucas.yohodemo.Adapter.ViewPagerAdapter;
import sxtlal.allenlucas.yohodemo.Bean.Bean;
import sxtlal.allenlucas.yohodemo.MyAppliction;
import sxtlal.allenlucas.yohodemo.R;

/**
 * Created by AllenLucas on 2016/6/12.
 */
public class AutoViewPager implements ViewPager.OnPageChangeListener {
    private List<Bean> ViewPagerlist;
    private Context context;
    private List<ImageView> list;
    public ViewPager viewpager;
    public   AdvertThread thread;
    private Handler handler;
    private MyAppliction myAppliction = new MyAppliction();
    private LinearLayout mlinear;
    private ViewPagerAdapter adapter;


    public AutoViewPager(List<Bean> viewPagerlist, Context context, List<ImageView> list, ViewPager viewpager, Handler handler,LinearLayout mlinear) {
        ViewPagerlist = viewPagerlist;
        this.context = context;
        this.list = list;
        this.viewpager = viewpager;
        this.handler = handler;
        this.mlinear=mlinear;
//        myAppliction = (MyAppliction) context.getApplicationContext();
    }

    public int currentPosition = 0;
    public boolean isAlive = true;//控制线程是否存在
    public boolean isRunning = true;//控制是否自动轮播
    public void loadiamge() {
        for (int i =0;i<ViewPagerlist.size();i++){
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(context).load(myAppliction.IMGURL+ViewPagerlist.get(i).getImgpath()).into(imageView);
            list.add(imageView);
        }
        viewpagerAdapter();
    }
    private void viewpagerAdapter() {
        adapter = new ViewPagerAdapter(list,ViewPagerlist,context);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(ViewPagerlist.size()*200);
        currentPosition = viewpager.getCurrentItem();
        viewpager.addOnPageChangeListener(this);
        startThread();
    }
    public void startThread(){
        if (thread==null){
            thread = new AdvertThread();
            thread.start();
        }
    }
    public void stopThread(){
        isAlive = false;
        isRunning = false;
        thread = null;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
        checkPoint(currentPosition%ViewPagerlist.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case ViewPager.SCROLL_STATE_DRAGGING:
                isRunning = false;
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                isRunning = true;
                break;
        }
    }

    private class AdvertThread extends Thread{
        @Override
        public void run() {
            super.run();
            while (isAlive){
                if(isRunning){
                    handler.sendEmptyMessage(-1);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    //创建小白点
    public void creatDot() {
        for(int i =0;i <ViewPagerlist.size();i++){
            ImageView imgdot = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            imgdot.setLayoutParams(params);
            mlinear.addView(imgdot);

        }
        checkPoint(0);
    }
    //滑动时小白点选取
    private void checkPoint(int i) {
        for(int i1 =0;i1 < ViewPagerlist.size();i1++){
            ImageView img = (ImageView) mlinear.getChildAt(i1);
            if(i==i1){
                img.setImageResource(R.mipmap.tabmain_dot_icon_unselect);
            }else {
                img.setImageResource(R.mipmap.tabmain_dot_icon);
            }
        }
    }
}
