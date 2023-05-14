package apr_14_2023;

/**
 * ClassName: No42
 * PackageName:may_14_2023
 * Description:
 * date: 2023/4/14 15:41
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class No42 {

    public int trap1(int[] height) {
        int leftBorder = -1;
        int rightBorder = -1;
        int index = 0;
        int ans = 0;
        while (index < height.length-1){
            if (height[index] > height[index+1]){
                leftBorder = index;
                break;
            }
            index++;
        }
        index = height.length-1;
        while (index>0){
            if (height[index] > height[index-1]){
                rightBorder = index;
                break;
            }
            index--;
        }
        while (leftBorder <rightBorder-1){
            int tempBorder = leftBorder+1;
            while (tempBorder<rightBorder){
                if (height[tempBorder] > height[tempBorder-1]){
                    break;
                }
                tempBorder++;
            }
            int high = Math.min(height[leftBorder], height[tempBorder]);
            ans = ans + (tempBorder - leftBorder-1)*high;
            leftBorder = tempBorder;
        }
        return ans;
    }

    public int trap(int[] height){
        int beginIndex = 1;
        int leftBorder = -1;
        int rightBorder = -1;
        while (true){
            int sunkenHole = beginIndex;
            while (sunkenHole < height.length-1){
                if (height[sunkenHole]< height[sunkenHole-1] && height[sunkenHole] < height[sunkenHole+1]){
                    break;
                }
                sunkenHole++;
            }
            int level = Math.min(height[sunkenHole-1],height[sunkenHole+1]);
            //临时的Border从大的border两端进行收缩
            while (true){
                //从大往小来
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //            0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1
        System.out.println(new No42().trap(ints));
    }
}
