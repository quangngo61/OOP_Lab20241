package hust.soict.dsai.disc;

public class DigitalVideoDisc {
    
    // Class attribute to track the number of DVDs created
    private static int nbDigitalVideoDiscs = 0;
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id; // Instance attribute for the DVD id
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++; // Increment the DVD count
        this.id = nbDigitalVideoDiscs; // Assign the id based on the count
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    
    
    //Return info of a disc
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " minutes: " + cost + " $";
    }

    // Method to check if the title matches
    public boolean isMatch(String searchTitle) {
        return this.title.equalsIgnoreCase(searchTitle); // case-insensitive comparison
    }
}
