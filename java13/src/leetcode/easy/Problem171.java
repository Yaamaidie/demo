package leetcode.easy;

public class Problem171 {
    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        int num = 0;
        for (char ch : s.toCharArray()) {
            num = num * 26 + (ch - 'A' + 1);
        }

        return num;
    }

    public static void main(String[] args) {
        Problem171 main = new Problem171();
        String s;
        s = "A";
        System.out.println(main.titleToNumber(s));
        s = "AB";
        System.out.println(main.titleToNumber(s));
        s ="ZY";
        System.out.println(main.titleToNumber(s));
        s = "ABC";
        System.out.println(main.titleToNumber(s));
    }
}
