package hust.soict.dsai.aims.media;

import java.util.Objects;

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
    public void play() {
        if (this.length > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length + " minutes");
        } else {
            System.out.println("Cannot play track: " + this.title + ". Length is zero or invalid.");
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
