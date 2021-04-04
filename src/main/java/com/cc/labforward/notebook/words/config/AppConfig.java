package com.cc.labforward.notebook.words.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties("app")
public class AppConfig {

    private int maxLengthForSimilarity;

    private String invalidPayload;
}
