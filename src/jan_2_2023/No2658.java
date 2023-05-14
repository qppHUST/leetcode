package jan_2_2023;

/**
 * ClassName: No2658
 * PackageName:jan_2_2023
 * Description:
 * date: 2023/1/2 13:46
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2658 {

    public String reverseLeftWords(String s, int n) {
        String substring = s.substring(n, s.length());
        String substring1 = s.substring(0, n);
        return substring+substring1;
    }

    public static void main(String[] args) {

    }
}
