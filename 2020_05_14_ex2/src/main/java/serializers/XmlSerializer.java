package serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XmlSerializer {
    private XmlMapper xmlMapper;

    public XmlSerializer() {
        xmlMapper = new XmlMapper();
        xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public String serialized(Object obj) throws IOException {
        return xmlMapper.writeValueAsString(obj);
    }

    public Object deserialized(String xml, Class deserializeClass) throws IOException  {
        return xmlMapper.readValue(xml, deserializeClass);
    }
}
