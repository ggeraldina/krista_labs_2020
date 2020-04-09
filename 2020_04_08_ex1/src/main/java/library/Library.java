package library;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Book> sectionA;
    private ArrayList<Book> sectionB;

    Library() {
        this.sectionA = new ArrayList<Book>();
        this.sectionB = new ArrayList<Book>();
        fillLibrary();
    }

    Library(ArrayList<Book> sectionA, ArrayList<Book> sectionB) {
        this.sectionA = sectionA;
        this.sectionB = sectionB;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Library library = (Library) obj;
        return (Objects.equals(this.sectionA, library.sectionA)
                && Objects.equals(this.sectionB, library.sectionB));
    }

    private void fillLibrary() {
        fillGogol();
        fillTolstoi();
        fillIlfPetrov();
    }

    private void fillGogol() {
        // Гоголь
        Author gogol = new Author("Николай", "Гоголь");
        ArrayList<Author> listGogol = new ArrayList<Author>();
        listGogol.add(gogol);
        String titleGogol[] = { "Мертвые души", "Вий", "Ревизор" };
        for(int i = 0; i < titleGogol.length; i++) {
            Book book = new Book(titleGogol[i], listGogol);
            sectionA.add(book);
        }
    }

    private void fillTolstoi() {
        // Толстой
        Author tolstoi = new Author("Лев", "Толстой");
        ArrayList<Author> listTolstoi = new ArrayList<Author>();
        listTolstoi.add(tolstoi);
        String titleTolstoi[] = { "Война и мир", "Анна Каренина" };
        for(int i = 0; i < titleTolstoi.length; i++) {
            Book book = new Book(titleTolstoi[i], listTolstoi);
            sectionA.add(book);
        }
    }

    private void fillIlfPetrov() {
        Author ilf = new Author("Илья", "Ильф");
        Author petrov = new Author("Евгений", "Петров");
        ArrayList<Author> listIlfPetrov = new ArrayList<Author>();
        listIlfPetrov.add(ilf);
        listIlfPetrov.add(petrov);
        String titleIlfPetrov[] = { "Золотой теленок", "Двенадцать стульев" };
        for(int i = 0; i < titleIlfPetrov.length; i++) {
            Book book = new Book(titleIlfPetrov[i], listIlfPetrov);
            sectionB.add(book);
        }
    }
}
