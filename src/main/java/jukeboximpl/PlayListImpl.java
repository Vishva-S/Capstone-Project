package jukeboximpl;

import jukeboxinterfaces.PlayListInterface;
import jukeboxmodel.PlayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class PlayListImpl implements PlayListInterface {
    static Connection conn = DBConnection.getConnection();
    @Override
    public List<PlayList> display_asPlaylist() {
        List<PlayList>playlist=new ArrayList<>();
        PlayList playList1=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from jukebox.playlist");
            while(rs.next())
            {
                playList1=new PlayList();
                playList1.setPlaylist_id(rs.getInt(1));
                playList1.setPlaylist_name(rs.getString(2));
                playList1.setUserid(rs.getString(3));
                playlist.add(playList1);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return playlist;
    }

    @Override
    public boolean addPlaylist() {
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter your playlist_id");
        int playlist_id=s1.nextInt();
        System.out.println("Enter your playlist_name");
        String playlist_name=s1.next();
        System.out.println("Enter your userid");
        String userid=s1.next();
        try{
            String sql="insert into playlist(playlist_id,playlist_name,userid)values(?,?,?)";

            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,playlist_id);
            st.setString(2,playlist_name);
            st.setString(3,userid);
            int rows= st.executeUpdate();
            System.out.println("------PlayList Added Successfully--------");
            return true;

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }



        return false;
    }

    @Override
    public List<PlayList> sort_Playlist() {
        List<PlayList>playLists=new ArrayList<>();
        PlayList sortPlaylist=null;
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from jukebox.playlist order by playlist_name");
            while(rs.next())
            {
                sortPlaylist=new PlayList();
                sortPlaylist.setPlaylist_id(rs.getInt(1));
                sortPlaylist.setPlaylist_name(rs.getString(2));
                sortPlaylist.setUserid(rs.getString(3));
                playLists.add(sortPlaylist);

            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return playLists;
    }

    @Override
    public void Play_song_in_Playlist() {
        PlaySongs playSongs=new PlaySongs();
        System.out.println("Enter the playlist id :");
        Scanner sc1 = new Scanner(System.in);
        int id = sc1.nextInt();
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

}
