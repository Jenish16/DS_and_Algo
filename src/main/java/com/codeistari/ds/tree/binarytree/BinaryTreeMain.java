package com.codeistari.ds.tree.binarytree;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("Level Order : ");
        tree.levelOrder();

        System.out.println("Pre Order : ");
        tree.preorder();
        tree.preorderIterative();

        System.out.println("InOrder Order : ");
        tree.inorder();
        tree.inorderIterative();

        System.out.println("Post Order : ");
        tree.postorder();
        tree.postorderIterative();
        tree.postorderIterativeMemoryOptimized();

        System.out.println("Element 8 is present in Tree : " + tree.search(8));

        System.out.println("Element 4 is present in Tree : " + tree.search(4));

    }
}
