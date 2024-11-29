package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    // Class attribute to track the number of DVDs created
    private static int nbDigitalVideoDiscs = 0;

    // Constructor for full DVD details
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    // Constructor without length
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director); // Default length to 0
    }

    // Constructor with only title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null); // Default length and director to null
    }

    // Constructor with only title
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0, 0, null); // Default other fields to null or 0
    }

    // Method to return DVD information
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + 
               " - " + getLength() + " minutes: " + getCost() + " $";
    }

    // Method to check if the title matches
    public boolean isMatch(String searchTitle) {
        return this.getTitle().equalsIgnoreCase(searchTitle); // case-insensitive comparison
    }
    
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("Cannot play this DVD: " + this.getTitle() + ". Length is zero or invalid.");
        }
    }
}
