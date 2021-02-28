package dynamic;

import org.junit.jupiter.api.function.Executable;

import java.util.Objects;

public interface Step extends Executable {
    default Step andThen(Executable after) {
        Objects.requireNonNull(after);
        return () -> { execute(); after.execute(); };
    }
}
