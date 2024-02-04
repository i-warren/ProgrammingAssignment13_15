import java.math.BigInteger;
import java.util.Objects;

public class Rational extends Number implements Comparable<Rational>{
    // Data fields for numerator and denominator
    private BigInteger[] r = new BigInteger[2];
    private static final int NUMERATOR = 0;
    private static final int DENOMINATOR = 1;

    /** Construct a rational with default properties */
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        r[NUMERATOR] = numerator;
        r[DENOMINATOR] = denominator;
    }

    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {

        return n.gcd(d);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return r[NUMERATOR];
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return r[DENOMINATOR];
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator())
                .add(r[DENOMINATOR].multiply(secondRational.getNumerator()));
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator())
                .subtract(r[DENOMINATOR].multiply(secondRational.getNumerator()));
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getNumerator());
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator());
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    /** Returns String representation of Rational number*/
    @Override   // Override the toString method in the Object class
    public String toString() {
        if (Objects.equals(r[DENOMINATOR], BigInteger.ONE))
            return r[DENOMINATOR] + "";
        else
            return r[NUMERATOR] + "/" + r[DENOMINATOR];
    }

    /** Returns whether two Rational numbers are equal*/
    @Override   // Override the equals method in the Object class
    public boolean equals(Object obj) {
        if (!super.equals(obj))
        {
            return false;
        }
       // return (this minus (obj cast to Rational) equals zero
        return (this.subtract((Rational) (obj))).getNumerator().equals(BigInteger.ZERO);
    }

    /** Return int value of Rational number*/
    @Override   // Implement the abstract intValue method in Number
    public int intValue() {
        return (int)doubleValue();
    }

    /** Return float value of Rational number*/
    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float)doubleValue();
    }

    /** Return double value of Rational number*/
    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        double num1 = Double.parseDouble(r[NUMERATOR].toString());
        double denom1 = Double.parseDouble(r[DENOMINATOR].toString());
        return num1 / denom1;
    }

    /** Return long value of Rational number*/
    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long)doubleValue();
    }


    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational obj) {
        if (this.subtract(obj).getNumerator().doubleValue() > 0){
            return 1;
        } else if (this.subtract(obj).getNumerator().doubleValue() < 0) {
            return -1;
        } else{
            return 0;
        }

    }
}
