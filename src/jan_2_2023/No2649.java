package jan_2_2023;

/**
 * ClassName: No2649
 * PackageName:jan_2_2023
 * Description:
 * date: 2023/1/2 14:27
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2649 {
    public static int missingNumber(int[] nums) {
        int i = 0,j = nums.length-1;
        if(nums.length == 1){
            if(nums[0] == 0){
                return 1;
            }
            return 0;
        }
        if(nums.length == 2){
            if(nums[0] == 0 && nums[1] == 1){
                return 2;
            }
            if(nums[0] == 1 && nums[1] == 2){
                return 0;
            }if(nums[0] == 0 && nums[1] == 2){
                return 1;
            }
        }
        while (i<=j){
            if(i == j){
                break;
            }
            int nextI = i+1;
            int nextJ = j-1;
            if(nums[nextI] != nums[i]+1){
                return   nums[i]+1;
            }
            if(nums[nextJ] != nums[j]-1){
                return   nums[j]-1;
            }
            i = nextI;
            j = nextJ;
        }
        if(nums[0] == 0){
            return nums[nums.length-1]+1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 2};
        System.out.println(missingNumber(ints));
    }
}
