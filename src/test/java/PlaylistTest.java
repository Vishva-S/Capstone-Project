import jukeboximpl.PlayListImpl;
import jukeboximpl.PodCastImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlaylistTest {
    @Before
    public void setup(){
        PlayListImpl playListimpl =new PlayListImpl();
    }
    @After
    public void teardown(){

    }
    @Test
    public void displayAllPlaylist(){
        PlayListImpl playListimpl =new PlayListImpl();
        assertEquals(7,playListimpl.display_asPlaylist().size());

    }
    @Test
    public void sortPlaylist() throws SQLException {
        PlayListImpl playListimpl =new PlayListImpl();
        assertEquals("folk",playListimpl.sort_Playlist().get(0).getPlaylist_name());
    }
    @Test
    public void wrongdisplayAllPlaylist(){
        PlayListImpl playListimpl =new PlayListImpl();
        assertNotEquals(10,playListimpl.display_asPlaylist().size());

    }
    @Test
    public void wrongsortPlaylist() throws SQLException {
        PlayListImpl playListimpl =new PlayListImpl();
        assertNotEquals("pop",playListimpl.sort_Playlist().get(0).getPlaylist_name());
    }


}
