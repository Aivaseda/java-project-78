package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void mapSchema() {
        var v = new Validator();
        var schema = v.map();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.required().isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
        schema.sizeof(2);
        assertThat(schema.isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
    }
    @Test
    public void testShape() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "John");
        human3.put("lastName", "B");
        assertThat(schema.isValid(human3)).isFalse();
    }
}
