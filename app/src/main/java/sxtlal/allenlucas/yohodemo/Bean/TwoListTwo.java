package sxtlal.allenlucas.yohodemo.Bean;

/**
 * Created by AllenLucas on 2016/6/7.
 */
public class TwoListTwo {
    private String _id;
    private String name;
    private String CategoryId;

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

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    @Override
    public String toString() {
        return "TwoListTwo{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", CategoryId='" + CategoryId + '\'' +
                '}';
    }
}
