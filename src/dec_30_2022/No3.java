package dec_30_2022;

/**
 * ClassName: No3
 * PackageName:oct_30_2022
 * Description: 原题地址: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 * date: 2022/12/30 15:18
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int i = 0,j = -1;
        int maxLen = 0;
        while(true){
            j++;
            int index = s.indexOf(s.charAt(j),i);
            if(index >=i && index <j){
                i = index +1;
            }
            int len = j - i + 1;
            maxLen = len > maxLen ? len : maxLen;
            if(j == s.length()-1){
                break;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
