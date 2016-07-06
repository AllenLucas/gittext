package sxtlal.allenlucas.yohodemo.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sxtlal.allenlucas.yohodemo.Adapter.TwoListAdatper;
import sxtlal.allenlucas.yohodemo.Adapter.TwoListOne;
import sxtlal.allenlucas.yohodemo.Bean.TwoBean;
import sxtlal.allenlucas.yohodemo.Bean.TwoListTwo;
import sxtlal.allenlucas.yohodemo.MyAppliction;
import sxtlal.allenlucas.yohodemo.R;
import sxtlal.allenlucas.yohodemo.Utils.JsonUtils;
import sxtlal.allenlucas.yohodemo.Utils.RequestUtils;

/**
 * Created by AllenLucas on 2016/6/8.
 */
public class Twofragment_onefragment extends Fragment implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener{
    private View view;
    private RadioGroup group;
    private RadioButton btn1, btn2, btn3;
    private LinearLayout layout2;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == boy_success) {
                list.clear();
                list = new JsonUtils().getformJson((String) msg.obj, "boy");
                initAdapter();
            }
            if (msg.what == girls_success) {
                list.clear();
                list = new JsonUtils().getformJson((String) msg.obj, "girl");
                initAdapter();
            }
            if (msg.what == life_success) {
                list.clear();
                list = new JsonUtils().getformJson((String) msg.obj, "life");
                initAdapter();
            }
            if (msg.what == cate1) {
                String result = msg.obj.toString();
                list2.clear();
                list2 = new JsonUtils().getFromJsontoList(result);
                twoAdapter();
            }
            if(msg.what == 311){
                Log.e("sda",msg.what+"!!!"+msg.obj+"");
            }
        }
    };
    private String bogurl;
    private String girl;
    private String life;
    private int boy_success;
    private int girls_success;
    private int life_success;
    private List<TwoBean> list;
    private ListView listview1, listview2;
    private TwoListOne adapter;
    private int currentposition = -1;
    private boolean isShowing = false;
    private String cate;
    private int cate1;
    private List<TwoListTwo> list2;
    private View viewById;
    private Animation toleft;
    private Animation toright;
    private boolean showanimtion;
    private TwoListAdatper adatper1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.twofragment_onefragment, null);
        MyAppliction appliction = new MyAppliction();
        String url = appliction.URL;
        String all = url+"allbrand.php";
        bogurl = appliction.BOYURL;
        girl = appliction.GIRLURL;
        life = appliction.LIFESTYLEURL;
        cate = appliction.CATEGORYVALUEURL;
        boy_success = appliction.CATEGORY_BOY_SUCCESS;
        girls_success = appliction.CATEGORY_GIRLS_SUCCESS;
        life_success = appliction.CATEGORY_LIFE_SUCCESS;
        cate1 = appliction.CATEGORY_VALUE_SUCCESS;
        initView();
        initListener();
        initdataFromNet(bogurl, boy_success);
        initdataFromNet2(all,311);
        return view;
    }

    private void initAdapter() {
        adapter = new TwoListOne(getActivity(), list);
        listview1.setAdapter(adapter);
    }

    private void twoAdapter() {
        adatper1 = new TwoListAdatper(getActivity(), list2);
        listview2.setAdapter(adatper1);
    }


    private void initdataFromNet(String msg, int num) {
        new RequestUtils(getActivity(), msg, handler, num).dataFromNet();
    }
    private void initdataFromNet2(String msg, int num) {
        new RequestUtils(getActivity(),msg,"parames={\"page\":\"10\"}",handler,num).dataFromNet2();
    }

    private void initListener() {
        group.setOnCheckedChangeListener(this);
        listview1.setOnItemClickListener(this);
        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TwoListTwo item = (TwoListTwo) adatper1.getItem(position);
                Toast.makeText(getActivity(), item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        group = (RadioGroup) view.findViewById(R.id.twofragment_group);
        btn1 = (RadioButton) view.findViewById(R.id.twofragment_btn1);
        btn2 = (RadioButton) view.findViewById(R.id.twofragment_btn1);
        btn3 = (RadioButton) view.findViewById(R.id.twofragment_btn1);
        layout2 = (LinearLayout) view.findViewById(R.id.twofragment_layout2);
        listview1 = (ListView) view.findViewById(R.id.twofragment_list1);
        listview2 = (ListView) view.findViewById(R.id.twofragment_list2);
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        btn1.setChecked(true);
        toleft = AnimationUtils.loadAnimation(getActivity(), R.anim.twofragmenttoleft);
        toright = AnimationUtils.loadAnimation(getActivity(), R.anim.twofragmenttoright);
        layout2.setVisibility(View.INVISIBLE);
    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.twofragment_btn1:
                initdataFromNet(bogurl, boy_success);
                break;
            case R.id.twofragment_btn2:
                initdataFromNet(girl, girls_success);
                break;
            case R.id.twofragment_btn3:
                initdataFromNet(life, life_success);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        View image = listview1.getChildAt(position).findViewById(R.id.twofragment_select);
        if (currentposition >= 0) {
            viewById = listview1.getChildAt(currentposition).findViewById(R.id.twofragment_select);
        }
        if (position == currentposition) {
            if (isShowing) {
                layout2.startAnimation(toright);
                image.startAnimation(toright);
                layout2.setVisibility(View.INVISIBLE);
                image.setVisibility(View.INVISIBLE);
                showanimtion = false;
            } else {
                layout2.startAnimation(toleft);
                image.startAnimation(toleft);
                layout2.setVisibility(View.VISIBLE);
                image.setVisibility(View.VISIBLE);
                showanimtion = true;
            }
            isShowing = !isShowing;
        } else {
            if (!showanimtion) {
                layout2.startAnimation(toleft);
                image.startAnimation(toleft);
                showanimtion = !showanimtion;
            }
            layout2.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
            if (viewById != null) {
                viewById.setVisibility(View.INVISIBLE);
            }
            TwoBean data = (TwoBean) adapter.getItem(position);
            String parentId = data.get_id();
            new RequestUtils(getActivity(), cate, "parames={\"id\":" + parentId + "}", handler, cate1).dataFromNet2();
            currentposition = position;
            isShowing = true;
        }
    }
}
