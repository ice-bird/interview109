package fish.dp;
// 三步问题
// 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

public class Inter0801 {
    // 经典的dp问题
    // f(n)=f(n-1)+f(n-2)+f(n-3)
    // 而且可以省略dp[]
    public int waysToStep(int n) {
        if (n == 1) return 1;
        if(n==2) return 2;
        int dp1 = 1, dp2 = 2,dp3=4;
        // int[] dp =new int[4]
        int dp4 = 4;
        for (int i = 3; i < n; i++) {

            dp4 = ((dp1 + dp2) % 1000000007 + dp3) % 1000000007;
            // 这里结果每一步都要验证结果是否越界
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
        }
        return dp4;
    }
}
