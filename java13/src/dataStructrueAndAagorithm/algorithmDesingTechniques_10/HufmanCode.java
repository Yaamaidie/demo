package dataStructrueAndAagorithm.algorithmDesingTechniques_10;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 哈夫曼编码，使用优先队列保存哈夫曼数
 */
public class HufmanCode {
    public TreeNode buildHufmanCodeTree(List<TreeNode> input) {
        if (input == null) {
            throw new NullPointerException();
        }
        Comparator<TreeNode> comparator = Comparator.comparingInt(a -> a.weight);
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(comparator);
        input.forEach(
                queue::offer
        );

        TreeNode ret = null;
        TreeNode min1;
        TreeNode min2;
        while (true) {
            min1 = queue.poll();
            min2 = queue.poll();
            if (min1 != null && min2 != null) {
                ret = new TreeNode(min1.weight + min2.weight, min1, min2);
                queue.offer(ret);
            } else {
                break;
            }
        }

        return ret;

    }

    /**
     * 哈夫曼树
     */
    private static class TreeNode {
        String str;
        int weight;
        TreeNode left;
        TreeNode right;

        TreeNode(String s, int w) {
            str = s;
            weight = w;
        }

        TreeNode(int w, TreeNode l, TreeNode r) {
            weight = w;
            left = l;
            right = r;
        }

        @Override
        public String toString() {
            return (str == null ? "?" : str)
                    + "=" + weight
                    + "->(" + (left == null ? "" : left)
                    + ","
                    + (right == null ? "" : right) + ")";
        }
    }

    public static void main(String[] args) {
        HufmanCode hufmanCode = new HufmanCode();
        List<TreeNode> treeNodes = List.of(
                new TreeNode("a", 10),
                new TreeNode("e", 15),
                new TreeNode("i", 12),
                new TreeNode("s", 3),
                new TreeNode("t", 4),
                new TreeNode("space", 13),
                new TreeNode("newline", 1)
        );

        System.out.println(hufmanCode.buildHufmanCodeTree(treeNodes));
    }
}
