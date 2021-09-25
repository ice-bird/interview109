package fish.tree;
// 面试题 04.03. 特定深度节点链表

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import fish.list.ListNode;

// 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组


public class Inter0404 {
    // 这不就是中序遍历吗 - - 队列实现
    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> res = new ArrayList<>();
        // 因为一开始深度未知，除非先求一下深度，知道尺寸
        Deque<TreeNode> deque = new LinkedList<>();
        if (tree == null) {
            return new ListNode[0];
        }
        deque.add(tree);
        while (!deque.isEmpty()) {
            int len = deque.size();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }

                cur.next = new ListNode(node.val);
                cur = cur.next;
            }
            // 此时，注意需要深拷贝这个listNode  XXX错误想法
            // 此时，每个ListNode都是new出来的，可以dummy引用换了而已，本身就是不同的数据，不需要深拷贝
            res.add(dummy.next);
        }

        ListNode[] r = new ListNode[res.size()];
        int index = 0;
        for (ListNode listNode : res) {
            r[index++] = listNode;
        }
        return r;
    }
    
    // 时空复杂度：O(N)
    // 注意注意：Deque poll是出队，offer是入队
    // pop和push是栈的操作
}
