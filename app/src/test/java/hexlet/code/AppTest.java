package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class AppTest {
    @Test
    public void firstTest() {
        var v = new Validator();
        var schema = v.string();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("wh").isValid("whwhwhwhwhwhwh")).isTrue();
        assertThat(schema.contains("000000").isValid("what does the fox say")).isFalse();

        assertThat(schema.minLength(10).minLength(4).isValid("Hexlet")).isFalse();
        assertThat(schema.minLength(15).isValid("Hexlet")).isFalse();

        assertThat(schema.contains("ex").minLength(4).isValid("Hexlet")).isTrue();


    }
}
