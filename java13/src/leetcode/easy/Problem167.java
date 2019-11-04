package leetcode.easy;

import java.util.Arrays;

public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) {
            return indice;
        }

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (target == v) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (target > v) {
                left++;
            } else {
                right--;
            }
        }

        return indice;
    }

    public static void main(String[] args) {
        Problem167 main = new Problem167();
        int[] input = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(main.twoSum(input, target)));
    }
}
