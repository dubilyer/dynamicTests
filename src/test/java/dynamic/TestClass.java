package dynamic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dynamic.model.ParameterizedStep;
import dynamic.model.TestCase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static dynamic.StepProcessor.steps;
import static dynamic.service.FakeApiService.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestClass {

    private final Logger logger = LoggerFactory.getLogger(TestClass.class);
    private final ObjectMapper om = new ObjectMapper();

    private TestCase prepareSteps() throws JsonProcessingException {
        return new TestCase(new ParameterizedStep[]{serialize(GO_TO_EBAY_URL), serialize(SEND_GET), serialize(RUN_DB_QUERY)});
    }

    private TestCase prepareSteps2() throws JsonProcessingException {
        return serializeSteps(STEP_ARRAY);
    }

    private TestCase prepareTestCase() throws JsonProcessingException {
        return serializeTC(TC);
    }

    @TestFactory
    Collection<DynamicTest> parameterized() throws JsonProcessingException {
        TestCase tc = prepareSteps();
        TestCase tc2 = prepareSteps2();
        return Arrays.asList(
                dynamicTest("Steps", steps(tc)),
                dynamicTest("TC", steps(tc2)),
                dynamicTest("TC2", steps(
                        prepareTestCase())
                )
        );
    }
}
