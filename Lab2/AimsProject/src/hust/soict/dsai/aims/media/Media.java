package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

import hust.soict.dsai.aims.exception.PlayerException;

public abstract class Media {

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        // Default constructor
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Reference equality check
        }

        if (obj == null || !(obj instanceof Media)) {
            return false; // Null check and class type check
        }

        Media media = (Media) obj;
        return Objects.equals(title, media.title); // Compare titles for equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(title); // Hash based on title
    }

    public abstract void play() throws PlayerException;

    // Comparator for sorting by title, then cost
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            int titleComparison = media1.getTitle().compareToIgnoreCase(media2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(media1.getCost(), media2.getCost());  // Sort by cost if titles are equal
        }
    };

    // Comparator for sorting by cost, then title
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            int costComparison = Float.compare(media1.getCost(), media2.getCost());
            if (costComparison != 0) {
                return costComparison;
            }
            return media1.getTitle().compareToIgnoreCase(media2.getTitle());  // Sort by title if costs are equal
        }
    };
}
