package offer.base.question12;

/**
 * 面试题12：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * <p>
 * 例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下划线标出）。
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * A B T G
 * C F C S
 * J D E H
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {'A', 'B', 'T', 'g'},
                {'C', 'F', 'C', 'S'},
                {'J', 'D', 'E', 'H'}
        };
        boolean b = hasPath(matrix, "BFCE".toCharArray());
        System.out.println(b);
    }

    private static boolean hasPath(int[][] matrix, char[] str) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int pathLength = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(int[][] matrix, int row, int col, char[] str, int pathLength, boolean[][] visited) {
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
                && matrix[row][col] == str[pathLength] && !visited[row][col]) {
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, row + 1, col, str, pathLength + 1, visited)
                    || hasPathCore(matrix, row - 1, col, str, pathLength + 1, visited)
                    || hasPathCore(matrix, row, col + 1, str, pathLength + 1, visited)
                    || hasPathCore(matrix, row, col - 1, str, pathLength + 1, visited);

            if (!hasPath) {
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
