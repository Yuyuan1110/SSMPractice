package org.practice.spring.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
public class ProptertiesConfig {
}
