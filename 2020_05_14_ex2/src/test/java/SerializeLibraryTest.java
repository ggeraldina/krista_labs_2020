import library.Library;
import serializers.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeLibraryTest {
    @Test
    void serialization_library_objectToJSON_objectFromJSON() {
        Library library = new Library();
        library.fillLibrary();

        JsonSerializer jsonSerializer = new JsonSerializer();
        String json = jsonSerializer.serialized(library);
        Library library2 = (Library) jsonSerializer.deserialized(json, Library.class);

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

        JsonSerializer jsonSerializer = new JsonSerializer();
        Library library = (Library) jsonSerializer.deserialized(json, Library.class);
        String json2 = jsonSerializer.serialized(library);

        assertEquals(json, json2);
    }


    @Test
    void serialization_library_objectToXML_objectFromXML() throws IOException {
        Library library = new Library();
        library.fillLibrary();

        XmlSerializer xmlSerializer = new XmlSerializer();
        String xml = xmlSerializer.serialized(library);
        Library library2 = (Library) xmlSerializer.deserialized(xml, Library.class);

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

        XmlSerializer xmlSerializer = new XmlSerializer();
        Library library = (Library) xmlSerializer.deserialized(xml, Library.class);
        String xml2 = xmlSerializer.serialized(library);

        assertEquals(xml, xml2);
    }

    @Test
    void serialization_library_objectToYAML_objectFromYAML() throws IOException {
        Library library = new Library();
        library.fillLibrary();

        YamlSerializer yamlSerializer = new YamlSerializer();
        String yaml = yamlSerializer.serialized(library);
        Library library2 = (Library) yamlSerializer.deserialized(yaml, Library.class);

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

        YamlSerializer yamlSerializer = new YamlSerializer();
        Library library = (Library) yamlSerializer.deserialized(yaml, Library.class);
        String yaml2 = yamlSerializer.serialized(library);

        assertEquals(yaml, yaml2);
    }
}
