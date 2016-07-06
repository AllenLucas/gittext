package sxtlal.allenlucas.yohodemo.Bean;

/**
 * Created by AllenLucas on 2016/6/7.
 */
public class TwoBean {

    /**
     * _id : 1
     * name : 上衣
     * SexId : 1
     */

    private String _id;
    private String name;
    private String SexId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexId() {
        return SexId;
    }

    public void setSexId(String SexId) {
        this.SexId = SexId;
    }

    @Override
    public String toString() {
        return "TwoBean{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", SexId='" + SexId + '\'' +
                '}';
    }
}
