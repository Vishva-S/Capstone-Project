package jukeboxinterfaces;

import jukeboxmodel.Song;

import java.util.List;

public interface SongInterface {
    List<Song> displayAllsongs();
    List<Song> sortSngs();
    List<Song> searchSong(String genre);
    void Play_song();
    void addSongToPlaylist();

}
