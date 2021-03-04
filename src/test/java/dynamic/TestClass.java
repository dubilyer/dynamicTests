package dynamic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dynamic.model.ParameterizedStep;
import dynamic.model.Step;
import dynamic.model.TestCase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static dynamic.StepProcessor.steps;
import static dynamic.service.FakeApiService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestClass {

    private final Logger logger = LoggerFactory.getLogger(TestClass.class);
    private final ObjectMapper om = new ObjectMapper();

    private TestCase prepareSteps() throws JsonProcessingException {
        final ParameterizedStep step1 = om.readValue(GO_TO_EBAY_URL, ParameterizedStep.class);
        final ParameterizedStep step2 = om.readValue(SEND_GET, ParameterizedStep.class);
        final ParameterizedStep step3 = om.readValue(RUN_DB_QUERY, ParameterizedStep.class);
        TestCase tc = new TestCase();
        tc.params.put("param1", "value1");
        Step step4 = () -> {
            logger.info(() -> "Running step4");
            assertEquals("value1", tc.params.get("param1"));
        };
        tc.steps = new Executable[]{step1, step2, step3, step4};
        return tc;
    }

    private TestCase prepareSteps2() throws JsonProcessingException {
        TestCase tc = new TestCase();
        tc.steps = om.readValue(TEST_CASE, ParameterizedStep[].class);
        return tc;
    }

    @TestFactory
    Collection<DynamicTest> parameterized() throws JsonProcessingException {
        TestCase tc = prepareSteps();
        TestCase tc2 = prepareSteps2();
        return Arrays.asList(
                dynamicTest("Steps", steps(tc)),
                dynamicTest("TC", steps(tc2))
        );
    }
}
