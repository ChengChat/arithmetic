package search.bst;

import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) {
        BSTNode root = BSTNode.createBST();
        BSTNode.printBST(root);
 /*       BSTNode b = BSTNode.searchBST(root, 93);
        System.out.println(b.getData());
        System.out.println("------------------");
        System.out.println(BSTNode.insertBST(root, 45,null));
        BSTNode.printBST(root);
        System.out.println("------------------");*/

        System.out.println(BSTNode.deleteBST(root,99,null));
        BSTNode.printBST(root);
    }
}
