import java.util.Scanner;

/**
 * ClassName: FreeDemo
 * PackageName:PACKAGE_NAME
 * Description:
 * date: 2023/4/4 19:33
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class FreeDemo {

    public static void main(String[] args) {
        System.out.println(new FreeDemo().fuc("pwwkew"));
    }

    int fuc(String str){
        int cursor1 = 0;
        int cursor2 = 1;
        int max = 1;
        while (cursor2 < str.length()){
            char c = str.charAt(cursor2);
            String substring = str.substring(cursor1, cursor2);
            if(substring.indexOf(c) != -1){
                cursor1++;
                continue;
            }
            int num = substring.length() + 1;
            max = Math.max(num, max);
            cursor2++;
        }
        return max;
    }
}
