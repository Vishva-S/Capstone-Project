package jukeboxmodel;

public class Song {
    private String song_name;
    private int song_id;
    private String song_duration;
    private String artist;
    private String genre;
    private String song_file_path;
    private int playlist_id;

    public Song(String song_name, int song_id, String song_duration, String artist, String genre, String song_file_path, int playlist_id) {
        this.song_name = song_name;
        this.song_id = song_id;
        this.song_duration = song_duration;
        this.artist = artist;
        this.genre = genre;
        this.song_file_path = song_file_path;
        this.playlist_id = playlist_id;
    }

    public Song() {
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(String song_duration) {
        this.song_duration = song_duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSong_file_path() {
        return song_file_path;
    }

    public void setSong_file_path(String song_file_path) {
        this.song_file_path = song_file_path;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "song_name='" + song_name + '\'' +
                ", song_id=" + song_id +
                ", song_duration='" + song_duration + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", song_file_path='" + song_file_path + '\'' +
                ", playlist_id=" + playlist_id +
                '}';
    }
}
