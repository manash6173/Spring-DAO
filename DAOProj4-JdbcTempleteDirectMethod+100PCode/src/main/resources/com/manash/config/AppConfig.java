package com.manash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {BusinessConfig.class,PresentationConfig.class})
public class AppConfig {

}
