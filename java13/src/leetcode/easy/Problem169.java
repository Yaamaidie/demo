package leetcode.easy;

public class Problem169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        Problem169 main = new Problem169();
        int[] nums;
        nums = new int[]{3, 2, 3};
        System.out.println(main.majorityElement(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(main.majorityElement(nums));
    }
}
