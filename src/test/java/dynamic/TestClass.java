package dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static dynamic.StepProcessor.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestClass {

    private final Logger logger = LoggerFactory.getLogger(TestClass.class);

    Step step1 = ()-> logger.info(()-> "running step1");
    Step step2 = ()-> logger.info(()-> "running step2");
    Step step3 = ()-> logger.info(()-> "running step3");

    Executable getExecutable (){
        return step1.andThen(step2).andThen(step3);
    }

    @TestFactory
    Collection<DynamicTest> testSomething(){
        return Arrays.asList(
                dynamicTest("test a", getExecutable()),
                dynamicTest("test a", ()-> assertEquals("a", "b"))
        );
    }

    @TestFactory
    Collection<DynamicTest> testArray(){
        return Arrays.asList(
                dynamicTest("testArray", combineSteps(step1, step2, step3)),
                dynamicTest("testArray2", combineSteps(step3, step2, step3, step1))
        );
    }
}
