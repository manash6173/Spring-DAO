package com.manash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {PersistenceBeansConfig.class,ServiceBeansConfig.class})
public class AppConfig {

}
