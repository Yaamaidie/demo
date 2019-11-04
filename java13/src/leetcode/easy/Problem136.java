package leetcode.easy;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem136 main = new Problem136();
        int[] nums;
        nums = new int[]{1};
        System.out.println(main.singleNumber(nums));
        nums = new int[]{1, 2, 1};
        System.out.println(main.singleNumber(nums));
        nums = new int[]{1, 2, 1, 2, 4};
        System.out.println(main.singleNumber(nums));
    }
}
