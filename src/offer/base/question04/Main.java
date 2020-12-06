package offer.base.question04;

/**
 * 二维数组中的查找:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean isHave = find(matrix, 7);
        System.out.println(isHave);
    }

    private static boolean find(int[][] matrix, int i) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int row = 0;
            int column = matrix.length - 1;
            while (column >= 0 && row < matrix[column].length) {
                if (matrix[column][row] > i) {
                    column--;
                } else if (matrix[column][row] < i) {
                    row++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
