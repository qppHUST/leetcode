package mar_11_2023;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: No49
 * PackageName:mar_11_2023
 * Description:
 * date: 2023/3/11 17:09
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        for (String str : strs) {
            boolean add = false;
            for (List<String> strings : answer) {
                String item = strings.get(0);
                boolean flag = true;
                if (str.length() == item.length()){
                    flag = checkTwo(str,item);
                    if (flag) {
                        strings.add(str);
                        add = true;
                    }
                }
            }
            if (!add){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                answer.add(list);
            }
        }
        return answer;
    }

    private boolean checkTwo(String str, String item) {
        byte[] bytes1 = str.getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = item.getBytes(StandardCharsets.UTF_8);
        Arrays.sort(bytes1);
        Arrays.sort(bytes2);
        for (int i = 0; i < bytes1.length; i++) {
            if (bytes1[i] != bytes2[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //"ddddddddddg","dgggggggggg"
        List<List<String>> lists = new No49().groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"});
        int index = 0;
        for (List<String> list : lists) {
            System.out.println("第"+index+++"个列表");
            for (String s : list) {
                System.out.println(s+ " ");
            }
        }
    }
}
