package fish.tree;
// 面试题0405 合法搜索二叉树

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// 实现一个函数，检查一棵二叉树是否为二叉搜索树。

// 二叉搜索树：左子树<root<右子树 
// 二叉搜索树的特点：中序遍历必定有序！！！
// 首先的思路：递归，但是还要继续比较上层、上层、上层（5 -1 6  1--0 8)比较8时需要再和5比较，此路不通 - - 要设定范围。。。
public class Inter0405 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        // ArrayList直接存TreeNode会更节省内存，省去了new Integer()的堆内存

        DFS(root, arr);

        // 判断arr是否有序
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) >= arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    // ?? 1 1不算？
    // 时空复杂度O(N) 
    
    void DFS(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        DFS(root.left, arr);
        arr.add(root.val);
        DFS(root.right, arr);
    }

    // ******递归法 直接比较不够，还需要判断范围
    public boolean isValidBST03(TreeNode root) {
        return DFS02(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // 这里有一组起奇葩的测试用例 1 1 false
        // 然后出现Integer.MIN_VALUE，因此这里就需要 用更小的边界代替 Long.MIN_VALUE Long.MAX_VALUE
    }

    boolean DFS02(TreeNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        return (root.val > low && root.val < high) && DFS02(root.left, low, root.val)
                && DFS02(root.right, root.val, high);
        // 自身处于区间、左节点符合
        // 这里的low和high的更新
    }
    // 复杂度O(N) 递归N次
    


    // ****** 非递归的中序遍历
        // 利用栈中序遍历
        public boolean isValidBST02(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            double inorder = -Double.MAX_VALUE;     //最小的
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // inorder是用来指示最小的边界，因为中序是左 - 中 -右 只需要左边界即可
                // 左- 中 -右的过程中，最小值是逐步增大的
                if (root.val <= inorder) {
                    // 不符合 > min
                    return false;
                }
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    
        // 参考代码
        public static void inOrderTraversal(TreeNode tree) {
            // 模拟的过程：
            // 1. 从根节点出发一路把左节点入栈
            // 2. (最底层的左节点)出栈 ，sout(ndoe.val)
            // 3. 切换到右节点
            // 4. 重复右节点的左节点一步步入栈
            Deque<TreeNode> stack = new LinkedList<>();

            while (tree != null || !stack.isEmpty()) {
                // 节点非空或栈非空
                while (tree != null) {
                    stack.push(tree);
                    tree = tree.left;
                }

                if (!stack.isEmpty()) {
                    tree = stack.pop();
                    System.out.println(tree.val); // 底层节点值
                    tree = tree.right; //当前层的左节点可能有右节点
                    // 如果最底层的左节点，无右节点，则回到while循环，不通过，再pop出来的就是上一层的（中节点）
                }
            }
        }
        
        // 如何在这个基础上实现非递归判断？
}
