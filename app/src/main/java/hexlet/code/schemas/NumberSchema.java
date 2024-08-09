package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }
    public NumberSchema positive() {
        addCheck("positive", value -> value == null || value > 0);
        return this;
    }
    public NumberSchema range(int minVolume, int maxVolume) {
        addCheck("range", value -> value >= minVolume && value <= maxVolume);
        return this;
    }
}
