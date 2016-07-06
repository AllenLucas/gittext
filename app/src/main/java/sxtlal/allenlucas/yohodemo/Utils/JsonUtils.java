package sxtlal.allenlucas.yohodemo.Utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sxtlal.allenlucas.yohodemo.Bean.Bean;
import sxtlal.allenlucas.yohodemo.Bean.BrandInfo;
import sxtlal.allenlucas.yohodemo.Bean.TwoBean;
import sxtlal.allenlucas.yohodemo.Bean.TwoListTwo;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class JsonUtils {
    public static List<Bean> getListFromJson(String json){
        List<Bean> list = new ArrayList<Bean>();
        try {
            JSONArray array = new JSONArray(json);
            for(int i =0;i<array.length();i++){
                JSONObject object = array.getJSONObject(i);
                Bean bean = new Bean();
                String id = object.getString("_id");
                String imgpath = object.getString("imgpath");
                String advertId = object.getString("advertId");
                bean.set_id(id);
                bean.setImgpath(imgpath);
                bean.setAdvertId(advertId);
                list.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<TwoBean> getformJson(String json,String key){
        List<TwoBean> list1 = new ArrayList<>();
        if(json==null){
            return list1;
        }
        if(json.equals("")){
            return list1;
        }
        try {
            JSONObject object = new JSONObject(json);
            String success = object.getString("sucessfully");
            if(success.equals("no")){
                return list1;
            }
            JSONArray array = object.getJSONArray(key);
            for (int i =0;i<array.length();i++){
                JSONObject data = array.getJSONObject(i);
                TwoBean twoBean = new TwoBean();
                twoBean.set_id(data.getString("_id"));
                twoBean.setName(data.getString("name"));
                twoBean.setSexId(data.getString("SexId"));
                list1.add(twoBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list1;
    }
    public  List<TwoListTwo> getFromJsontoList(String msg){
        List<TwoListTwo> list = new ArrayList<>();
        if(msg==null){
            return list;
        }
        if(msg.equals("")){
            return list;
        }
        try {
            JSONObject obj = new JSONObject(msg);
            String success = obj.getString("sucessfully");
            if (success.equals("no"))
                return list;
            JSONArray array = obj.getJSONArray("value");
            for (int i =0;i<array.length();i++){
                JSONObject object = array.getJSONObject(i);
                TwoListTwo data = new TwoListTwo();
                data.set_id(object.getString("_id"));
                data.setName(object.getString("name"));
                data.setCategoryId(object.getString("CategoryId"));
                list.add(data);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<BrandInfo> getHotBrandList(String result) {
        Log.i("TAG","嚯嚯嚯"+result);
        List<BrandInfo> list = new ArrayList<BrandInfo>();
        if (result==null)
            return list;
        if(result.equals(""))
            return list;
        //处理返回值
        try {
            JSONObject obj = new JSONObject(result);
            String success = obj.getString("sucessfully");
            if (success.equals("no"))
                return list;

            JSONArray array = obj.getJSONArray("brand");
            for(int i  = 0;i<array.length();i++){
                JSONObject data = array.getJSONObject(i);
                BrandInfo info = new BrandInfo();

                info.set_id(data.getString("_id"));
                info.setName(data.getString("name"));
                info.setCategoryId(data.getString("categoryId"));
                info.setHotflag(data.getString("hotflag"));
                info.setImgpath(data.getString("imgpath"));
                info.setLetter(data.getString("letter"));
                info.setValue(data.getString("value"));
                list.add(info);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

}
