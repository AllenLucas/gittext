package sxtlal.allenlucas.yohodemo.View;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import sxtlal.allenlucas.yohodemo.Bean.Bean;
import sxtlal.allenlucas.yohodemo.Bean.BrandInfo;
import sxtlal.allenlucas.yohodemo.MyAppliction;
import sxtlal.allenlucas.yohodemo.R;
import sxtlal.allenlucas.yohodemo.Utils.FileUtils;
import sxtlal.allenlucas.yohodemo.Utils.JsonUtils;
import sxtlal.allenlucas.yohodemo.Utils.RequestUtils;

/**
 * Created by AllenLucas on 2016/6/12.
 */
public class NewScrollView {

    private int b;
    private String hoturl;
    private String loacl;
    private Context context;
    private View view;
    private MyAppliction app;
    private List<Bean> ViewPagerlist = new ArrayList<>();
    private List<ImageView> list = new ArrayList<>();
    private ViewPager viewPager;
    private LinearLayout mlinear;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==a){
                String x = (String) msg.obj;
                ViewPagerlist = JsonUtils.getListFromJson((String) msg.obj);
                auto = new AutoViewPager(ViewPagerlist,context,list,viewPager,handler,mlinear);
                current = auto.currentPosition;
                auto.loadiamge();
                auto.creatDot();
            }
////            if(msg.what==-1&&auto.isAlive){
////                current++;
////                auto.viewpager.setCurrentItem(current);
////            }
            if(msg.what==b){
                String x = (String) msg.obj;
                Log.e("dad",x);
//                brandlist = JsonUtils.getHotBrandList((String) msg.obj);
            }
        }
    };
    private AutoViewPager auto;
    private int current = 0;
    private int a;
    private RecyclerView recyclerview;
    private List<BrandInfo> brandlist;

    public NewScrollView(Context context) {
        this.context = context;
        app = (MyAppliction) context.getApplicationContext();
        loacl = app.ADVERTURL;
        a = app.CATEGORY_VIEWPAGER_SUCCESS;
        b = app.CATEGORY_HOT_SUCCESS;
        hoturl = app.HOTBRANDURL;
//        fileUtils = new FileUtils(context);
//        if(fileUtils.isSaveFile("data"+a+".txt")){
//            String result = fileUtils.readJson("data"+a+".txt");
//            handleResult(result);
//        }
//        else {
//            initHttp();
//        }
        initView();
    }

    private void initView() {
        view = View.inflate(context, R.layout.scrollview, null);
        viewPager = (ViewPager) view.findViewById(R.id.onefragment_pager);
        mlinear = (LinearLayout) view.findViewById(R.id.onefragment_dot_layout);
        recyclerview = (RecyclerView) view.findViewById(R.id.twofragment_tworecy);
        brandlist = new ArrayList<>();
        initHttp();

    }

    private void initHttp() {
        new RequestUtils(context,loacl,handler,a).dataFromNet();
    }


    public View getView() {
        return view;
    }
    public void stopthread(){
        if(auto.thread!=null){
            auto.stopThread();
        }
    }


}
