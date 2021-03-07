package dynamic.infra;

import dynamic.model.InfraStepFactory;

import java.util.Map;

import static org.junit.platform.commons.logging.LoggerFactory.getLogger;

public class WebClient {
    public static final org.junit.platform.commons.logging.Logger LOGGER = getLogger(InfraStepFactory.class);

    public static void goToUrl(Map<String, String> parameters) {
        LOGGER.info(() -> String.format("Navigating to url %s", parameters.get("Url")));
        LOGGER.info(() -> String.format("Navigating to url %s", parameters.get("global.key1")));
    }
}

