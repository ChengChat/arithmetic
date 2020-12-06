package offer.base.question06;

/**
 * 链表
 */
public class ListNode {
    private ListNode next;
    private Character value;

    public static void print(ListNode header){
        while (header != null){
            System.out.println(header);
            header = header.next;
        }
    }

    public ListNode(Character value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }
}
