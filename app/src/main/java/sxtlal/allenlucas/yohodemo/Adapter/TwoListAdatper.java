package sxtlal.allenlucas.yohodemo.Adapter;

import android.content.Context;
import android.telecom.TelecomManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import sxtlal.allenlucas.yohodemo.Bean.TwoListTwo;
import sxtlal.allenlucas.yohodemo.R;

/**
 * Created by AllenLucas on 2016/6/8.
 */
public class TwoListAdatper extends BaseAdapter {
    private Context context;
    private List<TwoListTwo> list;

    public TwoListAdatper(Context context, List<TwoListTwo> list) {
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
        ViewHlod viewHlod = null;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.twolistlayout,null);
            viewHlod = new ViewHlod();
            viewHlod.textView = (TextView) convertView.findViewById(R.id.twolisttext);
            convertView.setTag(viewHlod);
        }else {
            viewHlod = (ViewHlod) convertView.getTag();
        }
        viewHlod.textView.setText(list.get(position).getName());
        return convertView;
    }
    class ViewHlod{
        private TextView textView;
    }
}
