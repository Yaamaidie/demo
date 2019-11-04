package leetcode.medium;

//ZigZag Conversion
public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }
        boolean isEvenEndPoint = true;
        int distance = numRows - 1;
        for (int i = 0; i < s.length(); i += distance) {
            int j;
            if (isEvenEndPoint) {
                for (j = 0; j < numRows - 1 && i + j < s.length(); j++) {
                    result[j].append(s.charAt(i + j));
                }
                if (i + j >= s.length()) {
                    break;
                }
            } else {
                for (j = numRows - 1; j >= 1 && i + (numRows - 1 - j) < s.length(); j--) {
                    result[j].append(s.charAt(i + (numRows - 1 - j)));
                }
                if (numRows - 1 - j >= s.length()) {
                    break;
                }
            }
            isEvenEndPoint = !isEvenEndPoint;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            answer.append(result[i]);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Problem6 main = new Problem6();
        String input;
        input = "PAYPALISHIRING";
        System.out.println(main.convert(input, 3));
        input = "PAYPALISHIRING";
        System.out.println(main.convert(input, 4));

    }
}
