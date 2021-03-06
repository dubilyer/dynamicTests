package dynamic.infra;

import dynamic.model.InfraStepFactory;
import org.junit.platform.commons.logging.Logger;

import java.util.Map;

import static java.lang.String.format;
import static org.junit.platform.commons.logging.LoggerFactory.getLogger;

public class DBClient {

    public static final Logger LOGGER = getLogger(InfraStepFactory.class);

    public static void selectFromDb(Map<String, String> parameters) {
        LOGGER.info(() -> format("Running DB Query %s", parameters.get("Query")));
    }
}
