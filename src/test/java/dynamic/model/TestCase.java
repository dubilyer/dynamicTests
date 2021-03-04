package dynamic.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

public class TestCase {
    private Map<String, String> globalParams = new HashMap<>();
    private ParameterizedStep[] steps;

    public TestCase() {
    }

    public TestCase(ParameterizedStep[] steps) {
        this.steps = steps;
    }

    @JsonCreator
    public TestCase(@JsonProperty("globalParams") Map<String, String> globalParams, @JsonProperty("steps")ParameterizedStep[] steps) {
        this.globalParams = globalParams;
        this.steps = steps;
        stream(this.steps)
                .forEach(parameterizedStep -> globalParams
                        .forEach((gpKey, gpValue) -> parameterizedStep.parameters.put("global." + gpKey, gpValue)
                        )
                );
    }

    public Map<String, String> getGlobalParams() {
        return globalParams;
    }

    public ParameterizedStep[] getSteps() {
        return steps;
    }

}
