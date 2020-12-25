package Binary_Search_Tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        Node root = new Node(12);
        root.addLeft(new Node(5));
        root.addRight(new Node(18));
        root.left.addLeft(new Node(2));
        root.left.addRight(new Node(9));
        root.right.addLeft(new Node(15));
        root.right.addRight(new Node(19));
        root.right.left.addRight(new Node(17));

        Node z = new Node(13);
        BinarySearchTree tree = new BinarySearchTree(root);
        tree.treeInsert(z);
        tree.preorderPrint(root); // 12 5 2 9 18 15 13 17 19

        System.out.println();

        Node root1 = new Node(50);
        root1.addLeft(new Node(25));
        root1.addRight(new Node(60));
        root1.left.addLeft(new Node(5));
        root1.left.addRight(new Node(40));
        root1.right.addLeft(new Node(55));
        root1.right.addRight(new Node(70));

        BinarySearchTree tree1 = new BinarySearchTree(root1);
        tree1.inorderPrint(root1); // 5 25 40 50 55 60 70
        Node max = tree1.treeMax(root1);
        Node min = tree1.treeMin(root1);
        System.out.println("\n" + max.toString()); // [70]
        System.out.println(min.toString()); // [5]
        Node k = tree1.findNode(root1, 40);
        System.out.println(k.toString()); // [40]
        Node successor = tree1.treeSucessor(root1.right);
        Node predecessor = tree1.treePredecessor(root1.right);
        System.out.println(successor.toString()); // [70]
        System.out.println(predecessor.toString()); // [55]
        System.out.println(tree1.treeHeight(root1)); // 2
        tree1.delete(root1.right.right);
        tree1.inorderPrint(root1); // 5 25 40 50 55 60

        System.out.println();

        Node root2 = new Node(12);
        root2.addLeft(new Node(5));
        root2.addRight(new Node(18));
        root2.right.addRight(new Node(19));

        BinarySearchTree tree2 = new BinarySearchTree(root2);
        tree2.delete(root2.right);
        tree2.inorderPrint(root2); // 5 12 19
    }
}
