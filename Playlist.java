import javax.swing.JOptionPane;
//Thomas Thorne 3120240 - SENG1110
public class Playlist {
	
	/// Instance variables ///
	private int SongsInList;
	private String playlistName;
	private Song song1;
	private Song song2;
	private Song song3;
	private final Double MAX_TIME = 720.00; // decided to keep all song duration in seconds
	private final Double MAX_SIZE = 10.00;
	private Double playListTime = 0.00;
	private Double playListSize = 0.00;
	
	/// Playlist constructor///
	
	public Playlist(){
		 playlistName = "";
		 SongsInList = 0;
		 song1 = null;
		 song2 = null;
		 song3 = null;
		 playListTime = 0.00;
		 playListSize = 0.00;}
	
	///Setters and Getters ///
	
	public void setplaylistName(String newname){
			playlistName = newname;}
	
	public String getplaylistName(){
		return playlistName;}
	
	public int GetSongsInList(){
		return SongsInList;}
	
	// method to check if playlist is empty
	
	public boolean playListEmpty(){
		return SongsInList == 0;}
	
	// Using equals method from song class to check if song exists in playlist
	
	public boolean songInPlaylist(int i, Song song){
			if (getSongPlaylist(i) == null){return false;}
			else if (getSongPlaylist(i).equals(song)){return true;}
			else{return false;}
			}

	/*Using the spaceInPlaylist method, this addPlaylistSong finds an empty space for a new song
	and assigns the new song to that space*/
	
	public void addPlaylistSong(Song song) {
		if ((((song.getFileSize() + playListSize) <= MAX_SIZE) && ((song
				.getDuration() + playListTime) <= MAX_TIME))) {
			switch (spaceInPlaylist()) {
			case 0:
				song1 = song;
				playListTime += song1.getDuration();
				playListSize += song1.getFileSize();
				SongsInList += 1;
				break;
			case 1:
				if (!song.equals(song1)) {
					song2 = song;
					playListTime += song2.getDuration();
					playListSize += song2.getFileSize();
					SongsInList += 1;
				} else {
					JOptionPane.showMessageDialog(null,
							"Song already exists in Database",
							"Error adding Song", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 2:
				if (!song.equals(song1) && !song.equals(song2)) {
					song3 = song;
					playListTime += song3.getDuration();
					playListSize += song3.getFileSize();
					SongsInList += 1;
				} else {
					JOptionPane.showMessageDialog(null,
							"Song already exists in Database",
							"Error adding Song", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				JOptionPane.showMessageDialog(null,
						"Playlist may only contain 3 songs", "Error",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
// Check to see if the song is too large for the playlist
		else if (song.getFileSize() + playListSize > MAX_SIZE) {
			JOptionPane.showMessageDialog(null,
					"Sorry, playlist may not exceed " + MAX_SIZE + " MB.\n Your current playlist size is " + playListSize, "Error",
					JOptionPane.PLAIN_MESSAGE);
		}
// Check to see if the song is too long in duration for playlist
		else if (song.getDuration() + playListTime > MAX_TIME) {
			JOptionPane.showMessageDialog(null,
					"Sorry, playlist may not exceed " + MAX_SIZE + " Seconds.\n Your current playlist Duration is " + playListTime, "Error",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

//Search for an empty song place in playlist
	public int spaceInPlaylist() {
		if (song1 == null) {
			return 0;
		} else if (song2 == null) {
			return 1;
		} else if (song3 == null) {
			return 2;
		}

		else
			return 3;
	}

//Remove song from playlist by setting its value to null
	public void removePlaylistSong(int n) {

		if (SongsInList == 0) {
			System.out.println("No songs in List");}
		else {
			switch (n) {
			case 1:
				song1 = null;
				SongsInList -= 1;
				break;
			case 2:
				song2 = null;
				SongsInList -= 1;
				break;
			case 3:
				song3 = null;
				SongsInList -= 1;
				break;
			default:
				System.out.println("Number does not match a song in playlist, please try again");}
		}
	}
	
//Method used to help display the content of the Playlist, uses Display song method from Song class
	public String listPlaylist(){
		int i = 1;
		String songList = "";
		if (SongsInList > 0){
			while (i <= 3 ){
				if (getSongPlaylist(i) != null){
				songList += ("\nSong: " + i + "\n" + getSongPlaylist(i).displaySong()+ "\n");
				 i += 1;}
				else{
					i += 1;}}
			return songList;}
		
		else {return "Database Empty";}
		
	}
	
//Get specific playlist song
	public Song getSongPlaylist(int i){
		switch (i){
		case 1: return song1;
		
		case 2: return song2;
		
		case 3: return song3;
		
		default: return null;}}

//Check if playlist has reached maximum limit
	public boolean playlistFull(){
		return SongsInList==3;
	}

//Iterate through playlist	
	public Song playlistIterator(){
		for (int i = 1; i<=3; i++){
			if (getSongPlaylist(i) == null){
				continue;}
			else{return getSongPlaylist(i);}
		}return null;
	}
}

