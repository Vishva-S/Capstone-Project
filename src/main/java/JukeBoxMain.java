import com.sun.tools.javac.Main;
import jukeboximpl.PlayListImpl;
import jukeboximpl.PodCastImpl;
import jukeboximpl.SongImpl;
import jukeboximpl.UserImpl;
import jukeboxinterfaces.PlayListInterface;
import jukeboxmodel.PlayList;
import jukeboxmodel.PodCast;
import jukeboxmodel.Song;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class JukeBoxMain {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("----------------Welcome to JukeBox-----(World Of Music)---------------");
        System.out.println("$$$$$$$$$$$****************************************************************************$$$$$$$$$$$$");
        System.out.println("Do you have account in jukebox ?  \n 1. Yes I have \n 2.No,I dont have");
        System.out.println("*******************************************************************************************");
        int choice = scanner.nextInt();
        UserImpl userimpl = new UserImpl();
        if (choice == 2) {
            boolean flag1 = userimpl.createAccount();


        } else if (choice == 1) {
            boolean flag1 = userimpl.login();
            while (true) {
                System.out.println("-----------Be Choosy To Choose AnyOne-----------------");
                System.out.println("1. Songs");
                System.out.println("2. Podcast");
                System.out.println("3. Playlist");
                System.out.println("4. Play Song");
                System.out.println("5. Play Podcast");
                System.out.println("6. Exit");
                System.out.println("*******************************************************************************************");

                int choice1 = scanner.nextInt();

                System.out.println("-----------------Welcome To JukeBox-----------------------");
                if (choice1 == 1) {
                    System.out.println("1. Display all Songs");
                    System.out.println("2. Sort all Songs");
                    System.out.println("3. Search Song");
                    System.out.println("4: Add Song To Playlist");
                    System.out.println("5: Main Menu");
                    System.out.println("6: Exit");
                    System.out.println("*******************************************************************************************");
                    int choice2 = scanner.nextInt();
                    SongImpl obj2 = new SongImpl();
                    switch (choice2) {
                        case 1:
                            System.out.println("List of Songs");
                            List<Song> allSongDets = obj2.displayAllsongs();
                            for (Song s : allSongDets) {
                               // System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%20s %20d %30s %35s %40s %100s %40d \n", s.getSong_name(), s.getSong_id(), s.getSong_duration(), s.getArtist(), s.getGenre(), s.getSong_file_path(), s.getPlaylist_id());
                             //   System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 2:
                            System.out.println("Sorted List of Songs");
                            List<Song> sorted = obj2.sortSngs();
                            for (Song s : sorted) {
                               // System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%20s %20d %30s %35s %40s %100s %40d \n", s.getSong_name(), s.getSong_id(), s.getSong_duration(), s.getArtist(), s.getGenre(), s.getSong_file_path(), s.getPlaylist_id());
                               // System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the genre : ");
                            String genre = scanner.next();
                            List<Song> searchsong= obj2.searchSong(genre);
                            for(Song song :searchsong) {
                                System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%20s %20d %30s %35s %40s %100s %40d \n",song.getSong_name(),song.getSong_id(),song.getSong_duration(),song.getArtist(),song.getGenre(),song.getSong_file_path(),song.getPlaylist_id());
                                System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 4:
                            obj2.addSongToPlaylist();
                            break;

                        case 5:
                            break;

                        case 6:
                            System.exit(0);


                    }
                }
                if (choice1 == 2) {
                    System.out.println("1. Display all Podcasts");
                    System.out.println("2. Sort all Podcasts");
                    System.out.println("3. Search Podcast");
                    System.out.println("4. Main Menu");
                    System.out.println("5. Exit");
                    int choice3 = scanner.nextInt();
                    PodCastImpl postcastimpl = new PodCastImpl();
                    switch (choice3) {
                        case 1:
                            System.out.println("List of Podcasts");
                            List<PodCast> allpodcastdatas = postcastimpl.display_allpodcast();
                            for (PodCast pod : allpodcastdatas)
                            {
                               // System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%20s %20d %30s %35s %40s %100s %40d \n", pod.getPodcast_name(), pod.getPlaylist_id(), pod.getPodcast_duration(), pod.getPodcast_episode(), pod.getPodcast_lang(), pod.getPodcast_file_path(), pod.getPlaylist_id());
                               // System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 2:
                            System.out.println("Sorted List of Podcast");
                            List<PodCast> sortedpodcast = postcastimpl.sort_podcasts();
                            for (PodCast pod : sortedpodcast) {
                             //   System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%20s %20d %30s %35s %40s %100s %40d \n", pod.getPodcast_name(), pod.getPlaylist_id(), pod.getPodcast_duration(), pod.getPodcast_episode(), pod.getPodcast_lang(), pod.getPodcast_file_path(), pod.getPlaylist_id());
                              //  System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the Podcast ID : ");
                            int id = scanner.nextInt();
                            PodCast podCast = postcastimpl.search_podcasts(id);
                            System.out.println("*****************************************************************************************************************************************************************************");
                            System.out.println(podCast.getPodcast_name() + "\t" + podCast.getPodcast_id() + "\t" + podCast.getPodcast_duration() + "\t" + podCast.getPodcast_episode() + "\t" + podCast.getPodcast_lang() + "\t" + podCast.getPodcast_file_path() + "\t" + podCast.getPlaylist_id());
                            System.out.println("*****************************************************************************************************************************************************************************");
                            break;
                        case 4:
                            break;
                        case 5:
                            System.exit(0);


                    }
                }
                if (choice1 == 3) {
                    System.out.println("1. Display all PlayList");
                    System.out.println("2. Sort all PlayList");
                    System.out.println("3. Add Playlist");
                    System.out.println("4. Play Song From Playlist");
                    System.out.println("5. Main Menu");
                    System.out.println("6. Exit");
                    int choice4 = scanner.nextInt();
                    PlayListImpl playListimpl = new PlayListImpl();
                    switch (choice4) {
                        case 1:
                            System.out.println("List of Playlists");
                            List<PlayList> allSongDets = playListimpl.display_asPlaylist();
                            for (PlayList play : allSongDets) {
                              //  System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%15d %20s %30s\n", play.getPlaylist_id(), play.getPlaylist_name(), play.getUserid());
                              //  System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 2:
                            System.out.println("Sorted List of Playlist");
                            List<PlayList> sorted = playListimpl.sort_Playlist();
                            for (PlayList play : sorted) {
                                System.out.println("*****************************************************************************************************************************************************************************");
                                System.out.format("%5d %20s %30s\n", play.getPlaylist_id(), play.getPlaylist_name(), play.getUserid());
                                System.out.println("*****************************************************************************************************************************************************************************");
                            }
                            break;
                        case 3:
                            boolean flag = playListimpl.addPlaylist();
                            break;
                        case 4:
                            playListimpl.Play_song_in_Playlist();
                            break;
                        case 5:
                            break;
                        case 6:
                            System.exit(0);


                    }

                }
                if (choice1 == 4) {
                    System.out.println("1: Play Songs");
                    System.out.println("2. Exit");
                    int choice5 = scanner.nextInt();
                    System.out.println("*****************************************************************************************************************");
                    SongImpl songimpl = new SongImpl();
                    switch (choice5) {
                        case 1:
                            System.out.println("Lets have fun together ");
                            System.out.println("*****************************************************************************************************************");
                            songimpl.Play_song();
                            break;
                        case 2:
                            System.exit(0);
                    }
                }
                if (choice1 == 5) {
                    System.out.println("1: Play Podcast");
                    System.out.println("2. Exit");
                    int choice5 = scanner.nextInt();
                    System.out.println("*****************************************************************************************************************************************************************************");
                    PodCastImpl podCastimpl = new PodCastImpl();
                    switch (choice5) {
                        case 1:
                            System.out.println("Gonna Enjoy !!!!!!!!!!!");
                            System.out.println("*****************************************************************************************************************************************************************************");
                            podCastimpl.Play_podcast();
                            break;
                        case 2:
                            System.exit(0);
                    }
                }
                if (choice1 == 6) {
                    System.out.println("Do you really want to exit :");
                    System.out.println("1. Yessss :");
                    System.out.println("2. Nooooo :");
                    int choice5 = scanner.nextInt();
                    System.out.println("*********THANK YOU VISIT AGAIN ***************");
                    switch (choice5) {
                        case 1:

                            System.exit(0);
                        case 2:
                            break;
                    }
                }
            }
        }


    }
}