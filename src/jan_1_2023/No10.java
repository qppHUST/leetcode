package jan_1_2023;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: No10
 * PackageName:jan_1_2023
 * Description:
 * date: 2023/1/1 9:59
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No10 {

    public boolean isMatch(String s, String p) {
        if(".*".equals(p)){
            return true;
        }
        int index1 = p.indexOf(".");
        int index2 = p.indexOf("*");
        if(index1 == -1 && index2 == -1 && !s.equals(p)){
            return false;
        }
        Map rules = getRules(p);
        return false;
    }

    private static Map getRules(String p) {
        int index = 0;
        HashMap<Character, Integer> rules = new HashMap<>(16);
        while(index < p.length()){
            char item = p.charAt(index);
            char charToSet = 'a';
            int intToSet = 0;
            if(item == '*'){
                index++;
                continue;
            }else if(item == '.'){
                charToSet = '.';
                intToSet = 0;
            }else {
                charToSet = item;
                int nextCharIndex = index +1;
                if(nextCharIndex == p.length()){
                    break;
                }
                char nextChar = p.charAt(nextCharIndex);
                if(nextChar == '*'){
                    intToSet = 2;
                }else {
                    intToSet = 1;
                }
            }
            rules.put(charToSet,intToSet);
            index ++;
        }
        return rules;
    }

    public static void main(String[] args) {
        Map rules = getRules("ab.a*");
        rules.forEach((k,v)->{
            System.out.println("key is "+k+" v is :"+v);
        });
    }
}
