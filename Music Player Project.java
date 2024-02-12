import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

class MusicPlayer {
    private List<Song> playlist;
    private int currentSongIndex;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentSongIndex = -1;
    }

    public void addSong(String title, String artist) {
        playlist.add(new Song(title, artist));
    }

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. Add songs to play.");
            return;
        }
        currentSongIndex = 0;
        System.out.println("Playing: " + playlist.get(currentSongIndex));
    }

    public void next() {
        if (currentSongIndex == -1) {
            System.out.println("No song is playing. Use 'play' to start playing.");
            return;
        }
        currentSongIndex = (currentSongIndex + 1) % playlist.size();
        System.out.println("Playing next: " + playlist.get(currentSongIndex));
    }

    public void previous() {
        if (currentSongIndex == -1) {
            System.out.println("No song is playing. Use 'play' to start playing.");
            return;
        }
        currentSongIndex = (currentSongIndex - 1 + playlist.size()) % playlist.size();
        System.out.println("Playing previous: " + playlist.get(currentSongIndex));
    }
}

public class MusicPlayerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        System.out.println("Welcome to the Music Player App!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add song");
            System.out.println("2. Play");
            System.out.println("3. Next");
            System.out.println("4. Previous");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    player.addSong(title, artist);
                    System.out.println("Song added: " + title + " by " + artist);
                    break;
                case 2:
                    player.play();
                    break;
                case 3:
                    player.next();
                    break;
                case 4:
                    player.previous();
                    break;
                case 5:
                    System.out.println("Thank you for using the Music Player App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
