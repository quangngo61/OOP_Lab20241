package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }
	
	public String getArtist() {
		return artist;
	}
	
	 // Add a track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track '" + track.getTitle() + "' is already in the CD.");
        } else {
            tracks.add(track);
        }
    }

    // Remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("The track '" + track.getTitle() + "' is not in the CD.");
        }
    }

    // Calculate total length of the CD
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("Artist: " + this.artist);
            System.out.println("CD length: " + this.getLength() + " minutes");
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("Cannot play this CD: " + this.getTitle() + ". Length is zero or invalid.");
        }
    }
	
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getLength() + " minutes: " + getCost() + " $";
    }

    
}
