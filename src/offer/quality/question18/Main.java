package offer.quality.question18;

/**
 *  面试题18（一）：在O(1)时间删除链表结点
 *
 *  面试题18（二）：删除链表中重复的结点
 */
public class Main {
    public static void main(String[] args) {
        ListNode header = new ListNode('A');
        ListNode node2 = new ListNode('B');
        ListNode node3 = new ListNode('C');
        ListNode node4 = new ListNode('C');
        ListNode node5 = new ListNode('E');
        ListNode node6 = new ListNode('F');
        ListNode node7 = new ListNode('F');
        header.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
//        node6.setNext(node7);

        Question1.removeNode(header,node7);
        ListNode.print(header);
        System.out.println();
        Question2.removeDuplication(header);
        ListNode.print(header);
    }


}
