package leetcode.medium;

/**
 * Integer to Roman
 */
public class Problem12 {
    public String intToRoman(int num) {
        StringBuilder ret = new StringBuilder();
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] r = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;
        while (num > 0) {
            int count = num / val[i];
            for (int j = 0; j < count; j++) {
                ret.append(r[i]);
            }
            num -= (count * val[i]);
            i++;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Problem12 main = new Problem12();
        int num;
        num = 3;
        System.out.println(main.intToRoman(num));
        num = 4;
        System.out.println(main.intToRoman(num));
        num = 9;
        System.out.println(main.intToRoman(num));
        num = 58;
        System.out.println(main.intToRoman(num));
        num = 1994;
        System.out.println(main.intToRoman(num));
    }
}
