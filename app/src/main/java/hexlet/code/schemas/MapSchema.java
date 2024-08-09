package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }
    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> value.size() == size);
        return this;
    }
}
