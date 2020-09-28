package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction fraction;
    private Fraction fraction1;
    private Fraction fraction2;
    private Fraction generic = new Fraction();
    @BeforeEach
    void before() {
        fraction = new Fraction(6, 3);
        fraction1 = new Fraction(4, 2);
        fraction2 = new Fraction(2, 6);
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

    @Test
    void testProper() {
        assertFalse(fraction.isProper());
        assertTrue(fraction2.isProper());
    }

    @Test
    void testImproper() {
        assertFalse(fraction2.isImProper());
        assertTrue(fraction.isImProper());
    }

    @Test
    void testEquivalent() {
        assertFalse( generic.isEquivalent(fraction, fraction2));
        assertTrue( generic.isEquivalent(fraction, fraction1));
    }

    @Test
    void testAdd() {
        assertEquals(4, generic.add(fraction,fraction1));
    }

    @Test
    void testMultiply() {
        assertEquals(4, generic.multiply(fraction,fraction1));
    }

    @Test
    void testDivide() {
        assertEquals(1, generic.divide(fraction,fraction1));
    }
}
