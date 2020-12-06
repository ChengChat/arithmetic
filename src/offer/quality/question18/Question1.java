package offer.quality.question18;
/**
 * 面试题18（一）：在O(1)时间删除链表结点
 *  题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 */
public class Question1 {
    public static void removeNode(ListNode header, ListNode node) {
        if(header == null || node == null){
            return;
        }
        if(node.getNext() != null){
            ListNode next = node.getNext();
            node.setValue(next.getValue());
            node.setNext(next.getNext());
        }else if(node == header){
            header.setValue(null);
        }else{
            ListNode listNode = header;
            while (listNode.getNext() != node){
                if(listNode.getNext() == null){
                    System.out.println("链表中没有该节点");
                    return;
                }
                listNode = listNode.getNext();
            }
            listNode.setNext(null);
        }
    }
}
