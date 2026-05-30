package Tree;

public class DFS_Recusive_Template {
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // ====== DO PRE-ORDER LOGIC HERE ======
        System.out.print(root.val + " ");
        // ====================================

        dfs(root.left);

        // ====== DO IN-ORDER LOGIC HERE ======
        // ====================================

        dfs(root.right);

        // ====== DO POST-ORDER LOGIC HERE ======
        // =====================================        
    }
}
