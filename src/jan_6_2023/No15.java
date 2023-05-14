package jan_6_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * ClassName: No15
 * PackageName:jan_6_2023
 * Description:
 * date: 2023/1/6 16:21
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int negativeIndex = 0;
        int zeroNum = 0;
        int positiveIndex = nums.length-1;
        int twoSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i!=nums.length-1 && nums[i]<0 && nums[i+1] >=0){
                negativeIndex = i;
            }
            if(i != 0 && nums[i-1]<=0 && nums[i] > 0){
                positiveIndex = i;
                break;
            }
        }
        zeroNum = positiveIndex - negativeIndex -1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < negativeIndex; i++) {
            if(i != 0 &&nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j <= negativeIndex; j++) {
                twoSum = nums[i]+nums[j];
                for (int k = positiveIndex; k <=nums.length-1; k++) {
                    if(nums[k] + twoSum == 0 && k!= i && k != j){
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        ans.add(item);
                    }
                }
            }
        }
        for (int i = positiveIndex; i < nums.length-1; i++) {
            for (int j = i+1; j <= nums.length-1; j++) {
                twoSum = nums[i]+nums[j];
                for (int k = 0; k <=negativeIndex; k++) {
                    if(nums[k] + twoSum == 0 && k!= i && k != j){
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        ans.add(item);
                    }
                }
            }
        }
        if(zeroNum > 0){
            TreeSet<Integer> negatives = new TreeSet<>();
            TreeSet<Integer> positives = new TreeSet<>();
            for (int i = 0; i <= negativeIndex; i++) {
                negatives.add(nums[i]);
            }
            for (int i = positiveIndex; i <nums.length; i++) {
                positives.add(nums[i]);
            }
            for (Integer negative : negatives) {
                for (Integer positive : positives) {
                    if(negative +positive == 0){
                        List<Integer> item = new ArrayList<>();
                        item.add(negative);
                        item.add(positive);
                        item.add(0);
                        ans.add(item);
                    }
                }
            }
        }
        if(zeroNum >= 3){
            List<Integer> item = new ArrayList<>();
            item.add(0);
            item.add(0);
            item.add(0);
            ans.add(item);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data1 = {-1, 0, 1, 2, -1, -4};
        int[] data2 = {0,0,0};
        int[] data3 = {0,0,0,0};
        int[] data4 = {-2,0,0,2,2};
        int[] data5 = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(data5);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
