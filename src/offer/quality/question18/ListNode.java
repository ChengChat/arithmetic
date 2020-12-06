package offer.quality.question18;

/**
 * 链表
 */
public class ListNode {
    public ListNode next;
    public Character value;

    public static void print(ListNode header) {
        while (header != null) {
            System.out.println(header.value);
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
