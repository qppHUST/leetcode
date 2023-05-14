package feb_10_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: No31
 * PackageName:feb_10_2023
 * Description:
 * date: 2023/2/10 21:10
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No31 {
    public void nextPermutation(int[] nums) {
        int last = nums.length-1;
        int index = nums.length-2;
        while (index>0){
            int[] fullArrangement = getList(index,last,nums);
        }
    }

    private int[] getList(int begin, int last, int[] nums) {
        List<String> previous = new ArrayList<>();
        String now = "";
        for (int i = begin; i <=last; i++) {
            previous.add(i+"");
        }
        List<String> indexFullArrangement = recursion(begin, last, 0, previous, previous);

        return nums;
    }

    private List<String> recursion(int begin, int last, int flag, List<String> previous,List<String> data) {
        if(flag == last-begin){
            return previous;
        }
        List<String> newList = new ArrayList<>();
        for (String datum : data) {
            for (String s : previous) {
                if(s.indexOf(datum) != -1){
                    continue;
                }
                for (int i = 0; i <= s.length(); i++) {
                    String ahead = s.substring(0, i);
                    String behind = s.substring(i);
                    String item = ahead + datum + behind;
                    newList.add(item);
                }
            }
        }
        previous = newList;
        return recursion(begin, last, flag+1, previous, data);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        ArrayList<String> data  = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(ints[i]+"");
        }
        List<String> recursion = new No31().recursion(0, 2, 0, data, data).stream().distinct().sorted().toList();
        for (String s : recursion) {
            System.out.println(s);
        }
    }
}
