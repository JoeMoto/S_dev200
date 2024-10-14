package Mod3PA2;

import java.math.*;

public class rational extends Number implements Comparable<rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    /** Construct a rational with default values */
    public rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /** Construct a rational with specified numerator and denominator */
    public rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
        if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
    }

    /** Return the numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return the denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add two rational numbers */
    public rational add(rational secondRational) {
        BigInteger n = (numerator.multiply(secondRational.getDenominator()))
                .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new rational(n, d);
    }

    /** Subtract two rational numbers */
    public rational subtract(rational secondRational) {
        BigInteger n = (numerator.multiply(secondRational.getDenominator()))
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new rational(n, d);
    }

    /** Multiply two rational numbers */
    public rational multiply(rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new rational(n, d);
    }

    /** Divide two rational numbers */
    public rational divide(rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public int compareTo(rational o) {
        BigInteger left = numerator.multiply(o.getDenominator());
        BigInteger right = denominator.multiply(o.getNumerator());
        return left.compareTo(right);
    }

    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }

    @Override
    public float floatValue() {
        return numerator.divide(denominator).floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }
}
