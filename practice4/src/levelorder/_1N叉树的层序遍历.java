package levelorder;

import java.util.LinkedList;
import java.util.List;

public class _1N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelCnt = que.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (levelCnt > 0) {
                Node top = que.poll();
                list.add(top.val);
                for (Node child : top.children) {
                    if (child != null) {
                        que.offer(child);
                    }
                }
                levelCnt--;
            }
            res.add(list);
        }
        return res;
    }
}
