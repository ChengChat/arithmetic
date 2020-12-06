package offer.base.question12;

public class Main1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {'A', 'B', 'T', 'g'},
                {'C', 'F', 'C', 'S'},
                {'J', 'D', 'E', 'H'}
        };
        boolean b = hasPath(matrix, "BFCE".toCharArray());
        System.out.println(b);
    }

    private static boolean hasPath(int[][] matrix, char[] toCharArray) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0
                || toCharArray == null || toCharArray.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, row, col, toCharArray, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(int[][] matrix, int row, int col, char[] str, int pStr, boolean[][] visited) {
        if (pStr == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
                && matrix[row][col] == str[pStr] && !visited[row][col]) {
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, row + 1, col, str, pStr + 1, visited)
                    || hasPathCore(matrix, row - 1, col, str, pStr + 1, visited)
                    || hasPathCore(matrix, row, col + 1, str, pStr + 1, visited)
                    || hasPathCore(matrix, row, col - 1, str, pStr + 1, visited);
            if (!hasPath) {
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}