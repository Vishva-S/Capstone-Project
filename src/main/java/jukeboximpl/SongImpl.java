package jukeboximpl;

import jukeboxinterfaces.SongInterface;
import jukeboxmodel.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongImpl implements SongInterface {
    static  Connection conn=DBConnection.getConnection();
    @Override
    public List<Song> displayAllsongs() {


        List<Song> allSongs=new ArrayList<>();
        Song s=null;
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from jukebox.song");
            while (rs.next()){
                s=new Song();
                s.setSong_name(rs.getString(1));
                s.setSong_id(rs.getInt(2));
                s.setSong_duration(rs.getString(3));
                s.setArtist(rs.getString(4));
                s.setGenre(rs.getString(5));
                s.setSong_file_path(rs.getString(6));
                s.setPlaylist_id(rs.getInt(7));
                allSongs.add(s);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return allSongs;


    }

    @Override
    public List<Song> sortSngs() {

      //  Connection conn=DBConnection.getConnection();
        List<Song> sortsong=new ArrayList<>();
        Song sortingsong=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from song order by song_name");
            while (rs.next())
            {
                sortingsong = new Song();
                sortingsong.setSong_name(rs.getString(1));
                sortingsong.setSong_id(rs.getInt(2));
                sortingsong.setSong_duration(rs.getString(3));
                sortingsong.setArtist(rs.getString(4));
                sortingsong.setGenre(rs.getString(5));
                sortingsong.setSong_file_path(rs.getString(6));
                sortingsong.setPlaylist_id(rs.getInt(7));
                sortsong.add(sortingsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return sortsong;

    }

    @Override
    public List<Song> searchSong(String genre) {
        List<Song> searchsong=new ArrayList<>();
        Song searchingsong=null;
        try {
            Statement st = conn.createStatement();
            String str="select * from song where genre=?";
            PreparedStatement st1=conn.prepareStatement(str);
            st1.setString(1,genre);

            ResultSet rs = st1.executeQuery();

            while (rs.next()) {
                searchingsong = new Song();
                searchingsong.setSong_name(rs.getString(1));
                searchingsong.setSong_id(rs.getInt(2));
                searchingsong.setSong_duration(rs.getString(3));
                searchingsong.setArtist(rs.getString(4));
                searchingsong.setGenre(rs.getString(5));
                searchingsong.setSong_file_path(rs.getString(6));
                searchingsong.setPlaylist_id(rs.getInt(7));
                searchsong.add(searchingsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchsong;
    }

    @Override
    public void Play_song() {
       PlaySongs playSongs=new PlaySongs();
        System.out.println("Enter the playlist id :");
        Scanner sc2 = new Scanner(System.in);
        int id = sc2.nextInt();
        try {

            PreparedStatement pr = conn.prepareStatement("Select song_file_path from song where playlist_id=?");
            pr.setInt(1, id);
            ResultSet rs= pr.executeQuery();
            while(rs.next())
            {
                playSongs.readAudio(rs.getString(1),1);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public  void addSongToPlaylist() {
        Scanner s1=new Scanner(System.in);
        System.out.println("ENTER YOUR   SONG ID");
        int songid=s1.nextInt();
        System.out.println("ENTER YOUR PLAYLIST ID ");
        String playlistid=s1.next();
        try{
            PreparedStatement st=conn.prepareStatement("update song set playlist_id=? where song_id=?");
            st.setInt(1, Integer.parseInt(playlistid));
            st.setInt(2,songid);
            int rows= st.executeUpdate();
            System.out.println("YOUR PLAY LIST HAS BEEN ADDED SUCCESSFULLY");


        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        
    }

}




