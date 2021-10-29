package fish.math;
// 四个颜色 RYGB 猜中与伪猜中（颜色对，但位置不对）

public class Inter1615 {
    public int[] masterMind(String solution, String guess) {
        // 猜中for循环即可
        int[] res=new int[2];
        for (int i = 0; i < solution.length(); i++) {
            char c1=solution.charAt(i);
            char c2=solution.charAt(i);
            if (c1 == c2) {
                res[0]++;
            }
            
            // 记录下频数，然后伪猜中= min(较小频数) 之和

        }

        // 伪猜中：solution的每个字母的次数，然后对比guess中有几次
        // 需要建一个数组，二维更形象，但一维也行
        int[][] fre = new int[4][2];
        return res;
    }
}
