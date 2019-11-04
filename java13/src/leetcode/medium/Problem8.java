package leetcode.medium;

/**
 * atoi: string to integer
 */
public class Problem8 {
    public int myAtoi(String str) {

        if (str != null) {
            str = str.trim();
        }

        if (str.length() == 0) {
            return 0;
        }

        int i = 0;
        // take data type as long so that we can  store overflown values
        long num = 0;
        boolean isNegative = false;

        //move to first character and keep track of sign by updating isNegative
        if (str.charAt(0) == '-') {
            i++;
            isNegative = true;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        //check if the character is digit by comparing ascii values
        while (i < str.length() && ((int)str.charAt(i)) >= 48 &&  ((int)str.charAt(i)) <= 57) {

            //form the number with digits
            num = num * 10 + ((int)str.charAt(i) - 48);
            i++;

            if (isNegative && -num <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!isNegative && num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        if (isNegative) {
            return (int) -num;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        Problem8 main = new Problem8();
        String input;
        input = "42";
        System.out.println(main.myAtoi(input));
        input = "   -42";
        System.out.println(main.myAtoi(input));
        input = "4193 with words";
        System.out.println(main.myAtoi(input));
        input = "words and 987";
        System.out.println(main.myAtoi(input));
        input = "-91283472332325235233";
        System.out.println(main.myAtoi(input));
        input = "-6147483648";
        System.out.println(main.myAtoi(input));
    }
}
