package jan_2_2023;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: No2598
 * PackageName:jan_2_2023
 * Description:
 * date: 2023/1/2 13:51
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2598 {

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
