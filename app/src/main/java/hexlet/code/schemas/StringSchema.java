package hexlet.code.schemas;


import static java.util.Objects.isNull;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        addCheck("required", value -> !isNull(value)  && !value.isEmpty());
        return this;
    }
    public StringSchema minLength(int length) {
        addCheck("minLength", value -> length <= value.length());
        return this;
    }
    public StringSchema contains(String string) {
        addCheck("contains", value -> value.contains(string));
        return this;
    }
}
