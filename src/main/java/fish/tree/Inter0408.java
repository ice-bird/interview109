package fish.tree;
// inter0408 首个共同祖先

// 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。

// 回忆剑指offer：思路：原问题：二叉搜索树：if(a<val && b> val)一大一小则是祖先
// 进阶：普通树：DFS找出A的路径，找出B的路径，然后比对？ ----暴力解法
// 递归思路，把问题简单化，判断左节点是否存在？判断右节点是否存在，return 左存在&&右存在
// 如果用boolean返回，则重复多次找，简化为没找到则返回
public class Inter0408 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            // 只要找到==q或p的，就返回
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 3种情况
        // left和right均不为空，返回root
        if (left != null && right != null) {
            return root;
        }
        // 某一个为空,此情况对应与 p是q的祖先，则返回p是合理的
        return left != null ? left : right;
        
        // 假设第一次找到了，肯定先返回p,右侧q没找到，肯定返回p
        // 因此返回值一直不变。若首次左右两端找到，则返回root。后续的root的兄弟肯定找不到，因此结果就是最早的这个root
    }
}
