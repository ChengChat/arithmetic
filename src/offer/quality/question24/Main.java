package offer.quality.question24;

import offer.quality.question18.ListNode;

/**
 * 面试题24：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
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

        ListNode pReverseHead = reverseList(header);
        ListNode.print(pReverseHead);
    }

    private static ListNode reverseList(ListNode header) {
        ListNode pReverseHead = null;
        ListNode pNode = header;
        ListNode pPrev = null;
        while (pNode != null){
            ListNode pNext = pNode.getNext();
            if(pNext == null){
                pReverseHead = pNode;
            }
            pNode.setNext(pPrev);

            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }
}
