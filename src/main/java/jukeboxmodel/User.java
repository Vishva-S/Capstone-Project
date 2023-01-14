package jukeboxmodel;

public class User {
    private String userid;
    private String password;
    private String mobno;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public User(String userid, String password, String mobno) {
        this.userid = userid;
        this.password = password;
        this.mobno = mobno;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", mobno='" + mobno + '\'' +
                '}';
    }

    public User() {
    }
}
