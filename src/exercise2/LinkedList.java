package exercise2;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            while (nextNode != null && nextNode.data == current.data) {
                nextNode = nextNode.next;
            }
            current.next = nextNode;
            current = nextNode;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(60);
        list.push(43);
        list.push(43);
        list.push(21);
        list.push(11);
        list.push(11);
        list.push(11);

        System.out.println("Liste avant la suppression des doublons : ");
        list.printList();

        list.removeDuplicates();

        System.out.println("Liste après la suppression des doublons : ");
        list.printList();
    }
}
