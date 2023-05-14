package dec_30_2022;

/**
 * ClassName: No4
 * PackageName:oct_30_2022
 * Description:
 * date: 2022/12/30 19:26
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No4 {
    public static void main(String[] args) {
        int[] intsA = new int[]{1,2};
        int[] intsB = {3, 4};
        System.out.println("中位数是 "+findMedianSortedArrays(intsA, intsB));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0,j = 0,k = 0;
        int[] all = new int[len1 + len2];
        while (i < len1 || j < len2){
            int num1 = Integer.MAX_VALUE,num2 = Integer.MAX_VALUE;
            if(i < len1){
                num1 = nums1[i];
            }
            if(j < len2){
                num2 = nums2[j];
            }
            //todo :找到小的用小的
            int itemToSet = 0;
            if(num1 <= num2){
                itemToSet = num1;
                i++;
            }else {
                itemToSet = num2;
                j++;
            }
            all[k++] = itemToSet;
        }
        for (int i1 : all) {
            System.out.print(i1 + " ");
        }
        int lenSum = len1 + len2;
        double answer = 0.0;
        if(lenSum % 2 == 0){
            //1,2,3,4
            answer = ((double) all[lenSum/2]+(double) all[(lenSum/2) - 1])/2.0;
        }else {
            //1,2,3,4,5
            answer = all[(lenSum-1)/2];
        }
        return answer;
    }
}
