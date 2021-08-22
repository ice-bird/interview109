package fish;
// 面试题 01.09. 字符串轮转

// 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）

// 思路：s1的第一个字符，去匹配s2的相同字符，然后不断增加长度比较是否相等
// 如果不等，则继续遍历s2，直到找不到相同的起始字符
// 本质上是双指针

// 方法2：拼接s1+s2 
public class Inter0109 {
    public boolean isFlipedString(String s1, String s2) {
        // 肯定先判断长度是否相等
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s2 + s2;
        // s2 首尾相连 1--4 5--8    -> 5--8 1--4 + 5--8 1--4
        return s.contains(s1);
        // string操作的重要方法：substring(起点，终点) .toCharArray()转为char[]
        // contains()是否包含
        

    }

    
}
