package com.codeistari.ds.tree.binarytree;

import lombok.Data;

@Data
public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}
