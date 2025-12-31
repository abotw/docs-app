public class PR2 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("Hello");    // StringBuffer是字符串变量
        if ((s.length() > 5) && (s.append("there").equals("False")))
            ;
        System.out.println("value is " + s);
    }
}