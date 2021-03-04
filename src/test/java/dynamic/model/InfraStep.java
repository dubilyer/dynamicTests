package dynamic.model;

import dynamic.infra.DBClient;
import dynamic.infra.RestClient;
import dynamic.infra.WebClient;
import org.junit.platform.commons.logging.Logger;

import java.util.Map;
import java.util.function.Function;

import static org.junit.platform.commons.logging.LoggerFactory.*;

public enum InfraStep {
    GO_TO_URL(parameters -> () -> WebClient.goToUrl(parameters)), //call to infra method instead
    RUN_DB_QUERY(parameters -> () -> DBClient.selectFromDb(parameters)),
    SEND_GET(parameters -> () -> RestClient.get(parameters));

    private static final Logger logger = getLogger(InfraStep.class);
    Function<Map<String, String>, Step> parameterizedStepFunction;

    InfraStep(Function<Map<String, String>, Step> step) {
        this.parameterizedStepFunction = step;
    }

    public Step get(Map<String, String> parameters){
        return parameterizedStepFunction.apply(parameters);
    }
}
