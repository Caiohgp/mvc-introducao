package br.com.caiohenriquedev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.caiohenriquedev")
@EnableWebMvc
public class RootConfig {

}
