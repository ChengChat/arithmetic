package classice.question05;

public class Main {
    /*获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组*/
    public static void main(String[] args) {
        int[] arr = {175, 179, 174, 163, 176, 177};
        int[] ints = DistanceToHigher(arr);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] DistanceToHigher(int[] height) {
        // write code here
        if (height == null || height.length == 0) {
            return null;
        }
        int[] arr = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            int j = i;
            for (; j >= 0; j--) {
                if (height[i] < height[j]) {
                    arr[i] = i - j;
                    break;
                }
            }
            if (j < 0) {
                arr[i] = 0;
            }
        }
        return arr;
    }
}
