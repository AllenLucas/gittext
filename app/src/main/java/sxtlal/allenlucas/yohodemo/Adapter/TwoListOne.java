package sxtlal.allenlucas.yohodemo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sxtlal.allenlucas.yohodemo.Bean.TwoBean;
import sxtlal.allenlucas.yohodemo.R;

/**
 * Created by AllenLucas on 2016/6/7.
 */
public class TwoListOne extends BaseAdapter {
    private Context context;
    private List<TwoBean> list;

    public TwoListOne(Context context, List<TwoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(list.get(position).get_id());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.twolistone,null);
            viewHold = new ViewHold();
            viewHold.textView = (TextView) convertView.findViewById(R.id.twoonelist_text);
            viewHold.imageView = (ImageView) convertView.findViewById(R.id.twofragment_select);
            convertView.setTag(viewHold);
        }else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.textView.setText(list.get(position).getName());
        return convertView;
    }
    class ViewHold{
        TextView textView;
        ImageView imageView;

    }
}
