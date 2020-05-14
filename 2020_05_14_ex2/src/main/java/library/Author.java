package library;

import java.util.Objects;

public class Author {
    private String firstName;
    private String lastName;

    public Author() {
        this.firstName = "Лев";
        this.lastName = "Толстой";
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Author author = (Author) obj;
        return (Objects.equals(this.firstName, author.firstName)
                && Objects.equals(this.lastName, author.lastName));
    }
}
