package java_advanced.topic01methodchaining;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Example02AssertJChainingTest {

    @Test
    void testStringProperties() {

        Example02AssertJChaining example = new Example02AssertJChaining();


        assertThat(example.sayHello())
                .isNotNull()
                .startsWith("Hello")
                .endsWith("World!")
                .hasSize(12)
                .contains("lo Wo");
    }
}