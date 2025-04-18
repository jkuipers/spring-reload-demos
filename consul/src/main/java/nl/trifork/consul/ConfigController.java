package nl.trifork.consul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RefreshScope
@Controller
public class ConfigController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${basic-key}")
    private String basicKey;

    private MutableConfigProperties mutableConfig;
    private ImmutableConfigProperties immutableConfig;

    private AtomicInteger counter = new AtomicInteger(0);

    public ConfigController(MutableConfigProperties mutableConfig, ImmutableConfigProperties immutableConfig) {
        this.mutableConfig = mutableConfig;
        this.immutableConfig = immutableConfig;
    }

    @GetMapping("/")
    String index(Model model) {
        logger.debug("Handling config request");

        var properties = new LinkedHashMap<String, String>();
        properties.put("basic-key", basicKey);
        properties.put("mutable-config.key", mutableConfig.getKey());
        properties.put("mutable-config.number", Integer.toString(mutableConfig.getNumber()));
        properties.put("immutable-config.key", immutableConfig.key());

        model.addAttribute("properties", properties);
        model.addAttribute("counter", counter.incrementAndGet());
        return "index";
    }
}
