package library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;

public class LibraryTest {

    // simple structure author JSON
    @Test
    void serialization_author_objectToJSON_objectFromJSON() {
        Author author = new Author();
        Gson gson = new Gson();
        String json = gson.toJson(author);
        Author author2 = gson.fromJson(json, Author.class);

        assertEquals(author, author2);
    }

    @Test
    void deserialization_author_objectFromJSON_objectToJSON() {
        String json = "{\"firstName\":\"Иван\",\"lastName\":\"Тургенев\"}";
        Gson gson = new Gson();
        Author author = gson.fromJson(json, Author.class);
        String json2 = gson.toJson(author);

        assertEquals(json, json2);
    }

    // complex structure library JSON XML YAML
    @Test
    void serialization_library_objectToJSON_objectFromJSON() {
        Library library = new Library();
        Gson gson = new Gson();
        String json = gson.toJson(library);
        Library library2 = gson.fromJson(json, Library.class);

        assertEquals(library, library2);
    }

    @Test
    void deserialization_library_objectFromJSON_objectToJSON() {
        String json = "{\"sectionA\":[{\"authors\":[{\"firstName\":\"Николай\",\"lastName\":\"Гоголь\"}]," +
                "\"publishingCompany\":{\"name\":\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"}," +
                "\"title\":\"Мертвые души\"},{\"authors\":[{\"firstName\":\"Николай\",\"lastName\":\"Гоголь\"}]," +
                "\"publishingCompany\":{\"name\":\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"}," +
                "\"title\":\"Вий\"},{\"authors\":[{\"firstName\":\"Николай\",\"lastName\":\"Гоголь\"}]," +
                "\"publishingCompany\":{\"name\":\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"}," +
                "\"title\":\"Ревизор\"},{\"authors\":[{\"firstName\":\"Лев\",\"lastName\":\"Толстой\"}]," +
                "\"publishingCompany\":{\"name\":\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"}," +
                "\"title\":\"Война и мир\"},{\"authors\":[{\"firstName\":\"Лев\",\"lastName\":\"Толстой\"}]," +
                "\"publishingCompany\":{\"name\":\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"}," +
                "\"title\":\"Анна Каренина\"}],\"sectionB\":[{\"authors\":[{\"firstName\":\"Илья\"," +
                "\"lastName\":\"Ильф\"},{\"firstName\":\"Евгений\",\"lastName\":\"Петров\"}]," +
                "\"publishingCompany\":{\"name\":\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"}," +
                "\"title\":\"Золотой теленок\"},{\"authors\":[{\"firstName\":\"Илья\",\"lastName\":\"Ильф\"}," +
                "{\"firstName\":\"Евгений\",\"lastName\":\"Петров\"}],\"publishingCompany\":{\"name\":" +
                "\"Супер-пупер-мега-вау издательство\",\"city\":\"Ярославль\"},\"title\":\"Двенадцать стульев\"}]}";
        Gson gson = new Gson();
        Library library = gson.fromJson(json, Library.class);
        String json2 = gson.toJson(library);

        assertEquals(json, json2);
    }


    @Test
    void serialization_library_objectToXML_objectFromXML() throws IOException {
        Library library = new Library();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String xml = xmlMapper.writeValueAsString(library);
        Library library2 = xmlMapper.readValue(xml, Library.class);

        assertEquals(library, library2);
    }


    @Test
    void deserialization_library_objectFromXML_objectToXML() throws IOException {
        String xml = "<Library><sectionA><sectionA><authors><authors><firstName>Николай</firstName>" +
                "<lastName>Гоголь</lastName></authors></authors><publishingCompany>" +
                "<name>Супер-пупер-мега-вау издательство</name><city>Ярославль</city>" +
                "</publishingCompany><title>Мертвые души</title></sectionA><sectionA>" +
                "<authors><authors><firstName>Николай</firstName><lastName>Гоголь</lastName>" +
                "</authors></authors><publishingCompany><name>Супер-пупер-мега-вау издательство</name>" +
                "<city>Ярославль</city></publishingCompany><title>Вий</title></sectionA>" +
                "<sectionA><authors><authors><firstName>Николай</firstName><lastName>Гоголь</lastName>" +
                "</authors></authors><publishingCompany><name>Супер-пупер-мега-вау издательство</name>" +
                "<city>Ярославль</city></publishingCompany><title>Ревизор</title></sectionA>" +
                "<sectionA><authors><authors><firstName>Лев</firstName><lastName>Толстой</lastName>" +
                "</authors></authors><publishingCompany><name>Супер-пупер-мега-вау издательство</name>" +
                "<city>Ярославль</city></publishingCompany><title>Война и мир</title></sectionA><sectionA>" +
                "<authors><authors><firstName>Лев</firstName><lastName>Толстой</lastName></authors>" +
                "</authors><publishingCompany><name>Супер-пупер-мега-вау издательство</name>" +
                "<city>Ярославль</city></publishingCompany><title>Анна Каренина</title></sectionA>" +
                "</sectionA><sectionB><sectionB><authors><authors><firstName>Илья</firstName>" +
                "<lastName>Ильф</lastName></authors><authors><firstName>Евгений</firstName>" +
                "<lastName>Петров</lastName></authors></authors><publishingCompany>" +
                "<name>Супер-пупер-мега-вау издательство</name><city>Ярославль</city>" +
                "</publishingCompany><title>Золотой теленок</title></sectionB><sectionB>" +
                "<authors><authors><firstName>Илья</firstName><lastName>Ильф</lastName>" +
                "</authors><authors><firstName>Евгений</firstName><lastName>Петров</lastName>" +
                "</authors></authors><publishingCompany><name>Супер-пупер-мега-вау издательство</name>" +
                "<city>Ярославль</city></publishingCompany><title>Двенадцать стульев</title>" +
                "</sectionB></sectionB></Library>";
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Library library = xmlMapper.readValue(xml, Library.class);
        String xml2 = xmlMapper.writeValueAsString(library);

        assertEquals(xml, xml2);
    }

    @Test
    void serialization_library_objectToYAML_objectFromYAML() throws IOException {
        Library library = new Library();
        YAMLMapper yamlMapper = new YAMLMapper();
        yamlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String yaml = yamlMapper.writeValueAsString(library);
        Library library2 = yamlMapper.readValue(yaml, Library.class);

        assertEquals(library, library2);
    }

    @Test
    void deserialization_library_objectFromYAML_objectToYAML() throws IOException {
        String yaml = "---\n" +
                "sectionA:\n" +
                "- authors:\n" +
                "  - firstName: \"Николай\"\n" +
                "    lastName: \"Гоголь\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Мертвые души\"\n" +
                "- authors:\n" +
                "  - firstName: \"Николай\"\n" +
                "    lastName: \"Гоголь\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Вий\"\n" +
                "- authors:\n" +
                "  - firstName: \"Николай\"\n" +
                "    lastName: \"Гоголь\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Ревизор\"\n" +
                "- authors:\n" +
                "  - firstName: \"Лев\"\n" +
                "    lastName: \"Толстой\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Война и мир\"\n" +
                "- authors:\n" +
                "  - firstName: \"Лев\"\n" +
                "    lastName: \"Толстой\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Анна Каренина\"\n" +
                "sectionB:\n" +
                "- authors:\n" +
                "  - firstName: \"Илья\"\n" +
                "    lastName: \"Ильф\"\n" +
                "  - firstName: \"Евгений\"\n" +
                "    lastName: \"Петров\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Золотой теленок\"\n" +
                "- authors:\n" +
                "  - firstName: \"Илья\"\n" +
                "    lastName: \"Ильф\"\n" +
                "  - firstName: \"Евгений\"\n" +
                "    lastName: \"Петров\"\n" +
                "  publishingCompany:\n" +
                "    name: \"Супер-пупер-мега-вау издательство\"\n" +
                "    city: \"Ярославль\"\n" +
                "  title: \"Двенадцать стульев\"\n";
        YAMLMapper yamlMapper = new YAMLMapper();
        yamlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Library library = yamlMapper.readValue(yaml, Library.class);
        String yaml2 = yamlMapper.writeValueAsString(library);

        assertEquals(yaml, yaml2);
    }
}
