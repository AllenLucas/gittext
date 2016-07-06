package sxtlal.allenlucas.yohodemo.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

import sxtlal.allenlucas.yohodemo.MyAppliction;
import sxtlal.allenlucas.yohodemo.R;
import sxtlal.allenlucas.yohodemo.Bean.Bean;
import sxtlal.allenlucas.yohodemo.Utils.FileUtils;
import sxtlal.allenlucas.yohodemo.Utils.JsonUtils;
import sxtlal.allenlucas.yohodemo.Utils.RequestUtils;
import sxtlal.allenlucas.yohodemo.View.AutoViewPager;

/**
 * Created by AllenLucas on 2016/6/3.
 */
public class OneFragment extends Fragment implements View.OnClickListener, Animation.AnimationListener{
    private ImageView title;
    private ImageView twotitle;
    private RelativeLayout titlelayout;
    private ScaleAnimation animation_title1,animation_title2;
    private ViewPager viewpager;
    private String loacl;
    private FileUtils fileUtils;
    private List<Bean> ViewPagerlist = new ArrayList<>();
    private List<ImageView> list = new ArrayList<>();
    private LinearLayout mlinear;
    private RelativeLayout mrelaout;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==a){
                String x = (String) msg.obj;
                fileUtils.savejson(x.trim(),"data"+msg.what+".txtx");
                ViewPagerlist = JsonUtils.getListFromJson((String) msg.obj);
                auto = new AutoViewPager(ViewPagerlist,getActivity(),list,viewpager,handler,mlinear);
                app = auto.currentPosition;
            }
            auto.loadiamge();
            auto.creatDot();
            if(msg.what==-1&&auto.isAlive){
                app++;
                auto.viewpager.setCurrentItem(app);
            }
        }
    };
    private AutoViewPager auto;
    private int a;
    private  int app;


    private MyAppliction myAppliction;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onefragment, null);
        myAppliction = new MyAppliction();
        loacl = myAppliction.ADVERTURL;
        a = myAppliction.ADVERT_SUCCESS;
        initView(view);
        titlelayout.setOnClickListener(this);
        if(fileUtils.isSaveFile("data"+a+".txt")){
            String result = fileUtils.readJson("data"+a+".txt");
//            handleResult(result);
        }
        else {
            initViewPager();
        }
        return view;
    }
    //开启新线程，从网络中获取json；
    private void initViewPager() {
        new RequestUtils(getActivity(),loacl,handler,a).dataFromNet();
    }

    private void initView(View view) {
        viewpager = (ViewPager) view.findViewById(R.id.onefragment_pager);
        mrelaout = (RelativeLayout) view.findViewById(R.id.onefragment_viewpager_layout);
        title = (ImageView) view.findViewById(R.id.onefragment_title);
        twotitle = (ImageView) view.findViewById(R.id.onefragment_twotitle);
        titlelayout = (RelativeLayout) view.findViewById(R.id.title_layout);
        mlinear = (LinearLayout) view.findViewById(R.id.onefragment_dot_layout);
        fileUtils = new FileUtils(getActivity());
        animation_title1 = new ScaleAnimation(1,1,1,0, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.5f);
        animation_title2 = new ScaleAnimation(1,1,0,1,Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.5f);
        animation_title1.setDuration(500);
        animation_title2.setDuration(500);

        animation_title1.setAnimationListener(this);
        WindowManager windowManager = getActivity().getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
//        initViewPager();
    }
    //标题栏点击切换
    @Override
    public void onClick(View v) {
        if(title.getVisibility()==View.VISIBLE){
            title.startAnimation(animation_title1);

        }else {
            twotitle.startAnimation(animation_title1);

        }
    }
    //标题栏动画
    private void anmiation(ImageView imageView,ImageView imageView1) {

        imageView.setVisibility(View.GONE);
        imageView1.setVisibility(View.VISIBLE);
        imageView1.startAnimation(animation_title2);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(title.getVisibility()==View.VISIBLE){
            anmiation(title,twotitle);
        }else {
            anmiation(twotitle,title);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    //停止轮播线程
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(auto.thread!=null){
            auto.stopThread();
        }
    }
    //从缓存中读取处理显示Viewpager
    //放入autoviewpagr中的。
//    private void handleResult(String result) {
//        Log.i("TAG","---------获取数据："+result);
        //进行解析---适配显示
//        List<Bean> listx = JsonUtils.getListFromJson(result);
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(list,listx,getActivity());
//        viewpager.setAdapter(viewPagerAdapter);
//        viewpager.setCurrentItem(194);
//    }
}
