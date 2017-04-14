package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
@SuppressWarnings("unused")
public class Review {

    private String authorEmail;
    private String authorName;
    private int points;
    private String text;

    public Review(String authorEmail, String authorName, int points, String text) {
        this.points = points;
        this.text = text;
        this.authorEmail = authorEmail;
        this.authorName = authorName;
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

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Review review = (Review) o;
        return points == review.points;
    }

    @Override
    public int hashCode() {
        return points;
    }
}
