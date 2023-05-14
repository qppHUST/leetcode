package jan_6_2023;

/**
 * ClassName: No11
 * PackageName:jan_6_2023
 * Description:
 * date: 2023/1/6 15:45
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No11 {

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int ans = 0;
        while (i <j){
            int gao = height[i]<=height[j]? height[i] : height[j];
            int helper = (j-i)*gao;
            ans = helper > ans? helper :ans;
            if(height[i] <height[j]){
                i++;
            }else if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(ints));
    }
}
