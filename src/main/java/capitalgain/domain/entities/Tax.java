package capitalgain.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class Tax {

    private Double value = 0.0;


    private String message;

    public Tax(Double value) {
        this.value = value;
        this.message = null;
    }

    public Tax(String message) {
        this.message = message;
        this.value = null;
    }

    public Tax(){
        super();
    }

    public Double getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
