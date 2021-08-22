package fish;

// 检查平衡性：判断二叉树是否平衡
// 平衡：abs(左深度 - 右深度)<=1
public class Inter0404 {
    // 方案1：求树的深度
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((Math.abs(depth(root.left) - depth(root.right)) > 1)) {
            return false;
        } else { // 此节点符合
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    // 方法2：如果平衡，则返回深度，不平衡则返回-2 看最后是否是-1
    public int depth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dl = depth02(root.left);
        int dr = depth02(root.right);
        // 这里是错误的写法，可能导致 链表型，最后一步是符合的，然后返回 -2 +1
        // 正确写法
        if (dl == -2 || dr == -2) {
            // 只要有一个是不符合，则均不符合
            return -2;
        }
        // 满足此条件后再判断
        if (Math.abs(dl - dr) <= 1) {
            return Math.max(dl, dr) + 1;
        } else {
            return -2;
            // 一旦有一个符合，则此节点的深度为-2，对于上层节点，左-2， 则不可能进度dl-dr<=1分支
        }
    }

    public boolean isBalanced02(TreeNode root) {
        System.out.println();
        return depth02(root) != -2;
    }
    // 有点离谱，反而用时更多了
    // 方法1：时间N^2 空间O(N) 方法2复杂度：时空O(N)
}

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
