package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(6, 3);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(6, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(2, fraction.decimal());
    }

    @Test
    void testSet() {
        fraction.setNumerator(8);
        fraction.setDenominator(2);
        assertEquals(4, fraction.decimal());
    }
    @Test
    void testString() {
        fraction.toString();
        assertEquals("Fraction{numerator=" + 6 + ", denominator=" + 3 +
                      "}", fraction.toString());
    }
}
