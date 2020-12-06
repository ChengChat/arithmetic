package offer.base.question06;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Main {

    public static void main(String[] args) {
        List<Character> list = new LinkedList<Character>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        printLinkedListByStack(list);

        ListNode header = new ListNode('A');
        ListNode node2 = new ListNode('B');
        ListNode node3 = new ListNode('C');
        ListNode node4 = new ListNode('D');
        header.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        printLinkedListByRecursive(header);

    }

    private static void printLinkedListByRecursive(ListNode header) {
        if (header.getNext() != null) {
            printLinkedListByRecursive(header.getNext());
            System.out.println(header.getValue());
        }
    }

    private static void printLinkedListByStack(List<Character> list) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
