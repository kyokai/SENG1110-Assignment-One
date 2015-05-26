//Thomas Thorne 3120240 - SENG1110
public class Song {
  
    // Instance variables 
    
    private String name;
    private String artist;
    private Double fileSize;
    private Double duration;

    // Song constructor

    public Song() {
	name = "";
	artist = "";
	fileSize = 0.00;
	duration = 0.00;
    }

    //  Methods to Set Song attributes 

    public void setName(String newName) {
	this.name = newName;
    }

    public void setArtist(String newArtist) {
	this.artist = newArtist;
    }

    public void setFileSize(Double newfileSize) {
	this.fileSize = newfileSize;
    }

    public void setDuration(Double newDuration) {
	this.duration = newDuration;
    }

    // Methods to get Song attributes 
    public String getName() {
	return this.name;
    }

    public String getArtist() {
	return this.artist;
    }

    public Double getFileSize() {
	return this.fileSize;
    }

    public Double getDuration() {
	return this.duration;
    }

    //  Additional methods to enhance functionality 

    /*
     * Check if one song is equal to another, by comparing all the variables of
     * both songs ignoring case
     */
    public boolean equals(Object other) {
	if (!(other instanceof Song)) {
	    return false;
	} else {
	    Song that = (Song) other;
	    return this.name.equalsIgnoreCase(that.name) 
		    && this.artist.equalsIgnoreCase(that.artist) 
		    && this.fileSize.equals(that.fileSize)
		    && this.duration.equals(that.duration);
	}
    }

    // Method to display the attributes of an individual song, using getters

    public String displaySong() {
	return ("name: " + getName() + "\nArtist: " + getArtist() + "\nFile Size: " + getFileSize() + "\nFile Duration " + getDuration());
    }
}

