import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(12),
                        new TreeNode(13)),
                new TreeNode(20,
                        new TreeNode(15, new TreeNode(1), new TreeNode(9)),
                        new TreeNode(7)));
        System.out.println(t);
        System.out.println(levelOrderBottom(t));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                /*把同一层的节点的子节点放进queue*/
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                /*把同一层所有节点的值放进一个list*/
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }

}
