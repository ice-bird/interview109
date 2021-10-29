package fish.math;
// 交换数字
// 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
public class Inter1601 {
    public int[] swapNumbers(int[] numbers) {
        // 不用临时变量，提示用位运算
        // [a,b] --> [a+b,a-b] 方程组必有解
        // 相当于换了一种编码方式，那我完全可以 变为[a,a-b] 不一样吗？
        // 然后要把第一个变为b a-(a-b)即可，然后要把a-b变为a a-b+b(此时b已经是第0位的数了)
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[1] + numbers[0];
        return numbers;
    }
    public static void main(String[] args) {
        int[] numbers = new int[] {0,2147483647};
        Inter1601 test = new Inter1601();
        test.swapNumbers(numbers);
    }
}
