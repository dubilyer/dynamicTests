package dynamic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dynamic.model.ParameterizedStep;
import dynamic.model.TestCase;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static java.lang.String.format;

public class FakeApiService {
    static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(FakeApiService.class);

    private FakeApiService() {
    }

    public static final String GO_TO_EBAY_URL = "{\"step\" : \"GO_TO_URL\", \"parameters\": {\"Url\":\"www.ebay.com\"}}";
    public static final String SEND_GET = "{\"step\" : \"SEND_GET\", \"parameters\": {\"Url\":\"www.ebay.com/api\", \"Headers\": \"Auth:blabla, repeat:true\"}}";
    public static final String RUN_DB_QUERY = "{\"step\" : \"RUN_DB_QUERY\", \"parameters\": {\"Query\":\"SELECT * FROM USERS WHERE ID = t1\"}}";
    public static final String STEP_ARRAY = format("[%s, %s, %s]", GO_TO_EBAY_URL, SEND_GET, RUN_DB_QUERY);
    public static final String TC = format("{\"globalParams\": {\"key1\": \"value1\"}, \"steps\": [%s, %s, %s]}", GO_TO_EBAY_URL, SEND_GET, RUN_DB_QUERY);

    public static ParameterizedStep serialize(String json) throws JsonProcessingException {
        ParameterizedStep parameterizedStep = objectMapper.readValue(json, ParameterizedStep.class);
        logger.info(() -> {
            try {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parameterizedStep);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return parameterizedStep;
    }

    public static TestCase serializeSteps(String json) throws JsonProcessingException {
        ParameterizedStep[] parameterizedSteps = objectMapper.readValue(json, ParameterizedStep[].class);
        logger.info(() -> {
            try {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parameterizedSteps);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return new TestCase(parameterizedSteps);
    }

    public static TestCase serializeTC(String json) throws JsonProcessingException {
        TestCase testCase = objectMapper.readValue(json, TestCase.class);
        logger.info(() -> {
            try {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testCase);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return testCase;
    }
}
