package fish.list;
// 面试题 02.01. 移除重复节点

import java.util.HashSet;

// 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
// 进阶：
// 如果不得使用临时缓冲区，该怎么解决？

public class Inter0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        // 重复问题：HashMap(Set)
        // 本质上是双指针法：
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        // cur 比pre 快一步
        while (cur != null) {
            if (set.contains(cur.val)) {

                cur = cur.next;
            } else {
                set.add(cur.val);

                pre.next = cur;
                // 一但找到了不同的，则连接
                cur = cur.next;
                pre = pre.next;
            }
        }
        pre.next = null; //断开最后的连接
        // // 123321情况下，pre未断开
        return dummy.next;

    }
    // 时间空间：O(N)
    // 用一位表示是否已存在，链表元素长度20000以内。
    // 记录下需要保留哪些位。有点傻
    
    
    // 方法2：不使用额外空间
}

    

