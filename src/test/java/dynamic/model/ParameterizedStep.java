package dynamic.model;

import org.junit.jupiter.api.function.Executable;

import java.util.Map;

public class ParameterizedStep implements Executable {
    InfraStepFactory step;

    Map<String, String> parameters;

    public ParameterizedStep(){};

    public ParameterizedStep(InfraStepFactory step, Map<String, String> parameters) {
        this.step = step;
        this.parameters = parameters;
    }

    public InfraStepFactory getStep() {
        return step;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setStep(InfraStepFactory step) {
        this.step = step;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() throws Throwable {
        step.parameterizedStepFunction.apply(parameters).execute();
    }
}
