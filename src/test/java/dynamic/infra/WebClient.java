package dynamic.infra;

import dynamic.model.InfraStep;

import java.util.Map;

import static org.junit.platform.commons.logging.LoggerFactory.getLogger;

public class WebClient {
    public static final org.junit.platform.commons.logging.Logger LOGGER = getLogger(InfraStep.class);

    public static void goToUrl(Map<String, String> parameters) {
        LOGGER.info(() -> String.format("Navigating to url %s", parameters.get("Url")));
    }
}

