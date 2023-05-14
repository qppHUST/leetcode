package mar_14_2023;

import java.util.Scanner;

/**
 * ClassName: Main
 * PackageName:mar_14_2023
 * Description:
 * date: 2023/3/18 11:10
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class Main {
    public static void main(String[] args) {
        String[] chars = new Scanner(System.in).nextLine().split("");
        boolean isOk = true;
        int index = 0;
        int len = chars.length;
        while (index < len/2){
            String char1 = chars[index];
            String char2 = chars[len - index-1];
            if (!char1.equals(char2)){
                isOk = false;
                break;
            }
            index++;
        }
        if (isOk) {
            for (int i = 0; i < len; i++) {
                if (!"a".equals(chars[i])) {
                    chars[i] = "a";
                    chars[len - i-1] = "a";
                    break;
                }
            }
        }else {
            chars[index] = "a";
            chars[len-index-1] = "a";
        }
        StringBuilder sb = new StringBuilder();
        for (String aChar : chars) {
            sb.append(aChar);
        }
        System.out.println(sb.toString());
    }
}
