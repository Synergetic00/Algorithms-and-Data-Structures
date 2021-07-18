package dataStructures.testing;

import dataStructures.trees.BinaryTree;

public class BinTrees {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.printPreOrder();
    }
    
}