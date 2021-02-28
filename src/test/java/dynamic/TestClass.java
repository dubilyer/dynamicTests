package dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;
import java.util.Collection;

import static dynamic.StepProcessor.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestClass {

    Step step =  ()->  System.out.println("a");
    Step step1 = ()-> System.out.println("b");
    Step step2 = ()-> System.out.println("c");

    Executable getExecutable (){
        return step.andThen(step1).andThen(step2);
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
                dynamicTest("testArray", combineSteps(step, step1, step2)),
                dynamicTest("testArray2", combineSteps(step2, step1, step2, step))
        );
    }
}
