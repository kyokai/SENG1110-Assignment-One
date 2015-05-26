import javax.swing.JOptionPane;
//Thomas Thorne 3120240 - SENG1110
public class SongDatabase {
    // Instance variables

    private int noOfSongs;
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;

    // Constructor

    public SongDatabase() {
	noOfSongs = 0;
	song1 = null;
	song2 = null;
	song3 = null;
	song4 = null;
    }

    // Getters and setters
    public Song getSong(int i) {
	switch (i) {
	case 1:
	    return song1;

	case 2:
	    return song2;

	case 3:
	    return song3;

	case 4:
	    return song4;

	default:
	    return null;
	}
    }

    public int getNoOfSongs() {
	return this.noOfSongs;
    }

    // Check for empty database
    public boolean DBempty() {
	return noOfSongs == 0;
    }

    // Check for full database
    public boolean DBFull() {
	return noOfSongs == 4;
    }

    // Check if full or if song already exists in data base, if not, add song to
    // database
    public void addSong(Song song) {

	switch (songSpace()) {
	case 0:
	    song1 = song;
	    noOfSongs += 1;
	    break;
	case 1:
	    if (!song.equals(song1)) {
		song2 = song;
		noOfSongs += 1;
	    } else {
		JOptionPane.showMessageDialog(null, "Song already exists in Database", "Error adding Song", JOptionPane.ERROR_MESSAGE);

	    }
	    break;
	case 2:
	    if (!song.equals(song1) && !song.equals(song2)) {
		song3 = song;
		noOfSongs += 1;
	    } else {
		JOptionPane.showMessageDialog(null, "Song already exists in Database", "Error adding Song", JOptionPane.ERROR_MESSAGE);
	    }
	    break;
	case 3:
	    if (!song.equals(song1) && !song.equals(song2) && !song.equals(song3)) {
		song4 = song;
		noOfSongs += 1;
	    } else {
		JOptionPane.showMessageDialog(null, "Song already exists in Database", "Error adding Song", JOptionPane.ERROR_MESSAGE);
	    }
	    break;

	default:
	    JOptionPane.showMessageDialog(null, "Database may only contain 4 songs, please remove a song", "Error adding Song",
		    JOptionPane.ERROR_MESSAGE);
	}
    }

    /*
     * This method is used to find the next empty song slot in order to help add
     * a song to the database
     */
    public int songSpace() {
	if (song1 == null) {
	    return 0;
	} else if (song2 == null) {
	    return 1;
	} else if (song3 == null) {
	    return 2;
	} else if (song4 == null) {
	    return 3;
	} else
	    return 4;
    }

    // Used to help display database contents
    public String listDatabase() {
	int i = 1;
	String songList = "";
	if (noOfSongs > 0) {
	    while (i <= 4) {
		if (getSong(i) == null) {
		    i += 1;
		    continue;
		} else {
		    songList += ("Song: " + i + "\n" + getSong(i).displaySong() + "\n");
		    i += 1;
		}
	    }
	    return songList;
	}

	else {
	    return "Database Empty";
	}
    }

    /*
     * Method to filter database songs by their duration, iterate though DB Find
     * songs less than specified length
     */
    public String filterByLength(Double length) {
	String filteredSongs = "";
	for (int i = 1; i <= 4; i++) {
	    if (getSong(i) != null) {
		if (getSong(i).getDuration() < length) {
		    filteredSongs += (getSong(i).displaySong() + "\n\n");
		}
	    } else {
		continue;
	    }
	}
	return filteredSongs;
    }

    /* Remove song from database method */
    public void removeDBSong(int n) {

	if (noOfSongs == 0) {
	    JOptionPane.showMessageDialog(null, "There are no songs in the database", "Error Removing Song", JOptionPane.ERROR_MESSAGE);
	} else {
	    switch (n) {
	    case 1:
		song1 = null;
		noOfSongs -= 1;
		break;
	    case 2:
		song2 = null;
		noOfSongs -= 1;
		break;
	    case 3:
		song3 = null;
		noOfSongs -= 1;
		break;
	    case 4:
		song4 = null;
		noOfSongs -= 1;
		break;
	    default:
		System.out.println("Number does not match a song in Database, please try again");

	    }

	}
    }

}
