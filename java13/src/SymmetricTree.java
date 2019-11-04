import leetcode.TreeNode;

import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode test = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
/*        System.out.println(reverse(test));
        System.out.println(isEquals(null, null));
        System.out.println(isEquals(new leetcode.TreeNode(1), null));
        System.out.println(isEquals(new leetcode.TreeNode(1), new leetcode.TreeNode(1)));
        System.out.println(isEquals(new leetcode.TreeNode(1, new leetcode.TreeNode(2), new leetcode.TreeNode(3)),
                new leetcode.TreeNode(1, new leetcode.TreeNode(2), new leetcode.TreeNode(3))));*/

        //[1,2,3,3,2,4,1,4,1,1,4,1,4]
        TreeNode sTree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(2, new TreeNode(5), new TreeNode(4)));
        System.out.println(sTree);
        System.out.println(isSymmetric2(sTree));
        System.out.println(isSymmetric(sTree));
    }

    public TreeNode sortedArrayToBST(int[] nums) {


        return null;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isSymmetric2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);

        }
        return true;
    }


    public static boolean isMirror(TreeNode x, TreeNode y) {
        if (x == null || y == null) {
            return x == y;
        }

        return x.val == y.val && isMirror(x.left, y.right) && isMirror(x.right, y.left);
    }

    public static TreeNode reverse(TreeNode treeNode) {
        if (treeNode == null) {
            return treeNode;
        }
        return new TreeNode(treeNode.val, reverse(treeNode.right), reverse(treeNode.left));
    }

}
