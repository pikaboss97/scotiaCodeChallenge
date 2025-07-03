package com.example.codeChallenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void applicationStarts() {
        StudentApplication.main(new String[]{});
    }

    @Test
    void webFluxEnabled() {
        assertThat(applicationContext.containsBean("webHandler")).isTrue();
    }

    @Test
    void circuitBreakerAutoConfigurationExcluded() {
        assertThat(applicationContext.containsBean("circuitBreakerAutoConfiguration")).isFalse();
    }
}
