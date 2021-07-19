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
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // print inorder traversal of the BST
        tree.printInOrder();
    }
    
}