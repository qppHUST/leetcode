package jan_2_2023;

/**
 * ClassName: No2648
 * PackageName:jan_2_2023
 * Description:
 * date: 2023/1/2 13:57
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No2648 {
    public static int search(int[] nums, int target) {
        int index = findAny(nums,target);
        if (index == -1){
            return 0;
        }
        int[] border = findBorder(nums,index);
        return border[1]-border[0]+1;
    }

    private static int[] findBorder(int[] nums, int index) {
        int left = index,right = index;
        int target = nums[index];
        while (true){
            if(nums[right] == target){
                right++;
                if(right  == nums.length){
                    right--;
                    break;
                }
            }else {
                right--;
                break;
            }
        }
        while (true){
            if(nums[left] == target){
                left--;
                if(left == -1){
                    left ++;
                    break;
                }
            }else {
                left++;
                break;
            }
        }
        return new int[]{left,right};
    }

    private static int findAny(int[] nums, int target) {
        int i  = 0;
        int j = nums.length-1;
        int mid = 0;
        while(i<=j){
            if(i == j-1){
                if(nums[i] == target){
                    return i;
                }else if(nums[j] == target){
                    return j;
                }
                return -1;
            }
            mid = (i+j)/2;
            if(i == j){
                if(nums[i] == target){
                    return i;
                }
                return -1;
            }
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                j = mid;
            }else {
                i = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1};
        int search = search(ints, 0);
        System.out.println(search);
    }
}
