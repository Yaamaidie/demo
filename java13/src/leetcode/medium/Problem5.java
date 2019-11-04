package leetcode.medium;

import leetcode.easy.Problem125;

/**
 * 最大子回文字符串
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        return manacherAlgorithm(s);
    }

    //暴力法，时间为O(n^3)，空间为O(1)
    public String bruteForce(String s, int start, int end) {
        int ansI = start, ansJ = start;
        Problem125 palindromeSolution = new Problem125();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (palindromeSolution.isPalindromeHelper(s, i, j)) {
                    if (ansJ - ansI < j - i) {
                        ansI = i;
                        ansJ = j;
                    }
                }
            }
        }

        return s.substring(ansI, ansJ);
    }

    //动态规划，时间为O(n^2)，空间为O(n^2)。对于任意区间的元素[i,j]，0 <= i <= j <=s.length-1，i和j距离为0时为回文，i和j距离为1时，
    //s[i]==s[j]时为回文,i和j距离大于1时，s[i,j]为回文的条件为s[i+1,j-1]为回文且s[i]==s[j]...依次进行直到i和j距离为s.length - 1
    public String dynamicProgramming(String s, int start, int end) {
        if (s == null) {
            return null;
        }
        int size = end - start;
        if (size <= 0) {
            return null;
        }
        boolean[][] p = new boolean[size][size];
        int left = start, right = start;
        int distance = 0;
        while (distance < size) {
            for (int i = start; i < end - distance; i++) {
                if (distance == 0) {
                    p[i][i] = true;
                } else {
                    if (distance == 1) {
                        p[i][i + distance] = s.charAt(i) == s.charAt(i + 1);

                    } else {
                        p[i][i + distance] = p[i + 1][i + distance - 1] && s.charAt(i) == s.charAt(i + distance);
                    }
                    if (p[i][i + distance] && right - left < distance) {
                        left = i;
                        right = i + distance;
                    }
                }
            }
            distance++;
        }

        return s.substring(left, right + 1);
    }

    //动态规划改进版，时间为O(n^2)，空间为O(1)。注意到最大回文可由“中心”元素向左右扩展，当中心为一个元素时，向两边扩展后可以得到所有奇数
    // 长度的最大子回文字符串，当中心为两个元素时，向两边扩展后可以得到所有偶数长度的最大自会问字符串，而这样的中心有n+n-1 = 2n-1个。
    public String advancedDynamicProgramming(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 2 + 1;
    }

    private String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法，时间为O(N),空间为O(N);
    public String manacherAlgorithm(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Problem5 main = new Problem5();
        String input;
        input = "babad";
        System.out.println(main.longestPalindrome(input));
        input = "cbbd";
        System.out.println(main.longestPalindrome(input));
        input = "abcdefghhgfedlcds";
        System.out.println(main.longestPalindrome(input));
    }
}
