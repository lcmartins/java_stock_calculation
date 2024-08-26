package capitalgain.adapters.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxResponseJSON {
    @JsonProperty("value")
    private double value;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TaxResponseJSON(@JsonProperty("value") String value) {
        this.value = Double.valueOf(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("value: ").append(value);
        sb.append('}');
        return sb.toString();
    }
}
