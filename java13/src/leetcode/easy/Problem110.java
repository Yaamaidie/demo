package leetcode.easy;

import leetcode.TreeNode;

public class Problem110 {
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }

        return hight(root.left) - hight(root.right) <= 1
                && hight(root.right) - hight(root.left) <= 1
                && isBalance(root.left)
                && isBalance(root.right);
    }

    int hight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(hight(root.left), hight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(t);

        Problem110 main = new Problem110();
        System.out.println(main.isBalance(t));
    }
}
