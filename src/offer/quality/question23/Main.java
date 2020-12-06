package offer.quality.question23;

import offer.quality.question18.ListNode;

/**
 * 面试题23：链表中环的入口结点
 * 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * 环的入口结点是结点30。
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
        node6.setNext(node3);
        ListNode node = ingressNodeOfLoop(header);
        if (node == null) {
            System.out.println("没有环");
        } else {
            System.out.println(node.getValue());
        }
    }

    private static ListNode ingressNodeOfLoop(ListNode header) {
        if (header == null) {
            return null;
        }
        ListNode pSlow = header.getNext();
        if (pSlow == null) {
            return null;
        }
        ListNode pFast = pSlow.getNext();
        while (pFast != null && pSlow != null) {
            if (pSlow == pFast) {
                pFast = header;
                while (pFast != pSlow) {
                    pSlow = pSlow.getNext();
                    pFast = pFast.getNext();
                }
                return pFast;
            }
            pSlow = pSlow.getNext();
            pFast = pFast.getNext();
            if (pFast != null) {
                pFast = pFast.getNext();
            }
        }
        return null;
    }
}
