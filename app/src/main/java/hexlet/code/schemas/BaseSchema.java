package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> checks;

    protected BaseSchema() {
        checks = new HashMap<>();
    }

    protected final void addCheck(String name, Predicate<T> predicate) {
        checks.put(name, predicate);
    }

    public final boolean isValid(T value) {
        return checks.values().stream().allMatch(check -> check.test(value));
    }
}
