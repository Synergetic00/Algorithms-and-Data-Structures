package dataStructures.testing;

import dataStructures.trees.BinSearchTree;

public class BinTrees {

    public static void main(String[] args) {
        /*BinaryTree<Integer> bt = new BinaryTree<>();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.printPreOrder();*/

        BinSearchTree<Integer> tree = new BinSearchTree<Integer>();

        /*tree.insert(25);
        tree.insert(15);
        tree.insert(50);
        tree.insert(10);
        tree.insert(22);
        tree.insert(35);
        tree.insert(70);
        tree.insert(4);
        tree.insert(12);
        tree.insert(18);
        tree.insert(24);
        tree.insert(31);
        tree.insert(44);
        tree.insert(66);
        tree.insert(90);*/

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.remove(20);

        System.out.println("In-Order");
        tree.printInOrder();
        System.out.println("Pre-Order");
        tree.printPreOrder();
        System.out.println("Post-Order");
        tree.printPostOrder();
    }
}