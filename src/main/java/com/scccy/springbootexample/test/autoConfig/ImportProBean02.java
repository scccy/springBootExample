package com.scccy.springbootexample.test.autoConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@Data
@ConfigurationProperties("usershici")
public class ImportProBean02 {

    private Integer id;
    private String name;
    private Integer age;

}
