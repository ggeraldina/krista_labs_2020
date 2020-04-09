package library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // пример JSON строки
        printLibraryJSON();

        // пример XML строки
        printLibraryXML();

        // пример YAML строки
        printLibraryYAML();

        // сравнение ArrayList
        // Вывод: результат сравнения зависит от порядка в массиве:
        // a, b != b, a
        checkEquals();
    }

    private static void printLibraryJSON() {
        Library library = new Library();
        // Красивый вывод JSON
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println(gson.toJson(library));
        // Вывод в одну строку JSON
        Gson gson2 = new Gson();
        System.out.println(gson2.toJson(library));
    }

    private static void printLibraryYAML() throws IOException {
        Library library = new Library();
        YAMLMapper yamlMapper = new YAMLMapper();
        // Сделать видимыми приватные поля
        yamlMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        System.out.println(yamlMapper.writeValueAsString(library));
    }

    private static void printLibraryXML() throws IOException {
        Library library = new Library();
        XmlMapper xmlMapper = new XmlMapper();
        // Красивый вывод
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // Сделать видимыми приватные поля
        xmlMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        System.out.println(xmlMapper.writeValueAsString(library));
    }

    private static void checkEquals() {
        Author ilf = new Author("Илья", "Ильф");
        Author petrov = new Author("Евгений", "Петров");
        ArrayList<Author> list1 = new ArrayList<Author>();
        list1.add(ilf);
        list1.add(petrov);
        ArrayList<Author> list2 = new ArrayList<Author>();
        list2.add(petrov);
        list2.add(ilf);
        System.out.println(Objects.equals(list1, list2));
    }
}


