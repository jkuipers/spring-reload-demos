package nl.trifork.basic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("immutable-config")
public class ImmutableConfigProperties {
    private final String key;

    public ImmutableConfigProperties(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
