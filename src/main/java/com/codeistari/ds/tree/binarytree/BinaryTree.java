package com.codeistari.ds.tree.binarytree;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@Data
public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    void insert(T data) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode<T> node;
        while(!queue.isEmpty()) {
            node = queue.poll();
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                return;
            }
            if(node.getRight() == null) {
                node.setRight(newNode);
                return;
            }
            queue.add(node.getLeft());
            queue.add(node.getRight());
        }
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (node.getData().equals(data)) {
            return true;
        }

        return search(node.getLeft(), data) || search(node.getRight(), data);
    }

    public void preorder() {
        System.out.print("[");
        preorder(root);
        System.out.println("]");
    }

    private void preorder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + ",");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void preorderIterative() {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();

            System.out.print(node.getData() + ",");

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        System.out.println("]");
    }

    public void inorder() {
        System.out.print("[");
        inorder(root);
        System.out.println("]");
    }

    private void inorder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getData() + ",");
        inorder(node.getRight());
    }

    public void inorderIterative() {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> curr = root;

        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {

                curr = stack.pop();

                System.out.print(curr.getData() + ",");

                curr = curr.getRight();
            }
        }
        System.out.println("]");
    }

    public void postorder() {
        System.out.print("[");
        postorder(root);
        System.out.println("]");
    }

    private void postorder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getData() + ",");
    }

    /**
     * Iterative postorder traversal using one stack.
     *
     * Postorder = Left -> Right -> Root.
     *
     * `prev` is used to determine traversal direction:
     * - moving down from parent to child
     * - coming back from the left subtree
     * - coming back from the right subtree
     *
     * A node is popped only after its left and right subtrees are processed.
     *
     * Time: O(n)
     * Space: O(h), where h is the tree height.
     */
    public void postorderIterative() {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        BinaryTreeNode<T> curr = root;
        BinaryTreeNode<T> prev = null;

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(curr);
        while(!stack.isEmpty()) {
            curr = stack.peek();
            // We are moving down the tree
            if (prev == null || curr.equals(prev.getLeft()) || curr.equals(prev.getRight())) {
                if (curr.getLeft() != null) {
                    stack.push(curr.getLeft());
                } else if (curr.getRight() != null) {
                    stack.push(curr.getRight());
                }
            } else if (prev.equals(curr.getLeft())) {
                if(curr.getRight() != null) {
                    stack.push(curr.getRight());
                }
            } else {
                System.out.print(stack.pop().getData() + ",");
            }
            prev = curr;
        }
        System.out.println("]");
    }

    /**
     * Iterative postorder traversal using two stacks.
     *
     * Postorder = Left -> Right -> Root.
     *
     * Stack1 processes nodes in Root -> Right -> Left order.
     * Stack2 reverses that order, giving Left -> Right -> Root.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public void postorderIterativeMemoryOptimized() {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");

        Stack<BinaryTreeNode<T>> stack1 = new Stack<>();
        Stack<BinaryTreeNode<T>> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            BinaryTreeNode<T> node = stack1.pop();

            stack2.push(node);

            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }

            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getData() + ",");
        }
        System.out.println("]");
    }

    public void levelOrder() {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        BinaryTreeNode<T> curr = root;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            curr = queue.poll();

            System.out.print(curr.getData() + ",");

            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            if(curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        System.out.println("]");
    }

    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }
}
