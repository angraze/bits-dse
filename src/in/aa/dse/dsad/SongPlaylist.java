package in.aa.dse.dsad;

import java.util.Scanner;

public class SongPlaylist {

    private LinkedList songList;
    private Scanner scanner;

    public static void main(String[] args) {
        // write your code here
        SongPlaylist program = new SongPlaylist();
        program.execute();
    }

    private void execute() {
        songList = new LinkedList();
        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.println("Enter menu option:");
            String input = scanner.nextLine();
            switch (input.trim()) {
                case "1":
                    addSong();
                    break;
                case "2":
                    deleteSong();
                    break;
                case "3":
                    findSongByName();
                    break;
                case "4":
                    navigateTracks();
                    break;
                case "5":
                    sortPlaylist();
                    break;
                case "6":
                    displayPlaylist();
                    break;
                case "7":
                    exit = true;
            }
        }
    }

    private void addSong() {
        System.out.println("Enter song title:");
        String title = scanner.nextLine();
        System.out.println("Enter song duration:");
        String duration = scanner.nextLine();
        songList.addSong(title, duration);
    }

    private void deleteSong() {
        System.out.println("Enter song position for delete:");
        String trackNum = scanner.nextLine();
        songList.deleteAtPos(Integer.parseInt(trackNum.trim()));
    }

    private void findSongByName() {
        System.out.println("Enter the name of the song:");
        String title = scanner.nextLine();
        songList.findSong(title);
    }

    private void navigateTracks() {
        System.out.println("Enter the the track number to start from:");
        int trackNum = Integer.parseInt(scanner.nextLine().trim());
        songList.getSongAtPos(trackNum);
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter n for Next track, p for Previous track, e for Exit:");
            String choice = scanner.nextLine();
            switch (choice.trim()) {
                case "n":
                    songList.getSongAtPos(++trackNum);
                    break;
                case "p":
                    songList.getSongAtPos(--trackNum);
                    break;
                case "e":
                    exit = true;
            }
        }
    }

    private void sortPlaylist() {
        songList.sortList();
    }

    private void displayPlaylist() {
        System.out.printf("Playlist currently contains %1$d song(s).\n", songList.size());
        songList.display();
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("Playlist Operations:");
        System.out.println();
        System.out.println("1. Add a song to the playlist");
        System.out.println("2. Delete a song from playlist");
        System.out.println("3. Find a song by name");
        System.out.println("4. Next track / previous track");
        System.out.println("5. Sort playlist by song title");
        System.out.println("6. Display playlist");
        System.out.println("7. Exit");
        System.out.println();
    }
}
