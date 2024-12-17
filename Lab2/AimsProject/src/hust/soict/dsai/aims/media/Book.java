package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class Book extends Media {

	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		
	}
	
	//add Author
	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("The author '" + authorName + "' is already in the list.");
        }
    }

    // Remove an author from the list
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) { // Ensure the author is in the list
            authors.remove(authorName);
        } else {
            System.out.println("The author '" + authorName + "' is not in the list.");
        }
    }
	
    
    @Override
    public String toString() {
        String authorsList = String.join(", ", authors); // Joining authors into a string
        return "Book - " + getTitle() + " - " + getCategory() + " - " + authorsList + ": " + getCost() + " $";
    }

	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		
	}

	
}
