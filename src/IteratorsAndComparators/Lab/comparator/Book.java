package IteratorsAndComparators.Lab.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    String title;
    int year;
    List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        if (authors.length == 0){
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }


    @Override
    public int compareTo(Book o) {
        if (this.title.compareTo(o.getTitle()) > 0) return 1;
        else if (this.title.compareTo(o.getTitle()) < 0) return -1;
        else {
            if (this.year > o.getYear()) return 1;
            else if (this.year < o.getYear()) return -1;
            else return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.getTitle(), this.getYear());
    }
}
