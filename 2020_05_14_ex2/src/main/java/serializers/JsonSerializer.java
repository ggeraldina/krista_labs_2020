package serializers;

import com.google.gson.Gson;

public class JsonSerializer {
    private Gson gson;

    public JsonSerializer() {
        gson = new Gson();
    }

    public String serialized(Object obj) {
        return gson.toJson(obj);
    }

    public Object deserialized(String json, Class deserializeClass) {
        return gson.fromJson(json, deserializeClass);
    }
}
