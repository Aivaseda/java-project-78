package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class AppTest {
    @Test
    public void firstTest() {
        var v = new Validator();
        var schema = v.string();
        schema.required();
        //assertThat(schema.isValid("")).isTrue();
//        assertThat(schema.minLength(4).contains("wh3453453").isValid("what does the fox say")).isTrue();
        assertThat(schema.minLength(4).isValid("")).isFalse();
    }
}
