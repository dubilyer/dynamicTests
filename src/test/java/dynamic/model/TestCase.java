package dynamic.model;

import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;
import java.util.Map;

public class TestCase {
    public Map<String, String> params = new HashMap<>();
    public Executable[] steps;
}
