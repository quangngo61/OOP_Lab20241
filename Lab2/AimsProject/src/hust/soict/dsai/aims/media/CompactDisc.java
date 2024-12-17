package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("Artist: " + this.artist);
            System.out.println("CD length: " + this.getLength() + " minutes");

            for (Track track : tracks) {
                try {
                    track.play(); // Play each track, may throw PlayerException if length is invalid
                } catch (PlayerException e) {
                    // Catch the exception for invalid track length and rethrow it as part of the CD play process
                    System.err.println("ERROR: " + e.getMessage());
                    throw new PlayerException("ERROR: CD contains a track that cannot be played: " + track.getTitle());
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive! Cannot play this CD: " + this.getTitle());
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getLength() + " minutes: " + getCost() + " $";
    }
}
