package offer.thinking.question35;

public class LinkedList {
    LinkedList next;
    LinkedList sibling;
    Character value;

    public static void print(LinkedList node){
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }

    }
    public LinkedList(Character value) {
        this.value = value;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList getSibling() {
        return sibling;
    }

    public void setSibling(LinkedList sibling) {
        this.sibling = sibling;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }
}
