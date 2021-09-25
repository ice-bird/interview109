package fish.string;

import java.util.HashSet;
import java.util.Set;

// 判断string是否是回文排列
// 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。回文串不一定是字典当中的单词
// 
public class Inter0104 {
    public boolean canPermutePalindrome(String s) {
        // 条件分析：字母个数是偶数呗
        // 若String只有字母，则可以用数组，否则用集合
        // 可以用set存，第一次存，第二次删，判断最后是否为空,
        // 另外的情况，只剩一个元素 如aab
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size() == 1 || set.size() == 0;
    }
    
    // 用int[128]存这些字符的数量

    // 或者用Inter0101的位表示 128位即4个int
}