package dataStructures.testing;

public class ShellAlgorithms {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(A108870(i));
        }
    }

    public static long A108870(int k) {
        double nineOnFourPow = Math.pow((9d / 4d), k-1);
        double inBrackets = 9d * nineOnFourPow - 4d;
        return (long) Math.ceil((1d / 5d) * inBrackets);
    }
}