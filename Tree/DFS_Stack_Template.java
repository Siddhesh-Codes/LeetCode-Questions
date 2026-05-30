package Tree;

import java.util.Stack;

public class DFS_Stack_Template {
    public void dfs(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();

            // ====== DO LOGIC HERE ======
            System.out.print(node.val + " ");
            // ===========================

            // push right first so left is processed first
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
            
            // push left first if you want to process right first
            // if (node.left != null) st.push(node.left);
            // if (node.right != null) st.push(node.right);

        }
    }
}
