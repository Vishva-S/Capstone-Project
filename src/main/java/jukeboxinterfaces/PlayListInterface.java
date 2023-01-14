package jukeboxinterfaces;

import jukeboxmodel.PlayList;

import java.util.List;

public interface PlayListInterface {
     List<PlayList> display_asPlaylist();
     boolean  addPlaylist();
     List<PlayList>sort_Playlist();
     void Play_song_in_Playlist();
}
