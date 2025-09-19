package levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _4在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int maxVal = Integer.MIN_VALUE;
            while (sz > 0) {
                TreeNode pNode = q.poll();
                maxVal = Math.max(maxVal, pNode.val);
                if (pNode.left != null) {
                    q.offer(pNode.left);
                }
                if (pNode.right != null) {
                    q.offer(pNode.right);
                }
                sz--;
            }
            res.add(maxVal);
        }
        return res;
    }
}
