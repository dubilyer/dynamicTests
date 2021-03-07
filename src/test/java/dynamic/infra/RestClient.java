package dynamic.infra;

import dynamic.model.InfraStepFactory;
import org.junit.platform.commons.logging.Logger;

import java.util.Map;

import static java.lang.String.format;
import static org.junit.platform.commons.logging.LoggerFactory.getLogger;

public class RestClient {

    public static final Logger LOGGER = getLogger(InfraStepFactory.class);

    public static void get(Map<String, String> parameters) {
        LOGGER.info(() -> format("sending Get request\nUrl: %s\nHeaders: %s", parameters.get("Url"), parameters.get("Headers")));

    }
}
