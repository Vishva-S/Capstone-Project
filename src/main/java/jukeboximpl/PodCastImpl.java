package jukeboximpl;

import jukeboxinterfaces.PodCastInterface;
import jukeboxmodel.PodCast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PodCastImpl implements PodCastInterface {
    static Connection conn = DBConnection.getConnection();

    @Override
    public List<PodCast> display_allpodcast() {
        List<PodCast> allPodcast = new ArrayList<>();
        PodCast p = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from jukebox.podcast");
            while (rs.next()) {
                p = new PodCast();
                p.setPodcast_name(rs.getString(1));
                p.setPodcast_id(rs.getInt(2));
                p.setPodcast_duration(rs.getString(3));
                p.setPodcast_episode(rs.getString(4));
                p.setPodcast_lang(rs.getString(5));
                p.setPodcast_file_path(rs.getString(6));
                p.setPlaylist_id(rs.getInt(7));
                allPodcast.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allPodcast;
    }

    @Override
    public List<PodCast> sort_podcasts() {
        List<PodCast> sort_song = new ArrayList<>();
        PodCast sortport = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from podcast order by podcast_name");
            while (rs.next()) {
                sortport = new PodCast();
                sortport.setPodcast_name(rs.getString(1));
                sortport.setPodcast_id(rs.getInt(2));
                sortport.setPodcast_duration(rs.getString(3));
                sortport.setPodcast_episode(rs.getString(4));
                sortport.setPodcast_lang(rs.getString(5));
                sortport.setPodcast_file_path(rs.getString(6));
                sortport.setPlaylist_id(rs.getInt(7));
                sort_song.add(sortport);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return sort_song;
    }


    @Override
    public PodCast search_podcasts(int podcast_id) {
        List<PodCast> search_podcast = new ArrayList<>();
        PodCast searchPodcast = null;
        try {
            Statement st = conn.createStatement();
            String str = "select * from podcast where podcast_id=?";
            PreparedStatement st1 = conn.prepareStatement(str);
            st1.setInt(1,podcast_id);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                searchPodcast = new PodCast();
                searchPodcast.setPodcast_name(rs.getString(1));
                searchPodcast.setPodcast_id(rs.getInt(2));
                searchPodcast.setPodcast_duration(rs.getString(3));
                searchPodcast.setPodcast_episode(rs.getString(4));
                searchPodcast.setPodcast_lang(rs.getString(5));
                searchPodcast.setPodcast_file_path(rs.getString(6));
                searchPodcast.setPlaylist_id(rs.getInt(7));
               // search_podcast.add(searchPodcast);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return searchPodcast;
    }

    @Override
    public void Play_podcast() {
        PlaySongs playSongs=new PlaySongs();
        System.out.println("Enter the playlist id :");
        Scanner sc2 = new Scanner(System.in);
        int id = sc2.nextInt();
        try {

            PreparedStatement pr = conn.prepareStatement("Select podcast_file_path from podcast where playlist_id=?");
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

