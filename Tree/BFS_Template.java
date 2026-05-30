package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BFS_Template {

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // List<List<Integer>> list = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // List<Integer> ans = new ArrayList<>();

                // ====== DO LOGIC HERE ======
                // System.out.print(node.val + " ");

                // ===========================                

                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                } 
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
            }
            // level finished here
        }
    }
}
