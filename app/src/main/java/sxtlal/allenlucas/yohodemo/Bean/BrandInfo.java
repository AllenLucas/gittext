package sxtlal.allenlucas.yohodemo.Bean;

/**
 * Created by AllenLucas on 2016/6/12.
 */
public class BrandInfo {
    private String _id;
    private String name;
    private String value;
    private String letter;
    private String hotflag;
    private String categoryId;
    private String imgpath;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getHotflag() {
        return hotflag;
    }

    public void setHotflag(String hotflag) {
        this.hotflag = hotflag;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
