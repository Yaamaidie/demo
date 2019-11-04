package leetcode.easy;

/**
 * palindrome solution
 */
public class Problem125 {
    public boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length());
    }

    public boolean isPalindromeHelper(String s, int start, int end) {
        if (s == null) {
            return false;
        }

        int i = start, j = end - 1;
        do {
            while (i <= end - 1 && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            if (i > end - 1) {
                return true;
            }

            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (j < 0) {
                return true;
            }

            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        } while (i < j);

        return true;
    }

    public static void main(String[] args) {
        Problem125 main = new Problem125();
        String s;
        s = null;
        System.out.println(main.isPalindrome(s));
        s = "";
        System.out.println(main.isPalindrome(s));
        s = "abcba";
        System.out.println(main.isPalindrome(s));
        s = "abccba";
        System.out.println(main.isPalindrome(s));
        s = "A man, a plan, a canal: Panama";
        System.out.println(main.isPalindrome(s));
        s = " ";
        System.out.println(main.isPalindrome(s));
    }
}
