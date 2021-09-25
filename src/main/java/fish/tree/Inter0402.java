package fish.tree;
// 最小高度树：
// 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
public class Inter0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 注意是升序排列。构造二叉搜索树
        // 高度最小，则应该每个数均位于中间.二分法
        // 递归
        // 或者BFS的思路，用队结构实现
        return DFS(0, nums.length - 1, nums);
    }
    
    public TreeNode DFS(int low, int high, int[] nums) {
        if (low > high) {
            return null;
        }
        int mid = low + ((high - low) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = DFS(low, mid - 1, nums);
        root.right = DFS(mid + 1, high, nums);
        return root;
    }
    
    // 背下来。关键在于如何分解问题。
    // 子问题：以中心为root，左边的是左边的中点，右边是右数组中点
    // 中点即为操作的子问题。
    // 返回条件，如果没有了，则返回null，表示上一层的left或right节点为null
}
