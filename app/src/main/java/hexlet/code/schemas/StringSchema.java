package hexlet.code.schemas;


public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        addCheck("required", value -> value != null && !value.isEmpty());
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
