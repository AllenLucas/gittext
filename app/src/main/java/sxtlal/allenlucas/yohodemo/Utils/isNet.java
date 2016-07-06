package sxtlal.allenlucas.yohodemo.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import sxtlal.allenlucas.yohodemo.MyAppliction;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class isNet {
    public static boolean getNetstaut(Context context) {
        ConnectivityManager manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo Net = manger.getActiveNetworkInfo();
        if(Net!=null&& Net.getState()==NetworkInfo.State.CONNECTED){
            return true;
        }
        return false;
    }
}
