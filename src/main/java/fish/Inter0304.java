package fish;

import java.util.Scanner;
import java.util.Stack;

public class Inter0304 {
    
}

class MyQueue {
    // 化栈为队列// 2个栈，实现队列
    // 思路：入队栈A、出队栈B
    // 入队：正常入栈A
    // 出队：若B为空，则将A全部元素出栈、入栈、移至B，则此时B为原A的倒序
    // 再入栈，则入A，出队则从B出栈

    // 成员变量
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    // 构造器
    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    // 成员方法
    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                int temp = stackA.pop();
                stackB.push(temp);
            }
        }
        return stackB.pop();
    }

    public int peek() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                int temp = stackA.pop();
                stackB.push(temp);
            }
        }
        return stackB.peek();
    }
    
    public boolean empty() {
        return stackA.size() + stackB.size() == 0;
        // return stackA.isempty() && stackA.isempty();
    }

    public static void main(String[] args) {
        System.out.println("input:");
        Scanner sc = new Scanner(System.in);
        sc.next();
        sc.close();
    }
}