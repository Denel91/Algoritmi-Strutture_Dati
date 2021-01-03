package Binary_Search_Tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        Node root = new Node(12);
        root.addLeft(new Node(5));
        root.addRight(new Node(18));
        root.getLeft().addLeft(new Node(2));
        root.getLeft().addRight(new Node(9));
        root.getRight().addLeft(new Node(15));
        root.getRight().addRight(new Node(19));
        root.getRight().getLeft().addRight(new Node(17));

        BinarySearchTree tree = new BinarySearchTree(root);
        Node minimum = tree.minValue(root);
        Node maximum = tree.maxValue(root);
        System.out.println(minimum.toString()); // [2]
        System.out.println(maximum.toString()); // [19]
        Node z = new Node(13);
        tree.treeInsert(z);
        tree.printTree();
        tree.preorderPrint(root); // 12 5 2 9 18 15 13 17 19
        System.out.println();
        tree.inorderPrint(root); // 2 5 9 12 13 15 17 18 19

        System.out.println();

        Node root1 = new Node(50);
        root1.addLeft(new Node(25));
        root1.addRight(new Node(60));
        root1.getLeft().addLeft(new Node(5));
        root1.getLeft().addRight(new Node(40));
        root1.getRight().addLeft(new Node(55));
        root1.getRight().addRight(new Node(70));

        BinarySearchTree tree1 = new BinarySearchTree(root1);
        tree1.inorderPrint(root1); // 5 25 40 50 55 60 70
        Node max = tree1.treeMax(root1);
        Node min = tree1.treeMin(root1);
        System.out.println("\n" + max.toString()); // [70]
        System.out.println(min.toString()); // [5]
        Node k = tree1.findNode(root1, 40);
        System.out.println(k.toString()); // [40]
        Node successor = tree1.treeSuccessor(root1.getRight());
        Node predecessor = tree1.treePredecessor(root1.getRight());
        System.out.println(successor.toString()); // [70]
        System.out.println(predecessor.toString()); // [55]
        System.out.println(tree1.treeHeight(root1)); // 2
        tree1.delete(root1.getRight().getRight());
        tree1.inorderPrint(root1); // 5 25 40 50 55 60

        System.out.println();

        Node root2 = new Node(12);
        root2.addLeft(new Node(5));
        root2.addRight(new Node(18));
        root2.getRight().addRight(new Node(19));

        BinarySearchTree tree2 = new BinarySearchTree(root2);
        tree2.delete(root2.getRight());
        tree2.inorderPrint(root2); // 5 12 19

        System.out.println();

        Node root3 = new Node(6);
        root3.addLeft(new Node(3));
        root3.addRight(new Node(7));
        root3.getLeft().addLeft(new Node(2));
        root3.getLeft().addRight(new Node(5));
        root3.getRight().addRight(new Node(8));
        BinarySearchTree tree3 = new BinarySearchTree(root3);
        int depth = tree3.depth(root3.getLeft());
        System.out.println(depth); // 1
        int element = tree3.getRandomElement(tree3);
        System.out.println("RANDOM: " + element);
        tree3.inorderPrint(root3); // 2 3 5 6 7 8
        System.out.println();
        tree3.preorderPrint(root3); // 6 3 2 5 7 8
        System.out.println();
        tree3.postorderPrint(root3); // 2 5 3 8 7 6
        System.out.println();
        tree3.inOrderTraversal(root3); // 2 3 5 6 7 8
        System.out.println();
        tree3.preOrderTraversal(root3); // 6 3 2 5 7 8
        System.out.println();
        tree3.postOrderTraversal(root3); // 2 5 3 8 7 6
        System.out.println();
        Node node = tree3.treeSearch(root3, 7);
        System.out.println(node); // [7]
        tree3.clear();
        System.out.println(tree3.getRoot());
        Node successor2 = tree3.treeSuccessor(root3.getLeft());
        System.out.println(successor2.toString()); // [5]
        Node min2 = tree3.treeMin(root3);
        System.out.println(min2); // [2]
    }
}
