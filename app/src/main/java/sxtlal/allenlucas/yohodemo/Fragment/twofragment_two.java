package sxtlal.allenlucas.yohodemo.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sxtlal.allenlucas.yohodemo.Bean.Bean;
import sxtlal.allenlucas.yohodemo.MyAppliction;
import sxtlal.allenlucas.yohodemo.R;
import sxtlal.allenlucas.yohodemo.View.AutoViewPager;
import sxtlal.allenlucas.yohodemo.View.NewScrollView;

/**
 * Created by AllenLucas on 2016/6/8.
 */
public class twofragment_two extends Fragment implements RadioGroup.OnCheckedChangeListener {


    private View view;
    private RadioGroup group;
    private RadioButton btn1,btn2,btn3;
    private ScrollView scroll;
    private NewScrollView ns;
    private ListView listview;
    private LinearLayout viewscroll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.twofragment_twofragment_layout,null);
        intiView();
        group.setOnCheckedChangeListener(this);
        return view;
    }

    private void intiView() {
        group = (RadioGroup) view.findViewById(R.id.twofragment_group);
        btn1 = (RadioButton) view.findViewById(R.id.twofragment_btn1);
        btn2 = (RadioButton) view.findViewById(R.id.twofragment_btn1);
        btn3 = (RadioButton) view.findViewById(R.id.twofragment_btn1);
        btn1.setChecked(true);
        scroll = (ScrollView) view.findViewById(R.id.brand_scroll);
        listview = (ListView) view.findViewById(R.id.brand_letterview);
        ns = new NewScrollView(getActivity());
        viewscroll = (LinearLayout) ns.getView().findViewById(R.id.scrollview_self);
        viewscroll.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        scroll.addView(viewscroll);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.twofragment_btn1:
                scroll.addView(ns.getView());
                break;
            case R.id.twofragment_btn2:
                Log.e("sda","2");
                break;
            case R.id.twofragment_btn3:
                Log.e("sda","3");
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ns.stopthread();
    }
}
