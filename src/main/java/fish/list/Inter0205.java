package fish.list;
// 面试题 02.05. 链表求和

import java.util.Deque;
import java.util.LinkedList;

// 给定两个用链表表示的整数，每个节点包含一个数位。
// 这些数位是反向存放的，也就是个位排在链表首部。
// 编写函数对这两个整数求和，并用链表形式返回结果。

// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
// 输出：2 -> 1 -> 9，即912

// 进阶：假设这些数位是正向存放的，又该如何解决呢?
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
// 输出：9 -> 1 -> 2，即912
public class Inter0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 和普通加法是类似的操作
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int q = 0; //进位
        // 注意终止条件不仅仅是l1 l2非空，特殊情况：5+5 进位也要考虑
        // 或逻辑会更清晰
        // while(l1!=null || l2!=null || q!=0)
        while (!(l1 == null && l2 == null && q == 0)) {
            int b1 = (l1 == null ? 0 : l1.val);
            int b2 = (l2 == null ? 0 : l2.val);
            int r = (b1 + b2 + q) % 10; //余数
            q = (b1 + b2 + q) / 10; //商即进位
            cur.next = new ListNode(r);
            cur = cur.next;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        // // 此时有一方为空
        // if (l1 != null) {
        //     int r = (l1.val+q) % 10;
        //     q = (l1.val + q) % 10;
        //     cur.next = new ListNode(r);
        //     cur = cur.next;
        //      l1=l1.next;
        // }
        // if (l2 != null) {
        //     int r = (l2.val+q) % 10;
        //     q = (l2.val + q) % 10;
        //     cur.next = new ListNode(r);
        //     cur = cur.next;
        //      l2=l2.next;
        // }
        return dummy.next;
    }
    
    // 若逆向存储，如617+12
    // 利用栈的机制，从链表中入栈，刚好顺序是按照低位-高位
    public ListNode addTwoInvertedNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        // 后续操作相同
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int q = 0; //进位
        // 注意终止条件不仅仅是l1 l2非空，特殊情况：5+5 进位也要考虑
        // 或逻辑会更清晰
        // while(l1!=null || l2!=null || q!=0)
        while (!s1.isEmpty() || !s2.isEmpty() || q != 0) {
            int b1 = (s1.isEmpty() ? 0 : s1.pop());
            int b2 = (s2.isEmpty() ? 0 : s2.pop());

            int r = (b1 + b2 + q) % 10; //余数
            q = (b1 + b2 + q) / 10; //商即进位

            cur.next = new ListNode(r);
            cur = cur.next;
        }
        return dummy.next;
    }

}
