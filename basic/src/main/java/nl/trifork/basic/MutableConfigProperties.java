package nl.trifork.basic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mutable-config")
public class MutableConfigProperties {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
