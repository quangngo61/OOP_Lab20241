package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

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
        if (this == obj) return true; // Reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Type check

        Media media = (Media) obj;
        return Objects.equals(title, media.title); // Title equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(title); // Consistent with equals
    }
    
    /*@Override
    public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Double.compare(other.getCost(), this.getCost()); // Higher cost first
    }
    
    public static Comparator<Media> compareByCostThenTitle() {
        return Comparator.comparingDouble(Media::getCost)
                         .reversed()
                         .thenComparing(Media::getTitle);
    }*/
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    

}
