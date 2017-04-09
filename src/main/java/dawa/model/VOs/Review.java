package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
public class Review {

    private int points;
    private String text;
    private int author;

    public Review(int points, String text, int author) {
        this.points = points;
        this.text = text;
        this.author = author;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        return points == review.points;
    }

    @Override
    public int hashCode() {
        return points;
    }
}
