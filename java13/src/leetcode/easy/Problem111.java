package leetcode.easy;

import leetcode.TreeNode;

public class Problem111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        return min;
    }

    public static void main(String[] args) {
        Problem111 main = new Problem111();
        TreeNode t = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(main.minDepth(t));

//        TreeNode t2 = new TreeNode(1, null, new TreeNode(2));
//        System.out.println(main.minDepth(t2));
    }
}
