package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImProper() {
        return numerator > denominator;
    }

    public boolean isEquivalent(Fraction fac, Fraction fac1) {
        return (fac.numerator * fac1.denominator) == (fac1.numerator * fac.denominator);
    }

    private int MCD(int fac, int fac1) {
        int i = 0;
        while (fac1 != 0) {
            i = fac1;
            fac1 = fac % fac1;
            fac = i;
        }
        return fac;
    }

    private int mcmFunction(Fraction fac, Fraction fac1) {
        int mcm = (fac.denominator * fac1.denominator) / MCD(fac.denominator, fac1.denominator);
        return mcm;
    }

    public Fraction add(Fraction fac, Fraction fac1) {
        int mcm = mcmFunction(fac, fac1);
        int num = mcm / fac.denominator;
        int num1 = mcm / fac1.denominator;
        return new Fraction(fac.numerator * num + fac1.numerator * num1, mcm);
    }

    public Fraction substract(Fraction fac) {
        return new Fraction(fac.numerator * this.denominator - this.numerator * fac.denominator,
                fac.denominator * this.denominator);
    }

    public Fraction multiply(Fraction fac, Fraction fac1) {
        return new Fraction(fac.numerator * fac1.numerator, fac.denominator * fac1.denominator);
    }

    public Fraction divide(Fraction fac, Fraction fac1) {
        return new Fraction(fac.numerator * fac1.denominator, fac1.numerator * fac.denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
