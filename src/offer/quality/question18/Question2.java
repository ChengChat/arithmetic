package offer.quality.question18;
/**
 *  面试题18（二）：删除链表中重复的结点
 *  题目：在一个排序的链表中，如何删除重复的结点？
 */
public class Question2 {
    public static void removeDuplication(ListNode header) {
        if(header ==null){
            return;
        }
        ListNode node = header;
        ListNode preNode = null;

        while (node != null){
            ListNode next = node.getNext();
            if(next != null && next.getValue() == node.getValue()){
                Character value = next.getValue();
                next = next.getNext();
                while (next != null && next.getValue() == value){
                    next = next.getNext();
                }
                if(preNode == null){
                    if(next == null){
                        header.setValue(null);
                        header.setNext(null);
                    }else {
                        header.setNext(next.getNext());
                        header.setValue(next.getValue());
                    }
                }else{
                    preNode.setNext(next);
                }
                node = next;
            }else {
                preNode = node;
                node = next;
            }
        }
    }
}
