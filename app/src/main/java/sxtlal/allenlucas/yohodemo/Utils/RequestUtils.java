package sxtlal.allenlucas.yohodemo.Utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by AllenLucas on 2016/6/7.
 */
public class RequestUtils {
    private Context context;
    private Handler handler;
    private String local;
    private int a;
    private String params;
    public RequestUtils(Context context,String local,Handler handler,int a) {
        this.context = context;
        this.local = local;
        this.handler = handler;
        this.a=a;
    }
    public RequestUtils(Context context,String local,String params,Handler handler,int a) {
        this.context = context;
        this.local = local;
        this.handler = handler;
        this.a=a;
        this.params = params;
    }

    public void dataFromNet(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                if(!isNet.getNetstaut(context)){
                    return;
                }
                try {
                    HttpURLConnection connection = new HttpUtils(local).getHttpUtils();
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream is = connection.getInputStream();
                        String content = StreamUtils.getStringFromSteam(is);
                        is.close();
                        msg.obj = content;
                        msg.what=a;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(msg);
            }
        }).start();

    }
    public void dataFromNet2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                if(!isNet.getNetstaut(context)){
                    return;
                }
                try {
                    HttpURLConnection connection = new HttpUtils(local,params).getHttpUtilss();
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream is = connection.getInputStream();
                        String content = StreamUtils.getStringFromSteam(is);
                        is.close();
                        msg.obj = content;
                        msg.what=a;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(msg);
            }
        }).start();

    }
}
