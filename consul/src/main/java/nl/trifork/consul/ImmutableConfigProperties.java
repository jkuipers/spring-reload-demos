package nl.trifork.consul;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@ConfigurationProperties("immutable-config")
public class ImmutableConfigProperties {
    private final String key;

    public ImmutableConfigProperties(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

}
