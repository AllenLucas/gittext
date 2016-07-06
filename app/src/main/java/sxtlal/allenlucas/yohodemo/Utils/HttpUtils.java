package sxtlal.allenlucas.yohodemo.Utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sxtlal.allenlucas.yohodemo.Fragment.OneFragment;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class HttpUtils {
    private String loacl;
    private String params;
    private HttpURLConnection connection;

    public HttpUtils(String local,String params) {
        this.loacl=local;
        this.params = params;
    }
    public HttpUtils(String loacl){
        this.loacl =loacl;
    }

    public  HttpURLConnection getHttpUtils() throws IOException {
        URL url = new URL(loacl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setReadTimeout(60 * 1000);
        connection.setConnectTimeout(60 * 1000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        return connection;
    }
    public  HttpURLConnection getHttpUtilss() throws IOException {
        getHttpUtils();
        OutputStream os = connection.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        byte[] buf = params.getBytes();
        dos.write(buf);
        dos.close();
        os.close();
        return connection;
    }
}
