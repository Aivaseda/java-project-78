package hexlet.code;

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

public class main {
    public static void main(String[] args) {
        var v = new Validator();

        var schema = v.string();

//        assertThat(schema.isValid("")).isTrue();
//        assertThat(schema.isValid(null)).isTrue();
//        schema.required();
//        assertThat(schema.isValid("")).isFalse();
//        assertThat(schema.isValid(null)).isFalse();
//
//        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
//        assertThat(schema.contains("000000").isValid("what does the fox say")).isFalse();


        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
        schema.required();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
        System.out.println();

        System.out.println(schema.contains("wh").isValid("what does the fox say"));
        System.out.println(schema.contains("000000").isValid("what does the fox say"));
        System.out.println(schema.isValid("000000"));
        System.out.println(schema.contains("000000").isValid("what does the fox say"));

        System.out.println(schema.minLength(10).minLength(4).isValid("Hexlet")); //true


    }
}