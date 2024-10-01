package IteratorsAndComparators.Lab.library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book> {
    Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }
    @Override
    public void forEach(Consumer action) {
        for (int i = 0; i < this.books.length; i++) {
            action.accept(books[i]);
        }
    }

    private final class LibraryIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length && books[counter] != null;
        }

        @Override
        public Book next() {
             return books[counter++];
        }
    }


}
