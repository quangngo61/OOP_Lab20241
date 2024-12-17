package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Disc extends Media{

	private String director;
	private int length;
	
	public Disc(int id, String title, String category, float cost, int length, String director) {
        this.length = length;
        this.director = director;
    }
	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		
	}

	
}
