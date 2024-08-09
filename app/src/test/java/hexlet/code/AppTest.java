package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class AppTest {
    @Test
    public void stringTest() {
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

    @Test
    public void numberTest() {
        var v = new Validator();
        var schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        schema.positive();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(3)).isFalse();
    }
}
