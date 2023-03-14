package offer.base.question07.t20230307;

/**
 * @author chengwei
 * @since 2023/3/7 11:30
 */
public class Main {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode2 header = rebuild(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
        BinaryTreeNode2.afterPrint(header);
    }

    private static BinaryTreeNode2 rebuild(int[] preOrder, int[] inOrder, int preLeftIndex, int preRightIndex, int inLeftIndex, int inRightIndex) {
        int rootValue = preOrder[preLeftIndex];
        int rootIndex = inLeftIndex;
        BinaryTreeNode2 header = new BinaryTreeNode2(rootValue);
        while (rootIndex <= inRightIndex && inOrder[rootIndex] != rootValue) {
            rootIndex++;
        }
        if (rootIndex != inLeftIndex) {
            header.setpLeft(rebuild(preOrder, inOrder, preLeftIndex + 1, (rootIndex - inLeftIndex) + preLeftIndex, inLeftIndex, rootIndex - 1));
        }
        if (rootIndex != inRightIndex) {
            header.setpRight(rebuild(preOrder, inOrder, (rootIndex - inLeftIndex) + preLeftIndex + 1, preRightIndex, rootIndex + 1, inRightIndex));
        }
        return header;
    }
}
