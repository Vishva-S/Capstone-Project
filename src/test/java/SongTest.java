import jukeboximpl.SongImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SongTest {
    @Before
    public void setup(){
        SongImpl songImplementation=new SongImpl();
    }
    @After
    public void teardown(){

    }
    @Test
    public void displayAllsongs(){
        SongImpl songImplementation=new SongImpl();
        assertEquals(5,songImplementation.displayAllsongs().size());

    }
    @Test
    public void sortSngs() throws SQLException {
        SongImpl songImplementation=new SongImpl();
        assertEquals("BabyElephantWalk","BabyElephantWalk",songImplementation.sortSngs().get(0).getSong_name());
    }
    @Test
    public void searchSong(){
        SongImpl songImplementation=new SongImpl();
        assertEquals("CantinaBand",songImplementation.searchSong("sad"));
    }
    @Test
    public void wrongdisplayAllsong(){
        SongImpl songImplementation=new SongImpl();
        assertNotEquals(7,songImplementation.displayAllsongs().size());
    }
    @Test
    public void wrongsortSngs() throws SQLException {
        SongImpl songImplementation=new SongImpl();
      //  assertEquals("BabyElephantWalk","BabyElephantWalk",songImplementation.sortSngs().get(0).getSong_name());
         assertNotEquals("CantinaBand",songImplementation.sortSngs().get(0).getSong_name());
    }

}
