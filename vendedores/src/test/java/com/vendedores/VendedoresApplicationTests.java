package com.vendedores;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = VendedoresApplication.class)
@ActiveProfiles("test")
class VendedoresApplicationTests {

    @Test
    void contextLoads() {
    }
}