package leetcode.easy;

public class Problem168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Problem168 main = new Problem168();
        int input;
        input = 1;
        System.out.println(main.convertToTitle(input));
        input = 26;
        System.out.println(main.convertToTitle(input));
        input = 27;
        System.out.println(main.convertToTitle(input));
        input = 51;
        System.out.println(main.convertToTitle(input));
        input = 52;
        System.out.println(main.convertToTitle(input));
        input = 53;
        System.out.println(main.convertToTitle(input));
        input = 701;
        System.out.println(main.convertToTitle(input));
        input = 703;
        System.out.println(main.convertToTitle(input));
    }
}
