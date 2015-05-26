import javax.swing.*;

//Thomas Thorne 3120240 - SENG1110
public class Interface {
    // Instance variables for interface
    private String action = "";
    private Playlist playlist1;
    private Playlist playlist2;
    private boolean loop;
    private SongDatabase database;

    // Constructor
    public Interface() {
	action = "";
	playlist1 = null;
	playlist2 = null;
	loop = true;
	database = new SongDatabase();
    }

    // Getters and setters
    public Playlist getPlaylist1() {
	return playlist1;
    }

    public Playlist getPlaylist2() {
	return playlist2;
    }

    private void run() {
	SongDatabase database = new SongDatabase();
	// Loop used to display and run main menu
	while (loop) {
	    action = JOptionPane
		    .showInputDialog("*Please enter the number (digit) of the action you wish to perform*\n\n1: Add a song to database \n2: Create a Playlist \n3: Add song to existing playlist \n4: Remove a song from database \n5: Remove a song from Playlist \n6: Remove a Playlist \n7: List Songs in Database \n9: Exit");
	    if (action == null) {
		action = "8";

	    }
	    switch (action) {
	    /*
	     * Precondition: Song attributes are not empty, length and size are
	     * > 0 Postcondtion:
	     */
	    // Add a song to database - using setter for song then the add song
	    // to database method
	    case "1":
		if (!database.DBFull()) {
		    Song tempSong = new Song();
		    tempSong.setName(JOptionPane.showInputDialog("please enter the name (string)"));
		    tempSong.setArtist(JOptionPane.showInputDialog("please enter the Artist (string)"));
		    tempSong.setFileSize(Double.parseDouble(JOptionPane.showInputDialog("please enter the file size in MB (float)")));
		    tempSong.setDuration(Double.parseDouble(JOptionPane.showInputDialog("please enter the song lenth in seconds (float)")));
		    database.addSong(tempSong);
		} else {
		    JOptionPane.showMessageDialog(null, "Database may only contain 4 songs, please remove a song", "Error adding Song",
			    JOptionPane.ERROR_MESSAGE);
		}

		break;

	    /*
	     * Precondition: There are songs in database and 2 playlist have not
	     * been made Postcondition:Create playlist object, set name and add
	     * songs This allows the user to create a playlist, by naming the
	     * playlist and adding up to three songs I created this option to
	     * avoid any ambiguity between creating a playlist and simply adding
	     * songs to playlist
	     */
	    case "2":
		boolean addToPlay = true;
		if (playlist1 == null) {
		    playlist1 = new Playlist();
		    playlist1.setplaylistName(JOptionPane.showInputDialog("Please enter a name for your playlist"));
		    String playlistAdd;
		    while (addToPlay) {
			if (!playlist1.playlistFull()) {
			    playlistAdd = JOptionPane.showInputDialog("*Please enter the Number of the song you wish to add* \n"
				    + database.listDatabase() + "\nExit: type 'Exit' or click Cancel");
			    if (playlistAdd == null) {
				playlistAdd = "Exit";
			    }
			    switch (playlistAdd) {

			    case "1":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist1.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song? Enter 'yes' or 'no'");
				    if (anotherSong == null) {
					anotherSong = "no";
				    }
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    default:
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;

			    case "2":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist1.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song?  Enter 'yes' or 'no'");
				    if (anotherSong == null) {
					anotherSong = "no";
				    }
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    default:
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;

			    case "3":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist1.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song? Enter 'yes' or 'no'");
				    if (anotherSong == null) {
					anotherSong = "no";
				    }
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    default:
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;
			    case "4":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist1.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song? Enter 'yes' or 'no'");
				    if (anotherSong == null) {
					anotherSong = "no";
				    }
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    default:
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;

			    case "Exit":
				addToPlay = false;
				break;

			    default:
				JOptionPane.showInputDialog("not an option");
				break;
			    }
			}

			else {
			    JOptionPane.showMessageDialog(null, "Playlist Full", "Error", JOptionPane.PLAIN_MESSAGE);
			    addToPlay = false;
			}
		    }
		    break;

		} else if (playlist2 == null) {
		    playlist2 = new Playlist();
		    playlist2.setplaylistName(JOptionPane.showInputDialog("Please enter a name for your playlist"));
		    String playlistAdd;
		    while (addToPlay) {
			if (!playlist2.playlistFull()) {
			    playlistAdd = JOptionPane.showInputDialog(database.listDatabase() + "\nExit: type 'Exit' or click Cancel");
			    if (playlistAdd == null) {
				playlistAdd = "Exit";
			    }

			    switch (playlistAdd) {

			    case "1":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist2.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song?");
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;

			    case "2":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist2.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song?");
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;

			    case "3":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist2.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song?");
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;
			    case "4":
				if (database.getSong(Integer.parseInt(playlistAdd)) != null) {
				    playlist2.addPlaylistSong(database.getSong(Integer.parseInt(playlistAdd)));
				    String anotherSong = JOptionPane.showInputDialog("Would you like to Add another Song?");
				    switch (anotherSong) {
				    case "yes":
					break;
				    case "no":
					addToPlay = false;
					break;
				    }
				}

				else {
				    JOptionPane.showMessageDialog(null, "Song Not in Database", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				break;

			    case "Exit":
				addToPlay = false;
				break;

			    default:
				JOptionPane.showInputDialog("not an option");
				break;
			    }
			}

			else {
			    JOptionPane.showMessageDialog(null, "Playlist Full", "Error", JOptionPane.PLAIN_MESSAGE);
			    addToPlay = false;
			}
		    }
		    break;
		}

		else {
		    JOptionPane.showMessageDialog(null, "No room for playlist", "Error", JOptionPane.PLAIN_MESSAGE);
		    addToPlay = false;
		}
		break;

	    /*
	     * In addition to adding a song to playlist upon creation of the
	     * playlist this gives the user to option to add a song later, after
	     * playlist is created Precondition: Playlist exists, Song exist in
	     * database Postcondition: Add song to playlist
	     */
	    case "3":
		if (playlist1 != null && playlist2 != null) {
		    String chooseplaylist = JOptionPane.showInputDialog("1: Playlist1 (Contains " + playlist1.GetSongsInList() + " )"
			    + "\n1: Playlist2 (Contains " + playlist2.GetSongsInList() + " )");
		    switch (chooseplaylist) {
		    case "1":
			String addtoplay = JOptionPane.showInputDialog(database.listDatabase() + "\nExit: type 'Exit' or click Cancel");
			playlist1.addPlaylistSong(database.getSong(Integer.parseInt(addtoplay)));
			break;
		    }
		    switch (chooseplaylist) {
		    case "2":
			String addtoplay1 = JOptionPane.showInputDialog(database.listDatabase() + "\nExit: type 'Exit' or click Cancel");
			playlist2.addPlaylistSong(database.getSong(Integer.parseInt(addtoplay1)));
			break;
		    }
		}

		else if (playlist1 != null) {
		    String chooseplaylist = JOptionPane.showInputDialog("1: Playlist1 (Contains " + playlist1.GetSongsInList() + " )");
		    switch (chooseplaylist) {
		    case "1":
			String addtoplay = JOptionPane.showInputDialog(database.listDatabase() + "\nExit: type 'Exit' or click Cancel");
			playlist1.addPlaylistSong(database.getSong(Integer.parseInt(addtoplay)));
			break;
		    }
		} else if (playlist2 != null) {
		    String chooseplaylist = JOptionPane.showInputDialog("2: Playlist2 (Contains " + playlist2.GetSongsInList() + " )");
		    switch (chooseplaylist) {
		    case "1":
			String addtoplay = JOptionPane.showInputDialog(database.listDatabase() + "\nExit: type 'Exit' or click Cancel");
			playlist1.addPlaylistSong(database.getSong(Integer.parseInt(addtoplay)));
			break;
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Please create a Playlist", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		break;

	    /*
	     * Remove song from database Precondition: The database contains
	     * songs Postcondition: Delete the Selected Song in Database by
	     * setting it to null, Search for song in playlist and delete if
	     * found
	     */
	    case "4":
		if (!database.DBempty()) {
		    String removeSong = JOptionPane.showInputDialog("*Please enter the Number of the song you wish to Delete*\n\n"
			    + database.listDatabase() + "\nExit");
		    if (database.getSong(Integer.parseInt(removeSong)) != null) {
			switch (removeSong) {

			case "1":
			    if (playlist1 != null && playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
				for (int i = 1; i <= 3; i++) {
				    if (playlist2.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist2.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist1 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    }

			    database.removeDBSong(1);
			    break;

			case "2":
			    if (playlist1 != null && playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
				for (int i = 1; i <= 3; i++) {
				    if (playlist2.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist2.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist1 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    }

			    database.removeDBSong(2);
			    break;

			case "3":
			    if (playlist1 != null && playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
				for (int i = 1; i <= 3; i++) {
				    if (playlist2.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist2.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist1 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    }

			    database.removeDBSong(3);
			    break;
			case "4":
			    if (playlist1 != null && playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
				for (int i = 1; i <= 3; i++) {
				    if (playlist2.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist2.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist1 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    } else if (playlist2 != null) {
				for (int i = 1; i <= 3; i++) {
				    if (playlist1.songInPlaylist(i, database.getSong(Integer.parseInt(removeSong)))) {
					playlist1.removePlaylistSong(i);
				    } else {
					continue;
				    }
				}
			    }

			    database.removeDBSong(4);
			    break;

			default:
			    JOptionPane.showMessageDialog(null, "Please enter a value that corresponds with a song", "Error",
				    JOptionPane.PLAIN_MESSAGE);
			    break;
			}
			break;
		    }
		}

		else {
		    JOptionPane.showMessageDialog(null, "No Songs in Database", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		break;

	    /*
	     * Remove a Song from playlist Precondition: There is an existing
	     * playlist that contains songs. Postcondition: User selects
	     * playlist, then selects song to delete, which is set to null
	     */

	    case "5":
		if ((playlist1 != null) && (playlist2 != null)) {
		    String songRemove = JOptionPane.showInputDialog(("*Enter number of playlist you wish to edit*\n\n1:n"
			    + playlist1.getplaylistName() + "\n\n" + "2:n" + playlist2.getplaylistName() + "\n\nExit"));
		    switch (songRemove) {
		    case "1":
			String songNo = JOptionPane.showInputDialog("*Please Enter number of song you wish to delete*\n" + playlist1.listPlaylist());
			playlist1.removePlaylistSong(Integer.parseInt(songNo));
			break;
		    case "2":
			String songNo1 = JOptionPane.showInputDialog("*Please Enter number of song you wish to delete\n*" + playlist2.listPlaylist());
			playlist2.removePlaylistSong(Integer.parseInt(songNo1));
			break;
		    default:
			break;

		    }
		} else if (playlist1 != null && !playlist1.playListEmpty()) {
		    String songNo = JOptionPane.showInputDialog("*Please Enter number of song you wish to delete*\n" + playlist1.listPlaylist());
		    if (songNo != null && !songNo.equals("")) {
			playlist1.removePlaylistSong(Integer.parseInt(songNo));
		    } else
			break;
		} else if (playlist2 != null) {
		    String songNo = JOptionPane.showInputDialog("*Please Enter number of song you wish to delete*\n" + playlist2.listPlaylist());
		    if (songNo != null && !songNo.equals("")) {
			playlist2.removePlaylistSong(Integer.parseInt(songNo));
		    } else
			break;
		} else
		    JOptionPane.showMessageDialog(null, "There are no existing playlists, Please create a playlist", "Error",
			    JOptionPane.PLAIN_MESSAGE);
		break;

	    /*
	     * remove a playlist by setting it to null Precondition: There must
	     * be an existing playlist to delete Postcondition: the selected
	     * playlist will be reset to null
	     */
	    case "6":
		if ((playlist1 != null) && (playlist2 != null)) {
		    String removeplay = JOptionPane.showInputDialog("Please enter the number of the playlist you wish to remove\n" + "1:"
			    + playlist1.getplaylistName() + "\n" + "2:" + playlist2.getplaylistName());
		    switch (removeplay) {
		    case "1":
			playlist1 = null;
			break;
		    case "2":
			playlist2 = null;
			break;
		    default:
			JOptionPane.showInputDialog("Not an option");
			break;
		    }
		} else if (playlist1 != null) {
		    String removeplay = JOptionPane.showInputDialog("Please enter the number of the playlist you wish to remove\n" + "1:"
			    + playlist1.getplaylistName());
		    switch (removeplay) {
		    case "1":
			playlist1 = null;
			break;
		    default:
			JOptionPane.showInputDialog("Not an option");
			break;
		    }
		} else if (playlist2 != null) {
		    String removeplay = JOptionPane.showInputDialog("Please enter the number of the playlist you wish to remove \n" + "1:"
			    + playlist2.getplaylistName());
		    switch (removeplay) {
		    case "1":
			playlist2 = null;
			break;
		    default:
			JOptionPane.showInputDialog("Not an option");
			break;
		    }
		} else
		    JOptionPane.showMessageDialog(null, "No Playlists available", "Error", JOptionPane.PLAIN_MESSAGE);
		break;

	    /*
	     * List Songs in Database less than specified input Precondition, length is not negative number:
	     * Songs exist in database Postcondition: display all songs with a
	     * duration less than specified input
	     */
	    case "7":
		if (!database.DBempty()) {
		    String songsDuration;
		    songsDuration = JOptionPane.showInputDialog("Please enter the maximum duration of songs you would like displayed (seconds)");
		    if (songsDuration != null && !songsDuration.equals("")){
			Double songsDurationD = Double.parseDouble(songsDuration);
			JOptionPane.showInputDialog(database.filterByLength(songsDurationD));
			break;}
		    else break;
		    
		} else
		    JOptionPane.showMessageDialog(null, "No Songs stored in database", "Error", JOptionPane.PLAIN_MESSAGE);
		break;

	    case "8":
		loop = false;
		break;

	    default:
		JOptionPane.showInputDialog("done");
	    }
	}
    }

    public static void main(String[] args) {
	Interface intFace = new Interface();
	intFace.run();
    }
}
