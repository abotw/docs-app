public class PR5 {
    public static void main(String[] args) {
        int[] array = {5, 0, 20};
        for (int i = 0; i <= array.length; ++i) {
            try {
                int d = 100 / array[i];
                System.out.println("\t 正常：d = " + d);
            } catch (ArithmeticException e) {
                System.out.println("\t 算术异常");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\t 下标越界异常！");
            } finally {
                System.out.println("\t 异常处理结束！\n");
            }
        }
    }
}