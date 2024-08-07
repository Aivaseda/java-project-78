package hexlet.code.schemas;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

public class StringSchema {
    private Predicate<String> requiredPredicate;
    private Predicate<String> minLengthPredicate;
    private Predicate<String> containsPredicate;
    private String subString;

    public StringSchema required() {
        requiredPredicate = value -> !isNull(value) && !value.isEmpty();
        return this;
    }
    public StringSchema minLength(int length) {
        minLengthPredicate = value -> value.length() >= length;
        return this;
    }
    public StringSchema contains(String string){
        subString = string;
        containsPredicate = value -> value.contains(subString);
        return this;
    }

    public boolean isValid(String value) {
        List<Boolean> statusList = new ArrayList<>();

        if (minLengthPredicate != null) {
            statusList.add(minLengthPredicate.test(value));
        }
        if (subString != null) {
            statusList.add(containsPredicate.test(value));
        }


        if (requiredPredicate == null) {
            statusList.add(true);
        }else {
            statusList.add(requiredPredicate.test(value));
        }
        return !statusList.contains(false);
    }
}
