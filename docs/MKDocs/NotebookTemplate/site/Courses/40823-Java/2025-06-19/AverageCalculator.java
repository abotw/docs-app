import java.util.*;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入整数个数：");
            int n = sc.nextInt();
            if (n <= 0) throw new IllegalArgumentException("数组大小必须为正数！");
            int arr[] = new int[n];
            System.out.println("请输入 " + n + " 个整数：");
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println("平均值为：" + (double) sum / n);
        } catch (InputMismatchException e) {
            System.out.println("输入的不是有效的整数！");
        } catch (IllegalArgumentException e) {
            System.out.println("错误：" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}