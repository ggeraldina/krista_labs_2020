package serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;

public class YamlSerializer {
    private YAMLMapper yamlMapper;

    public YamlSerializer() {
        yamlMapper = new YAMLMapper();
        yamlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public String serialized(Object obj) throws IOException {
        return yamlMapper.writeValueAsString(obj);
    }

    public Object deserialized(String yaml, Class deserializeClass) throws IOException {
        return yamlMapper.readValue(yaml, deserializeClass);
    }
}
