import jukeboximpl.PodCastImpl;
import jukeboximpl.SongImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PodcastTest {
    @Before
    public void setup(){
       PodCastImpl podCastimpl=new PodCastImpl();
    }
    @After
    public void teardown(){

    }
    @Test
    public void displayAllPodcast(){
        PodCastImpl podCastimpl=new PodCastImpl();
        assertEquals(4,podCastimpl.display_allpodcast().size());

    }
    @Test
    public void sortPodcast() throws SQLException {
        PodCastImpl podCastimpl=new PodCastImpl();

        assertEquals("gettsbury","gettsbury",podCastimpl.sort_podcasts().get(0).getPodcast_name());
    }
    @Test
    public void searchPodcast(){
        PodCastImpl podCastimpl=new PodCastImpl();
        assertEquals("taunt",podCastimpl.search_podcasts(1).getPodcast_name());
    }
    @Test
    public void wrongdisplayAllPodcast(){
        PodCastImpl podCastimpl=new PodCastImpl();
        assertNotEquals(7,podCastimpl.display_allpodcast().size());

    }
    @Test
    public void wrongsearchPodcast(){
        PodCastImpl podCastimpl=new PodCastImpl();
        assertNotEquals("gettsburg",podCastimpl.search_podcasts(1).getPodcast_name());
    }
}
