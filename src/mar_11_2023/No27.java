package mar_11_2023;

import dec_30_2022.No2;

/**
 * ClassName: No27
 * PackageName:mar_11_2023
 * Description:
 * date: 2023/3/11 18:42
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No27 {
    public int removeElement(int[] nums, int val) {
        int ans = nums.length;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                for (int j = i; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                len--;
                ans--;
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 2, 3};
        int i = new No27().removeElement(ints, 3);
        System.out.println(i);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
