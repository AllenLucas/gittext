package sxtlal.allenlucas.yohodemo.Bean;

/**
 * Created by AllenLucas on 2016/6/6.
 */
public class Bean {

    /**
     * _id : 1
     * imgpath : top1.jpg
     * advertId : 1
     */

    private String _id;
    private String imgpath;
    private String advertId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "_id='" + _id + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", advertId='" + advertId + '\'' +
                '}';
    }
}
