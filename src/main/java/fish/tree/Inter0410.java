package fish.tree;
// 面试题 0410 检查子树
// 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
// 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
import java.util.List;
import java.util.ArrayList;

public class Inter0410 {
    // 子树：中序、前序、后序、遍历后，出来后，子树必定是一部分
    // 中序不行，因为 左-中-右  A在root的左边，则A的右子树，难以判断哪里结束?
    // 不是这个问题，而是 值相同，但结构不同树，中序遍历是可能相同的
    // 比如 12--3   1--2--3
    // 为什么前序可以保留？？
    // 但是前序可以：中 左 右（ --- 序列化时，遇到null则用null占位

    // 然后就是子串匹配问题KMP 复杂度ON
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // 中序遍历复杂度ON
        List<Integer> preOrder1 = new ArrayList<>();
        List<Integer> preOrder2 = new ArrayList<>();
        preOrderTraversal(t1,preOrder1);
        preOrderTraversal(t2, preOrder2);
        
        // 可以不自己写KMP算法
        String o1 = preOrder1.toString();
        String o2 = preOrder2.toString();

        return o1.contains(o2.substring(1, o2.length() - 1));
        // 为什么要去掉o2第一个数？
    }
    
    void preOrderTraversal(TreeNode t,List<Integer> list) {
        if (t == null) {
            list.add(null);
            return;
        }
        list.add(t.val);
        preOrderTraversal(t.left, list);
        preOrderTraversal(t.right, list);
    }
    
    // 递归法：一个一个比较 复杂度N*M
    public boolean checkSubTree02(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }
        return isSame(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        // 相当于两层递归结构
    }

    public boolean isSame(TreeNode t1,TreeNode t2){
        // 终止条件
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        // 基本的递归，若连个为空，若其中一空一数
            return t1.val == t2.val && checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
    }


    
}
