package hexlet.code.schemas;



import java.util.function.Predicate;

import static java.awt.SystemColor.text;
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
        boolean switcher = true;
        if (requiredPredicate == null /* || value.equals("") && requiredPredicate == null */) {
            switcher = true;
        }else if (requiredPredicate != null /*|| value.equals("") && requiredPredicate != null8*/) {
            return requiredPredicate.test(value);
        }
        if (minLengthPredicate != null) {
            switcher = minLengthPredicate.test(value);
        }

        if (containsPredicate != null) {
            switcher = containsPredicate.test(value);
        }
        return switcher;
    }
}



//private String data;
//private int length;
//private String subString;
//
//
//
//public boolean required(){
//    return
//}
//public boolean minLength(int length){
//    return value -> length <= value.length()ж
//}
//public boolean contains(String subString){
//    this.subString = subString;
//}
//
//public boolean isValid(String o) {
//    return false;
//}