package in.aa.dse.dsad;

public class LinkedList {

    private Node first = null;
    private Node last = null; // TODO do we need this?
    private int size = 0;


    private boolean isValidTitle(String t) {
        return (t != null && !"".equals(t.trim()));
    }

    private boolean isValidDuration(String dur) {
        return (dur != null && !"".equals(dur.trim()) && dur.matches("\\d{0,2}:\\d{2}"));
    }

    /**
     * Adds a song with given title and duration into song list.
     *
     * @param t   song title
     * @param dur duration of song in <mm:ss> format
     */
    public void addSong(String t, String dur) {
        if (isValidTitle(t) && isValidDuration(dur)) {
            Node song = new Node(t, dur);
            if (size == 0) {
                first = song;
                last = song;
            } else {
                last.setRight(song);
                song.setLeft(last);
                last = song;
            }
            size++;
            System.out.printf("Added the song '%1$s' to the playlist.\n", t);
        } else {
            System.out.printf("Error! Song not added. Format of either song title=%1$s or duration=%2$s is not correct.\n", t, dur);
        }
    }

    /**
     * Finds the song with supplied title in song list and returns the track number if available.
     *
     * @param t song title we are searching in song list
     * @return track number of the song.
     */
    public int findSong(String t) {
        if (!isValidTitle(t)) {
            System.out.printf("Error! the song title '%1$s' is not valid.\n", t);
            throw new RuntimeException("Invalid title.");
        }
        int trackNum = 1;
        Node song = first;
        boolean found = false;
        while (song != null) {
            if (song.getTitle().equalsIgnoreCase(t)) {
                found = true;
                break;
            } else {
                song = song.next();
                trackNum++;
            }
        }
        if (found) {
            System.out.printf("The song '%1$s' is present at position %2$d.\n", t, trackNum);
            return trackNum;
        } else {
            System.out.printf("The song '%1$s' is not present in song list.\n", t);
            return -1;
        }
    }

    /**
     * Deletes the song at supplied position if it is valid.
     *
     * @param pos position of the song to be deleted
     */
    public void deleteAtPos(int pos) {
        if (pos <= 0 || pos > size) {
            System.out.printf("Error!. There is no position '%1$d' in song list.\n", pos);
            return;
        }

        Node song = first;
        int trackNum = 1;
        while (song != null) {
            if (trackNum == pos) {
                Node prev = song.previous();
                Node next = song.next();
                prev.setRight(next);
                next.setLeft(prev);
                System.out.printf("Deleted song '%1$s' at position %2$d.\n", song.getTitle(), pos);
                song = null;
                break;
            } else {
                song = song.next();
                trackNum++;
            }
        }
    }

    /**
     * Returns the song title at the supplied position if it is valid.
     *
     * @param pos position of the song we are looking for
     * @return the title of the song
     */
    public String getSongAtPos(int pos) {
        String songTitle = "";
        if (pos <= 0 || pos > size) {
            System.out.printf("Error!. There is no position %1$d in song list.\n", pos);
            return songTitle;
        }

        Node song = first;
        int trackNum = 1;
        while (song != null) {
            if (trackNum == pos) {
                System.out.printf("Current song is %1$d. %2$s\n", pos, song.getTitle());
                songTitle = song.getTitle();
                break;
            } else {
                song = song.next();
                trackNum++;
            }
        }
        if ("".equalsIgnoreCase(songTitle)) {
            System.out.printf("No song found at position %1$d", pos);
        }
        return songTitle;
    }

    /**
     * Sorts the song list according to alphabetical order of song title in ascending order.
     */
    public void sortList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Displays the position, song title and duration of all songs in the song list.
     */
    public void display() {

        Node song = first;
        int trackNum = 1;
        if (size > 0) {
            while (song != null) {
                System.out.printf("%1$d. %2$s <%3$s>\n", trackNum, song.getTitle(), song.getDuration());
                song = song.next();
                trackNum++;
            }
        }
    }

    public int size() {
        return size;
    }
}

