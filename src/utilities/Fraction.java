package utilities;

import java.util.Collections;

@SuppressWarnings("unused")
public class Fraction {

    private Number numerator;
    private Number denominator;

    public Fraction(float inputF) {
        double input = (double) inputF;
        int den = (int) (1 / (Math.abs(input - (int) input - 0.0001)));
        int num = ((int)inputF) * den + 1;
        this.numerator = new Number(num);
        this.denominator = new Number(den);
    }

    public String toString() {
        String dashes = String.join("", Collections.nCopies(Math.max(numerator.size(), denominator.size()), "-"));
        return numerator.toString() + "\n" + dashes + "\n" + denominator.toString();
    }
    
}