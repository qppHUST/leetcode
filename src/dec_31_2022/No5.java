package dec_31_2022;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: No5
 * PackageName:dec_31_2022
 * Description:
 * date: 2022/12/31 10:52
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No5 {
//todo 直接遍历得了
    public static String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        int j = 0;
        String max = "";
        while (j<s.length()){
            char c = s.charAt(j);
            List<Integer> indexList = indexof(s,c,j);
            for (int i : indexList) {
                String substring = s.substring(i, j+1);
                StringBuilder stringBuilder = new StringBuilder(substring);
                String reverse = stringBuilder.reverse().toString();
                if(substring.equals(reverse)){
                    int len = substring.length();
                    max = len >max.length() ? substring:max;
                }
            }
            j++;
        }
        return max.length() == 0? String.valueOf(s.charAt(0)):max;
    }

    private static List<Integer> indexof(String s, char c, int j) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        byte target = (byte) c;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            if(bytes[i] == target){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
















}
