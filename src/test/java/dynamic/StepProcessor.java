package dynamic;

import org.junit.jupiter.api.function.Executable;

public class StepProcessor {
    private StepProcessor() {
    }

    static Executable combineSteps(Executable[] executables){
        return () -> {
            for (Executable executable : executables) {
                executable.execute();
            }
        };
    }
}
