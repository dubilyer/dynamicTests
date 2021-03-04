package dynamic.model;

import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;
import java.util.Map;

public class TestCase {
    private Map<String, String> params = new HashMap<>();
    private Executable[] steps;

    public TestCase(Executable[] steps) {
        this.steps = steps;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Executable[] getSteps() {
        return steps;
    }
}
