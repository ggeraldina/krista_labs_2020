package library;

import java.util.Objects;

public class PublishingCompany {
    private String name;
    private String city;

    public PublishingCompany() {
        this.name = "Супер-пупер-мега-вау издательство";
        this.city = "Ярославль";
    }

    public PublishingCompany(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PublishingCompany publishingCompany = (PublishingCompany) obj;
        return (Objects.equals(this.name, publishingCompany.name)
                && Objects.equals(this.city, publishingCompany.city));
    }
}
