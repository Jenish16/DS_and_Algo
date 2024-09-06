package com.codeistari.ds.stack.linkedlist;

import com.codeistari.ds.linkedlist.singly.ListNode;

public class LinkedStack<T> {

  private StackNode<T> head;
  private int length = 0;

  public LinkedStack() {
    length = 0;
  }

  public int size() {
    return length;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void push(T data) {
    StackNode<T> node = new StackNode<>(data);
    node.setNext(head);
    head = node;
  }

  public T top() {
    if(isEmpty()) {
      return null;
    }
    return head.getData();
  }

  public T pop() {
    if(isEmpty()) {
      return null;
    }
    StackNode<T> node = head;
    head = head.getNext();
    node.setNext(null);
    return node.getData();
  }

  public String toString() {
    StringBuilder result = new StringBuilder("[");
    if(head == null) {
      result.append(" ]");
    } else {
      result.append(head.getData().toString());
      StackNode<T> node = head.getNext();
      while(node != null){
        result.append(", ").append(node.getData().toString());
        node = node.getNext();
      }
      result.append("]");
    }
    return result.toString();
  }

  public void printStack() {
    System.out.println("Length: " + this.length + " Data: " + this.toString());
  }

}
