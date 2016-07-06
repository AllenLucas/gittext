package sxtlal.allenlucas.yohodemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sxtlal.allenlucas.yohodemo.R;

/**
 * Created by AllenLucas on 2016/6/3.
 */
public class twofragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView twoseclet, oneseclet, threeseclet, line1, line2, line3;
    private FragmentManager manager;
    private int currentid=0;
    private FragmentTransaction transaction;
    private boolean isFragment=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.twofragment, null);
        initView();
        initListener();
        return view;
    }




    private void initListener() {
        oneseclet.setOnClickListener(this);
        twoseclet.setOnClickListener(this);
        threeseclet.setOnClickListener(this);
    }

    private void initView() {
        twoseclet = (TextView) view.findViewById(R.id.twofragment_two);
        oneseclet = (TextView) view.findViewById(R.id.twofragment_one);
        threeseclet = (TextView) view.findViewById(R.id.twofragment_three);
        line1 = (TextView) view.findViewById(R.id.twofragment_line1);
        line2 = (TextView) view.findViewById(R.id.twofragment_line2);
        line3 = (TextView) view.findViewById(R.id.twofragment_line3);
        manager = getChildFragmentManager();
        fragmenthideshow(R.id.twofragment_one);
    }

    @Override
    public void onClick(View v) {
        alllinegone();
        fragmenthideshow(v.getId());

    }

    private void fragmenthideshow(int id) {
        Fragment current = manager.findFragmentByTag(String.valueOf(id));
        if(current==null){
            transaction = manager.beginTransaction();
            switch (id) {
                case R.id.twofragment_one:
                    line1.setVisibility(View.VISIBLE);
                    if(isFragment){
                        transaction.add(R.id.twofragment_onelayout,new Twofragment_onefragment(),String.valueOf(id));
                        isFragment = false;
                    }
                    break;
                case R.id.twofragment_two:
                    line2.setVisibility(View.VISIBLE);
                    transaction.add(R.id.twofragment_onelayout,new twofragment_two(),String.valueOf(id));
                    break;
                case R.id.twofragment_three:
                    line3.setVisibility(View.VISIBLE);
                    transaction.add(R.id.twofragment_onelayout,new twofragment_three(),String.valueOf(id));
                    break;
            }
            transaction.commit();
        }
        if(currentid!=0){
            transaction = manager.beginTransaction();
            Fragment hide = manager.findFragmentByTag(String.valueOf(currentid));
            if(current!=null){
                transaction.show(current);
            }
            switch (id) {
                case R.id.twofragment_one:
                    line1.setVisibility(View.VISIBLE);
                    break;
                case R.id.twofragment_two:
                    line2.setVisibility(View.VISIBLE);
                    break;
                case R.id.twofragment_three:
                    line3.setVisibility(View.VISIBLE);
                    break;
            }
            transaction.hide(hide);
            transaction.commit();
        }
        currentid = id;
    }

    private void alllinegone() {
        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.INVISIBLE);
        line3.setVisibility(View.INVISIBLE);
    }

}
