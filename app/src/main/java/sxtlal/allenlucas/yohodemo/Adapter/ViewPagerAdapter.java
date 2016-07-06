package sxtlal.allenlucas.yohodemo.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import sxtlal.allenlucas.yohodemo.Bean.Bean;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<ImageView> list;
    private List<Bean> beanList;
    private Context context;

    public ViewPagerAdapter(List<ImageView> list, List<Bean> beanList, Context context) {
        this.list = list;
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position%beanList.size()));
        return list.get(position%beanList.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position%beanList.size()));
    }
}
