package utilities;

public class Number {
    
    private String value = "0";

    public String getValue() {
        return value;
    }

    public Number(int inputValue) {
        value = Integer.toString(inputValue);
    }

    public void add(Number other) {
        String rev1 = reverse(this.getValue());
        String rev2 = reverse(other.getValue());

        this.value = "";

        if (rev1.length() > rev2.length()) {
            String temp = rev1;
            rev1 = rev2;
            rev2 = temp;
        }

        int carry = 0;
        for (int i = 0; i < rev1.length(); i++) {
            int sum = getDigit(rev1, i) + getDigit(rev2, i) + carry;
            value += numToChar(sum % 10);
            carry = sum / 10;
        }

        for (int i = rev1.length(); i < rev2.length(); i++) {
            int sum = getDigit(rev2, i) + carry;
            value += numToChar(sum % 10);
            carry = sum / 10;
        }

        value += numToChar(carry);
        value = reverse(value);
    }

    public void subtract(Number other) {
        
    }

    public void multiply(Number other) {
        
    }

    public void divide(Number other) {
        
    }

    public void modulo(Number other) {
        
    }

    public void power(Number other) {
        
    }

    private static String reverse(String input) {
        String reversedString = "";
        for (int i = input.length()-1; i >= 0; i--) {
            reversedString += input.charAt(i);
        }
        return reversedString;
    }

    private static char numToChar(int digit) {
        return (char) (digit + '0');
    }

    private static int getDigit(String value, int pos) {
        return (int) (value.charAt(pos) - '0');
    }

}