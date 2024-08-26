package capitalgain.adapters.response;

import capitalgain.domain.entities.Tax;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxResponse {
    @JsonProperty("value")
    private Double value;

    @JsonProperty("error")
    private String message;


    public TaxResponse(double value) {
        this.value = value;
        this.message = null;
    }

    public TaxResponse(String message) {
        this.message = message;
        this.value = null;
    }

    public static TaxResponse toResponse(Tax tax) {
        if(Objects.isNull(tax.getValue()))
        {
            return new TaxResponse(tax.getMessage());
        }

        return new TaxResponse(tax.getValue());
    }
}