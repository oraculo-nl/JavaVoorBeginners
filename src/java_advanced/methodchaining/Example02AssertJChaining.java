package java_advanced.methodchaining;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Example02AssertJChaining {


    @Test
    void testStringProperties() {
        String message = "Hello World";

        assertThat(message)
                .isNotNull()
                .startsWith("Hello")
                .endsWith("World")
                .hasSize(11)
                .contains("lo Wo");
    }
}

