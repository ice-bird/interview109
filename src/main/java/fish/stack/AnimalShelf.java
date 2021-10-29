package fish.stack;
// 动物收容所
// 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。

import java.util.Deque;
import java.util.LinkedList;

public class AnimalShelf {
    Deque<Integer> dequeCat;
    Deque<Integer> dequeDog;
    // 存的也可以不是数组，因为类型从deque中可以知道
    // boolean oldest;  // 重点在于维护此标志
    // 可以直接从deque中peek出看一下编号，小的则老
    public AnimalShelf() {
        this.dequeCat = new LinkedList<>();
        this.dequeDog = new LinkedList<>();
        // this.oldest = true;
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            dequeCat.offer(animal[0]);
        }else if(animal[1]==1) {
            dequeDog.offer(animal[0]);
        }else{
            System.out.println("ERROR");
        }
    }

    public int[] dequeueAny() {
        // 先判断空
        if (dequeCat.isEmpty()) {
            return dequeueDog();
        }
        if (dequeDog.isEmpty()) {
            return dequeueCat();
        }
        // 两个dedque均有元素
        if (dequeCat.peek() > dequeDog.peek()) {
            return new int[] { dequeDog.poll(), 1 };
        } else {
            return new int[] { dequeCat.poll(), 0 };
        }

        
    }
    
    public int[] dequeueCat() {
        if (dequeCat.isEmpty()) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { dequeCat.poll(), 0 };
        }
    }
    public int[] dequeueDog() {
        if (dequeDog.isEmpty()) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { dequeDog.poll(), 1 };
        }
    }
}
