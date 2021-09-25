package fish.string;

import java.util.Arrays;
import java.util.HashMap;

// 面试宝典 02 判定是否互为字符重排
public class Inter02 {
    // 方法1：set存，然后set删，一旦不存在则返回，最后判断是否还剩余


    // 方法2：如果知道字符集，则可以用数组代替

    // 方法3：是否可以位运算？貌似不行
    public boolean checkpermutation(String s1, String s2) {
        // 校验合法
        // if (s1.equals(s2)) {
        //     return true;
        // }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count = map.getOrDefault(s1.charAt(i), 0);
            map.put(s1.charAt(i), count + 1);

        }

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(s2.charAt(i))) {
                // 不存在
                return false;
            }
            // 已存在
            int count1 = map.get(s2.charAt(i));
            if (count1 <= 0) {
                // 存在，但已经数量减到<=0了
                return false;
            }
            map.put(s2.charAt(i), count1 - 1);
        }

        // 判断map中是否有数量不为0的
        // 理论上不需要判断，因为数量相同，而没有多余的不存在的，则必然-1
        return true;
    }
    
    // 内存太多
    // 改为数组 - - 测试一下可以省多少 
    // 方法1：36.3M 方法2 35.8  时空复杂度 O(N)
    public boolean checkpermutation01(String s1, String s2) {
        // 校验合法
        // if (s1.equals(s2)) {
        //     return true;
        // }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] countList = new int[26];
        for (int i = 0; i < len; i++) {
            countList[s1.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < len; i++) {
            countList[s2.charAt(i) - 'a'] -= 1;
        }
        for (int i : countList) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    // 方法3：先排序，再比较是否相等
    // 复杂度分析：快速排序NlogN
    public boolean CheckPermutation(String s1, String s2) {
        // 将字符串转换成字符数组
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        // 再将字符数组转换成字符串，比较是否相等
        // 用char[] 构造String对象
        return new String(s1Chars).equals(new String(s2Chars));
    }

        
}
