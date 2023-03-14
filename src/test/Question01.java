package test;

/**
 * @param list1 有序链表1
 * @param list2 有序链表2
 * @return 合并后的有序链表
 * static class Node {
 *   int value;
 *   Node next;
 * }
 * */
public class Question01 {

    public static void main(String[] args) {

    }

    public static Node mergeList(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        Node header = new Node();
        Node curNode = header;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                curNode = list1;
                list1 = list1.next;
            } else {
                curNode = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        if (list1 != null) {
            curNode.next = list1.next;
        }
        if (list2 != null) {
            curNode.next = list2.next;
        }
        return header;
    }

    static class Node {
        int value;
        Node next;
    }


}


