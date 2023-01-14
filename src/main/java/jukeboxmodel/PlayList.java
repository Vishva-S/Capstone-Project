package jukeboxmodel;

public class PlayList {
   private  int playlist_id;
   private  String playlist_name;
   private  String userid;

    public PlayList(int playlist_id, String playlist_name, String userid) {
        this.playlist_id = playlist_id;
        this.playlist_name = playlist_name;
        this.userid = userid;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public PlayList() {
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playlist_id=" + playlist_id +
                ", playlist_name='" + playlist_name + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
