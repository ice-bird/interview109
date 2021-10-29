package fish.bit;
// 二进制数转字符串
// 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”

public class Inter0502 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder(33); //先定义32长度是好习惯
        sb.append("0.");
        while (num != 0) {
            num = num * 2;
            sb.append(num >= 1 ? 1 : 0);
            if (num >= 1) {
                num = num - 1;
            }
            if (sb.length() > 32) {
                return "ERROR";
            }
        }
        return sb.toString();
    }
}
