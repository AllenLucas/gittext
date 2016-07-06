package sxtlal.allenlucas.yohodemo.Utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import sxtlal.allenlucas.yohodemo.MyAppliction;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class FileUtils {
    private Context context;

    public FileUtils(Context context) {
        this.context = context;
    }
    public void savejson(String json,String fileNmae){
        if(json==null){
            return;
        }
        if(fileNmae==null){
            return;
        }
        MyAppliction myAppliction = (MyAppliction) context.getApplicationContext();
        try {
            FileOutputStream fos = myAppliction.openFileOutput(fileNmae,Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean isSaveFile(String fileName){
        File file = new File(context.getFilesDir(),fileName);
        return file.exists();
    }
    public String readJson(String fileName){
        String result = null;
        MyAppliction myAppliction = (MyAppliction) context.getApplicationContext();
        try {
            FileInputStream fis = myAppliction.openFileInput(fileName);
            InputStreamReader ir = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(ir);
            String str;
            StringBuffer sbf = new StringBuffer();
            while ((str=br.readLine())!=null){
                sbf.append(str);
            }
            result = sbf.toString();
            br.close();
            ir.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
