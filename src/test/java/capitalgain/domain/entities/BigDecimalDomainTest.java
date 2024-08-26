package capitalgain.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalDomainTest {

    @Test
    void isBiggerThan() {
        var bigger = new BigDecimalDomain(new BigDecimal(1000));
        var smaller = new BigDecimalDomain(new BigDecimal(999.99));

        assertTrue(bigger.isBiggerThan(smaller));
    }

    @Test
    void isSmallerThan() {
        var bigger = new BigDecimalDomain(new BigDecimal(1000));
        var smaller = new BigDecimalDomain(new BigDecimal(999.99));

        assertTrue(smaller.isSmallerThan(bigger));
    }

    @Test
    void isEqualTo() {
        var firstEqual = new BigDecimalDomain(new BigDecimal(1000));
        var secondEqual = new BigDecimalDomain(new BigDecimal(1000));

        assertTrue(secondEqual.isEqualTo(firstEqual));
    }

    @Test
    void value() {
        var bigger = new BigDecimalDomain(new BigDecimal(1000));
        var smaller = new BigDecimalDomain(new BigDecimal(999.99));

        assertEquals(BigDecimal.valueOf(1000).longValue(), bigger.value().longValue());
        assertEquals(BigDecimal.valueOf(999.99).longValue(), smaller.value().longValue());
    }

    @Test
    @DisplayName("what happens here and there frequently")
    void common_use() {
        var businessNumber = new BigDecimal(1000);
        var businessNumber2 = new BigDecimal(999.000);

        if(businessNumber.compareTo(businessNumber2) > 0) {
            doThis();
        }else if(businessNumber.compareTo(businessNumber2) < 0){
            doThat();
        } else {
            whatever();
        }
    }

    private void whatever() { }

    private void doThis() {}

    private void doThat(){}
}