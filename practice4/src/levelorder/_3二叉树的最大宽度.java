package levelorder;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _3二叉树的最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Pair<TreeNode, Integer>> queue = new ArrayList<>();
        queue.add(new Pair<>(root, 1));
        int maxLen = 0;
        while (!queue.isEmpty()) {
            // 更新这一层的高度
            int l1 = queue.get(0).getValue();
            int l2 = queue.get(queue.size()).getValue();
            maxLen = Math.max(l2 - l1 + 1, maxLen);
            // 更新下一层
            ArrayList<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : queue) {
                if (pair.getKey().left != null) {
                    tmp.add(new Pair<TreeNode, Integer>(pair.getKey().left, pair.getValue() * 2));
                }
                if (pair.getKey().right != null) {
                    tmp.add(new Pair<TreeNode, Integer>(pair.getKey().right, pair.getValue() * 2 + 1));
                }
            }
            queue = tmp;
        }
        return maxLen;
    }
}
