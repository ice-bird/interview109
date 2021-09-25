package fish.stack;
// 面试题 03.05. 栈排序

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

// 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
// 此处的不同在于，需要

// 使最小元素位于栈顶，这个是什么含义？难不成必须放在最上面？pop出的必须是最小元素？
// 看来比剑指offer麻烦一点。

// 具体实现：两个水杯倒水，一直和deque比较，若小于，则直接添加，大于则出栈到辅助栈，找到对应的位置，然后从辅助栈入栈。
// 辅助栈只负责push时存放临时数据（倒水时接一下）
public class SortedStack {
    // 剑指offer中的辅助栈- - 单调栈存放最小值
    Deque<Integer> deque;
    Deque<Integer> assistDeque;

    public SortedStack() {
        deque = new LinkedList<>();
        assistDeque = new LinkedList<>();
        // 注意Deque是接口，LinkedList才是实现
    }

    void push(int val) {
        deque.push(val);
        if (!assistDeque.isEmpty()) {
            if (val <= assistDeque.peek()) {
                // 直接peek可能空指针异常
                // 注意等于也要添加
                assistDeque.push(val);
            }
        } else {
            // 为空则直接添加
            assistDeque.push(val);
        }
    }

    void pop() {
        int res = deque.pop();
        if (!assistDeque.isEmpty() && res == assistDeque.peek()){
            assistDeque.pop();
        }
    }

    int peek() {
        if (!assistDeque.isEmpty()){
            return assistDeque.peek();
        } else {
            return -1;
        }
    }
    
    boolean isEmpty() {
        return deque.isEmpty();
    }






        // *******************//
        // 倒水法 其他peek.pop较简单，只需要注意先判断是否为空，防止空指针异常
        void push02(int val) {
            while (!deque.isEmpty() && val > deque.peek()) {
                // 非空且val较大，则把较小的数移到辅助栈
                assistDeque.push(deque.pop());
            }
            // 跳出循环，要么空、要么val==peek() 可装载数据val了
            deque.push(val);
            while (!assistDeque.isEmpty()) {
                deque.push(assistDeque.pop());
            }
        }


        // ******************//
        // 题目的功能就是优先队列（只有插入、取出、访问，要求第一个为最小值）
        // 成员变量
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // push pop peek 直接对pq操作即可

        // 优先队列特点：

}
