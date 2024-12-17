package hust.soict.dsai.aims.media;

import java.util.Objects;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Playable;


public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.length > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length + " minutes");
        } else {
            System.err.println("ERROR: Track length is non-positive! Cannot play track: " + this.title);
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Type check

        Track track = (Track) obj;
        return length == track.length && Objects.equals(title, track.title); // Title and length equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length); // Consistent with equals
    }
}
