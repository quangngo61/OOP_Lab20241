package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismExample {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        // Create media objects
        Media cd = new CompactDisc(4, "Hello VN", "Tourism", 45.00f, "NOO", 15, "Minh Quang");
        Media dvd = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        Media book = new Book(1,"Effective Java", "Programming", 45.00f);

        // Add media objects to the list
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Iterate through the list and print using toString()
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}