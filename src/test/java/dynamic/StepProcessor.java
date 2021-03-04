package dynamic;

import dynamic.model.TestCase;
import org.junit.jupiter.api.function.Executable;

public class StepProcessor {
    private StepProcessor() {
    }

    static Executable steps(Executable... executables){
        return () -> {
            for (Executable executable : executables) {
                executable.execute();
            }
        };
    }

    static Executable steps(TestCase tc){
        return steps(tc.steps);
    }
}
