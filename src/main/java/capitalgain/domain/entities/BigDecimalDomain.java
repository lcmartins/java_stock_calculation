package capitalgain.domain.entities;

import java.math.BigDecimal;

public class BigDecimalDomain {
    private BigDecimal wrappedValue;

    public BigDecimalDomain(BigDecimal wrappedValue) {
        this.wrappedValue = wrappedValue;
    }

    public boolean isBiggerThan(BigDecimalDomain other) {
        return this.wrappedValue.compareTo(other.wrappedValue) > 0;
    }

    public boolean isSmallerThan(BigDecimalDomain other) {
        return this.wrappedValue.compareTo(other.wrappedValue) < 0;
    }

    public boolean isEqualTo(BigDecimalDomain other) {
        return this.wrappedValue.compareTo(other.wrappedValue) == 0;
    }

    public BigDecimal value() {
        return wrappedValue;
    }
}
