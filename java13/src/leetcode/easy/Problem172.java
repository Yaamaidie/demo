package leetcode.easy;

public class Problem172 {
    public int trailingZeroes(int n) {
        int result = 0;
        for (long i = 5; n / i > 0; i *= 5) {
            result += (n / i);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem172 main = new Problem172();
        int input;
        input = 3;
        System.out.println(main.trailingZeroes(input));
        input = 5;
        System.out.println(main.trailingZeroes(input));
        input = 100;
        System.out.println(main.trailingZeroes(input));
    }
}
