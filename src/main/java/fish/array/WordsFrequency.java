package fish.array;
// 面试题 16.02. 单词频率
// 设计一个方法，找出任意指定单词在一本书中的出现频率。

import java.util.HashMap;

// 你的实现应该支持如下操作：

// WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
// get(word)查询指定单词在书中出现的频率

public class WordsFrequency {
    // String[] book;
    HashMap<String, Integer> freMap=new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String str : book) {
            int fre = freMap.getOrDefault(str, 0);
            freMap.put(str, fre + 1);
        }
    }
    // 应该还有一个添加单词的类，每次添加单词，都需要修改book和freMap

    public int get(String word){
        // 从数组中查找一个单词的频率
        // O(N)?
        // 能否有序插入？
        // 能否构造的时候创建一个hash表
        // 如果没有则返回默认值0，直接get可能空指针异常
        return freMap.getOrDefault(word,0);
    }
}
