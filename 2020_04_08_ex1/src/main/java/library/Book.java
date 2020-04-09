package library;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private ArrayList<Author> authors;
    private PublishingCompany publishingCompany;
    private String title;

    Book() {
        this.authors = new ArrayList<Author>();
        this.publishingCompany = new PublishingCompany();
        this.title = "Война и мир";
    }

    Book(String title) {
        this();
        this.title = title;
    }

    Book(String title, ArrayList<Author> authors) {
        this(title);
        this.authors = authors;
    }

    Book(String title, ArrayList<Author> authors, PublishingCompany publishingCompany) {
        this(title, authors);
        this.publishingCompany = publishingCompany;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return (Objects.equals(this.title, book.title)
                && Objects.equals(this.publishingCompany, book.publishingCompany)
                && Objects.equals(this.authors, book.authors));
    }
}
