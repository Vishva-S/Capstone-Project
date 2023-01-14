package jukeboxinterfaces;

import jukeboxmodel.PodCast;

import java.util.List;

public interface PodCastInterface {
    List<PodCast> display_allpodcast();
   // List<PodCast> sort_podcasts(String podcast_name);
    List<PodCast> sort_podcasts();
    PodCast search_podcasts(int podcast_id);
    void Play_podcast();
}
