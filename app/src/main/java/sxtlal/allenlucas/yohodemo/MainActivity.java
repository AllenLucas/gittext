package sxtlal.allenlucas.yohodemo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import sxtlal.allenlucas.yohodemo.Fragment.OneFragment;
import sxtlal.allenlucas.yohodemo.Fragment.fivefragment;
import sxtlal.allenlucas.yohodemo.Fragment.treefragment;
import sxtlal.allenlucas.yohodemo.Fragment.twofragment;

public class MainActivity extends FragmentActivity {

    private FrameLayout fragmlayout;
    private FragmentManager fragmentManager;
    private RadioGroup group;
    private int currentid=0;
    private FragmentTransaction transaction;
    private boolean isFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        toFragment(R.id.mainActivity_btn1);
    }

    private void initView() {
        group = (RadioGroup) findViewById(R.id.mainActivity_group);
        fragmlayout = (FrameLayout) findViewById(R.id.fragmentlayout);
        fragmentManager = getSupportFragmentManager();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId!=R.id.mainActivity_btn4){
                    toFragment(checkedId);
                }
            }
        });
    }

    private void toFragment(int checkedId) {
        Fragment current = fragmentManager.findFragmentByTag(String.valueOf(checkedId));
        if(current==null){
            transaction = fragmentManager.beginTransaction();
            switch (checkedId){
                case R.id.mainActivity_btn1:
                    if(isFragment){
                        transaction.add(R.id.fragmentlayout,new OneFragment(),String.valueOf(checkedId));
                        isFragment = false;
                    }
                    break;
                case R.id.mainActivity_btn2:
                    transaction.add(R.id.fragmentlayout,new twofragment(),String.valueOf(checkedId));
                    break;
                case R.id.mainActivity_btn3:
                    transaction.add(R.id.fragmentlayout,new treefragment(),String.valueOf(checkedId));
                    break;
                case R.id.mainActivity_btn5:
                    transaction.add(R.id.fragmentlayout,new fivefragment(),String.valueOf(checkedId));
                    break;
            }
            transaction.commit();
        }
        if(currentid!=0){
            transaction = fragmentManager.beginTransaction();
            Fragment hide = fragmentManager.findFragmentByTag(String.valueOf(currentid));
            if(current!=null){
                transaction.show(current);
            }
            transaction.hide(hide);
            transaction.commit();
        }
        currentid = checkedId;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.seczoomin,R.anim.seczoomout);
    }
}
