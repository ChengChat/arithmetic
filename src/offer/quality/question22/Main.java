package offer.quality.question22;

import offer.quality.question18.ListNode;

/**
 * 面试题22：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 */
public class Main {

    public static void main(String[] args) {
        ListNode header = new ListNode('A');
        ListNode node2 = new ListNode('B');
        ListNode node3 = new ListNode('C');
        ListNode node4 = new ListNode('D');
        ListNode node5 = new ListNode('E');
        ListNode node6 = new ListNode('F');
        header.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        ListNode node = findKthToTail(header, 6);
        if (node != null) {
            System.out.println(node.getValue());
        }else{
            System.out.println("输入数据有误");
        }
    }

    private static ListNode findKthToTail(ListNode header, int k) {
        if (header == null || k <= 0) {
            return null;
        }
        ListNode aheadNode = header;
        ListNode behindNode = header;
        for (int i = 0; i < k - 1; i++) {
            if (aheadNode.getNext() != null) {
                aheadNode = aheadNode.getNext();
            } else {
                return null;
            }
        }
        while (aheadNode.getNext() != null) {
            aheadNode = aheadNode.getNext();
            behindNode = behindNode.getNext();
        }
        return behindNode;
    }
}
