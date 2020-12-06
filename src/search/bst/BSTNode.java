package search.bst;

/**
 * 二叉排序树结点
 */
public class BSTNode {
    private BSTNode lChild, rChild;
    private int data;

    public BSTNode(int data) {
        this.data = data;
    }

    public static BSTNode searchBST(BSTNode tree, int key) {
        if (tree == null) {
            return null;
        } else {
            if (tree.data == key) {
                return tree;
            } else if (tree.data < key) {
                return searchBST(tree.rChild, key);
            } else {
                return searchBST(tree.lChild, key);
            }
        }
    }

    static boolean insertBST(BSTNode tree, int key, BSTNode parent) {
        if (tree == null) {
            if (parent.getData() > key) {
                parent.lChild = new BSTNode(key);
            } else {
                parent.rChild = new BSTNode(key);
            }
            return true;
        } else {
            if (tree.data == key) {
                return false;
            } else if (tree.data < key) {
                return insertBST(tree.rChild, key, tree);
            } else {
                return insertBST(tree.lChild, key, tree);
            }
        }
    }

    static boolean deleteBST(BSTNode tree, int key, BSTNode parent) {
        if (tree == null) {
            return false;
        } else {
            if (tree.data == key) {
                return delete(tree, key, parent);
            } else if (tree.data < key) {
                return deleteBST(tree.rChild, key, tree);
            } else {
                return deleteBST(tree.lChild, key, tree);
            }
        }
    }

    private static boolean delete(BSTNode tree, int key, BSTNode parent) {
        if (tree.lChild == null) {
            if (parent.lChild == tree) {
                parent.lChild = tree.rChild;
            } else {
                parent.rChild = tree.rChild;
            }
        } else if (tree.rChild == null) {
            if (parent.lChild == tree) {
                parent.lChild = tree.lChild;
            } else {
                parent.rChild = tree.lChild;
            }
        } else {
            BSTNode node = tree.lChild;
            while (node.rChild != null) {
                node = node.rChild;
            }
            tree.lChild.rChild = node.lChild;
            if (node != tree.lChild) {
                node.lChild = tree.lChild;
            }
            node.rChild = tree.rChild;
            if (parent.lChild == tree) {
                parent.lChild = node;
            } else {
                parent.rChild = node;
            }
        }
        return true;
    }

    public static BSTNode createBST() {
        //这里默认构造一个 二叉排序树 方便使用
        BSTNode root = new BSTNode(62);
        root.lChild = new BSTNode(58);
        root.lChild.lChild = new BSTNode(47);
        root.lChild.lChild.lChild = new BSTNode(35);
        root.lChild.lChild.lChild.rChild = new BSTNode(37);
        root.lChild.lChild.rChild = new BSTNode(51);
        root.rChild = new BSTNode(88);
        root.rChild.lChild = new BSTNode(73);
        root.rChild.rChild = new BSTNode(99);
        root.rChild.rChild.lChild = new BSTNode(93);
        return root;
    }

    public static void printBST(BSTNode node) {
        if (node.lChild != null) {
            printBST(node.lChild);
        }
        System.out.println(node.data);
        if (node.rChild != null) {
            printBST(node.rChild);
        }
    }

    public BSTNode getlChild() {
        return lChild;
    }

    public void setlChild(BSTNode lChild) {
        this.lChild = lChild;
    }

    public BSTNode getrChild() {
        return rChild;
    }

    public void setrChild(BSTNode rChild) {
        this.rChild = rChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
