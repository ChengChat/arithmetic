package offer.quality.question25;

import offer.quality.question18.ListNode;

/**
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
 * 表3所示。
 */
public class Main {

    public static void main(String[] args) {
        ListNode headerA = new ListNode('1');
        ListNode node2 = new ListNode('3');
        ListNode node3 = new ListNode('5');
        ListNode node4 = new ListNode('7');
        ListNode headerB = new ListNode('2');
        ListNode node6 = new ListNode('4');
        ListNode node7 = new ListNode('6');
        ListNode node8 = new ListNode('8');
        headerA.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        headerB.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        ListNode mergedHeader1 = mergeByRecursive(headerA, headerB);
        ListNode mergedHeader2 = merge(headerA, headerB);
        ListNode.print(mergedHeader1);
        System.out.println();
        ListNode.print(mergedHeader2);
    }

    private static ListNode merge(ListNode headerA, ListNode headerB) {
        ListNode mergedHeader = null;
        ListNode node = null;
        while (headerA != null && headerB != null) {
            if (headerA.value < headerB.value) {
                if (mergedHeader == null) {
                    mergedHeader = headerA;
                }
                node = headerA;
                headerA = headerA.next;
            } else {
                if (mergedHeader == null) {
                    mergedHeader = headerB;
                }
                node = headerB;
                headerB = headerB.next;
            }
            node = node.next;
        }
        if (headerA != null) {
            node = headerA;
        }
        if (headerB != null) {
            node = headerB;
        }
        return mergedHeader;
    }

    private static ListNode mergeByRecursive(ListNode headerA, ListNode headerB) {

        if (headerA == null) {
            return headerB;
        }
        if (headerB == null) {
            return headerA;
        }

        ListNode mergedHeader = null;
        if (headerA.value < headerB.value) {
            mergedHeader = headerA;
            mergedHeader.next = mergeByRecursive(headerA.next, headerB);
        } else {
            mergedHeader = headerB;
            mergedHeader.next = mergeByRecursive(headerA, headerB.next);
        }
        return mergedHeader;
    }
}
