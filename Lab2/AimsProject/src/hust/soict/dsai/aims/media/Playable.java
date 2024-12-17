package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public interface Playable {
    // Add the throws declaration to the play() method
    public void play() throws PlayerException;
}
