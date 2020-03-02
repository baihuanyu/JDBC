package homework.entity;
/**
 * 学生实体类
 * */
public class Student {
    private int id;
    private String username;
    private String password;
    private int age;
    private boolean sex;
    private String info;

    public Student() {
    }

    public Student(String username, String password, int age, boolean sex, String info) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.info = info;
    }

    public Student(int id, String username, String password, int age, boolean sex, String info) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", info='" + info + '\'' +
                '}';
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
