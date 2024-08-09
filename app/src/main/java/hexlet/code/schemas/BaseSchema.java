package hexlet.code.schemas;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final Map<String, Predicate<T>> checks;

    public BaseSchema() {
        checks = new HashMap<>();
    }
    public void addCheck(String name, Predicate<T> predicate) {
        checks.put(name, predicate);
    }

    public boolean isValid(T value) {
        return checks.values().stream().allMatch(check -> check.test(value));
    }
}
