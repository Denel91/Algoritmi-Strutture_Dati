package Make_Union_Find;

/**
 * Struttura dati per insiemi disgiunti
 *
 * * Class overview:
 * makeSet(int val) : LinkedList
 * findSet(Node x) : int
 * union(LinkedList x, LinkedList y) : LinkedList
 *
 * @version 19/11/2021
 */
public class DisjointSets {

    static class Node {
        private int value;
        private Node next;
        private LinkedList set;

        public Node(int value) {
            this.value = value;
            this.set = new LinkedList();
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public LinkedList getSet() {
            return set;
        }

        public Node getNext() {
            return next;
        }
    }

    static class LinkedList {
        private Node head;
        private Node tail;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public void view() {
            if (this.head == null) {
                System.out.println("Empty linked list");
                return;
            }

            Node temp = this.head;
            while (temp != null) {
                System.out.print("" + temp.value + " --> ");
                temp = temp.next;
            }

            System.out.print("NULL\n");
        }
    }

    public LinkedList makeSet(int val) {
        Node x = new Node(val);
        LinkedList list = new LinkedList();
        list.head = x;
        list.tail = x;
        x.set = list;
        x.next = null;
        return list;
    }

    public int findSet(Node x) {
        return x.set.getHead().getValue();
    }

    public LinkedList union(LinkedList x, LinkedList y) {
        LinkedList L1 = x;
        LinkedList L2 = y;
        L1.tail.next = L2.getHead();

        Node z = L2.getHead();
        while (z.getNext() != null) {
            z.set = L1;
            z = z.getNext();
        }

        L1.setTail(L2.getTail());
        L2.setHead(L1.getHead());
        return L1;
    }

    public static void main(String[] args) {
        DisjointSets sets = new DisjointSets();
        LinkedList a = sets.makeSet(2);
        LinkedList b = sets.makeSet(4);
        LinkedList c = sets.makeSet(6);
        LinkedList lista = sets.union(a, b);
        LinkedList lista_2 = sets.union(lista, c);
        lista_2.view();
        int W = sets.findSet(lista.head.next.next);
        System.out.println(W);
    }
}
