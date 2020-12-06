package offer.thinking.question35;

/**
 * 面试题35：复杂链表的复制
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
 * 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
public class Main {
    public static void main(String[] args) {
        LinkedList header = new LinkedList('A');
        LinkedList node2 = new LinkedList('B');
        LinkedList node3 = new LinkedList('C');
        LinkedList node4 = new LinkedList('D');
        LinkedList node5 = new LinkedList('E');
        header.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        header.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        LinkedList cloneHeader = clone(header);
        LinkedList.print(header);
        LinkedList.print(cloneHeader);

    }

    private static LinkedList clone(LinkedList header) {
        if (header == null) {
            return null;
        }
        cloneNodes(header);
        connectSiblingNodes(header);
        return reconnectNodes(header);
    }

    private static void cloneNodes(LinkedList header) {
        LinkedList node = header;
        while (node != null) {
            LinkedList cloneNode = new LinkedList(node.value);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private static void connectSiblingNodes(LinkedList header) {
        LinkedList node = header;
        while (node != null) {
            LinkedList cloneNode = node.next;
            if (node.sibling != null) {
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }
    }

    private static LinkedList reconnectNodes(LinkedList header) {
        LinkedList node = header;
        LinkedList cloneHeader = node.next;
        LinkedList cloneNode = node.next;

        while (node != null) {
            node.next = cloneNode.next;
            node = node.next;
            if(node != null){
                cloneNode.next = node.next;
                cloneNode = cloneNode.next;
            }
        }
        return cloneHeader;
    }
}
