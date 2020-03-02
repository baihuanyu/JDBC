package codepractice.day01.entity;
/**
 * 用户实体类
 * */
public class User {
    private int uid;
    private String uname;
    private int uage;
    private boolean ugander;

    public User() {
    }

    public User(String uname, int uage, boolean ugander) {
        this.uname = uname;
        this.uage = uage;
        this.ugander = ugander;
    }

    public User(int uid, String uname, int uage, boolean ugander) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
        this.ugander = ugander;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public boolean isUgander() {
        return ugander;
    }

    public void setUgander(boolean ugander) {
        this.ugander = ugander;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                ", ugander=" + ugander +
                '}';
    }

}
