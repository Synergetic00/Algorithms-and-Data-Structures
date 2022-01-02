package dataStructures.testing;

import dataStructures.trees.BinSearchTree;
import dataStructures.trees.BinaryTree;

public class BinTrees {

    public static void main(String[] args) {
        testBinaryTree();
        //testBinSearchTree();
    }

    public static void testBinaryTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.insert(10);
        bt.insert(11);
        bt.insert(7);
        bt.insert(9);
        bt.insert(15);
        bt.insert(8);
        bt.insert(12);
        bt.remove(11);
        bt.display();
        bt.printBreadthFirst();
    }

    public static void testBinSearchTree() {
        BinSearchTree<Integer> tree = new BinSearchTree<Integer>();
        tree.insert(42);
        tree.insert(31);
        tree.insert(135);
        tree.insert(27);
        tree.insert(14);
        tree.insert(10);
        tree.insert(19);
        //tree.remove(27);
        System.out.println("In-Order");
        tree.printInOrder();
        System.out.println("Pre-Order");
        tree.printPreOrder();
        System.out.println("Post-Order");
        tree.printPostOrder();
        tree.display();
        tree.balance();
        tree.display();
    }
}