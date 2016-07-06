package sxtlal.allenlucas.yohodemo;

import android.app.Application;

/**
 * Created by AllenLucas on 2016/6/3.
 */
public class MyAppliction extends Application {
    public String URL = "http://www.iwens.org/School_Sky/";
    //获取服务器图片地址
    public String IMGURL = "http://www.iwens.org/School_Sky/Img/";
    //获取首页广告接口
    public String ADVERTURL = URL+"yohoadvert.php";
    public String BOYURL = URL+"categoryboy.php";
    //分类页面girl接口
    public String GIRLURL = URL+"categorygirl.php";
    //分类页面lifestyle接口
    public String LIFESTYLEURL = URL+"categorylife.php";
    //分类页面二级菜单接口----需要进行paramers的拼接参数
    public String CATEGORYVALUEURL = URL+"categoryvalue.php";
    //热门商标信息接口
    public String HOTBRANDURL = URL+"hotbrand.php";
    public  final int ADVERT_SUCCESS = 200;
    //表示分类中boys的正确返回
    public  final int CATEGORY_BOY_SUCCESS = 201;
    //表示分类中girls的正确返回
    public  final int CATEGORY_GIRLS_SUCCESS = 202;
    //表示分类中life的正确返回
    public  final int CATEGORY_LIFE_SUCCESS = 203;
    //表示分类中二级菜单数据的正确返回
    public  final int CATEGORY_VALUE_SUCCESS = -204;
    public final  int CATEGORY_VIEWPAGER_SUCCESS = 205;
    public final int CATEGORY_HOT_SUCCESS = 206;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
