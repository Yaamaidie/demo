import leetcode.TreeNode;

/**
 * leecode solution
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : generateTree(0, nums.length - 1, nums);
    }

    public TreeNode generateTree(int begin, int end, int[] nums) {
        if (begin > end) {
            return null;
        }
        int middle = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = generateTree(begin, middle -1, nums);
        root.right = generateTree(middle + 1, end, nums);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] data = {-10,-3,0,5,9};
        TreeNode treeNode = s.sortedArrayToBST(data);
        System.out.println(treeNode);
    }
}
