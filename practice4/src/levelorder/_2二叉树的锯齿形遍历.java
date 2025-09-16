package levelorder;

import java.util.LinkedList;
import java.util.List;

class _2二叉树的锯齿形遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean leftToRight = true;
        while (!que.isEmpty()) {
            int levelCnt = que.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (levelCnt > 0) {
                TreeNode top = que.poll();
                if (leftToRight) {
                    list.add(top.val);
                } else {
                    list.addFirst(top.val);
                }
                if (top.left != null) {
                    que.offer(top.left);
                }
                if (top.right != null) {
                    que.offer(top.right);
                }
                levelCnt--;
            }
            // 改变方向
            leftToRight = !leftToRight;
            res.add(list);
        }
        return res;
    }
}
