package com.codeistari.ds.linklist.doubly;

import com.codeistari.ds.linklist.singly.ListNode;

public class DoublyLinkedList<T> {

  DLLNode<T> head;
  DLLNode<T> tail;
  //Size of LinkList
  private int length = 0;

  public DoublyLinkedList() {
    length = 0;
  }

  public synchronized DLLNode<T> getHead() {
    return head;
  }

  public synchronized DLLNode<T> getTail() {
    return tail;
  }

  // Add a new value to the front of the list.
  public void insertAtBegin(T data){
    DLLNode<T> newNode = new DLLNode<>(data);

    if(head == null){
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    }
    length++;
  }

  //Add a new value to the list at a given position.
  public void insert(T data, int position) {
    if(position < 0) {
      position = 0;
    }
    if(position > length) {
      position = length;
    }

    DLLNode<T> newNode = new DLLNode<>(data);
    if(head == null){
      head = newNode;
      tail = head;
      length++;
    } else if(position == 0) {
      insertAtBegin(data);
    } else if(position == length) {
      insertAtEnd(data);
    } else {
      DLLNode<T> tempNode = head;
      for(int i = 0; i < position; i++){
        tempNode = tempNode.getNext();
      }
      newNode.setNext(tempNode);
      newNode.setPrev(tempNode.getPrev());
      tempNode.getPrev().setNext(newNode);
      tempNode.setPrev(newNode);
      length++;
    }

  }

  // Insert node at end of the List.
  public void insertAtEnd(T data) {
    DLLNode<T> newNode = new DLLNode<>(data);
    if(tail == null){
      head = newNode;
      tail = newNode;
    } else {
      newNode.setPrev(tail);
      tail.setNext(newNode);
      tail = newNode;
    }
    length++;
  }

  // Remove and return the node at the head
  public DLLNode<T> removeFromBegin() {
    DLLNode<T> node = head;
    if(head == tail) {
      head = null;
      tail = null;
      length--;
      return node;
    }
    if(node != null) {
      head = node.getNext();
      node.setNext(null);
      length--;
      if(head != null){
        head.setPrev(null);
      }
    }
    return node;
  }

  //Remove and return the node at the end
  public DLLNode<T> removeFromEnd() {
    DLLNode<T> node = tail;
    if(head == tail) {
      head = null;
      tail = null;
      length--;
      return node;
    }
    if(node != null) {
      tail = node.getPrev();
      node.setPrev(null);
      length--;
      if(tail != null) {
        tail.setNext(null);
      }
    }
    return node;
  }

  // Remove a node matching the specified node from the list.
  public void removeMatched(DLLNode<T> node) {
    if(head == null){
      return;
    }
    if(head.equals(node)) {
      DLLNode<T> tempNode = head;
      head = tempNode.getNext();
      tempNode.setNext(null);
      if(head == null) {
        tail = null;
      } else {
        head.setPrev(null);
      }
      length--;
      return;
    }

    DLLNode<T> tempNode = head;
    while(tempNode != null){
      if(tempNode.equals(node)){
        if(tail == tempNode){
          tail = tempNode.getPrev();
          tail.setNext(null);
        } else {
          tempNode.getPrev().setNext(tempNode.getNext());
          tempNode.getNext().setPrev(tempNode.getPrev());
        }
        tempNode.setPrev(null);
        tempNode.setNext(null);
        length--;
        return;
      }
      tempNode = tempNode.getNext();
    }
  }

  // Remove the value at a given position.
  // If the position is less than 0, remove the value at position 0.
  // If the position is greater than 0, remove the value at the last position.
  public void remove(int position) {
    if(position < 0) {
      position = 0;
    }
    if(position >= length) {
      position = Math.max(length - 1, 0);
    }

    if(head == null){
      return;
    }

    if(position == 0) {
      removeFromBegin();
    }else if(position == length - 1) {
      removeFromEnd();
    } else {
      DLLNode<T> tempNode = head;
      for(int i = 0; i < position; i++) {
        tempNode = tempNode.getNext();
      }
      if(tail == tempNode){
        tail = tempNode.getPrev();
        tail.setNext(null);
      } else {
        tempNode.getPrev().setNext(tempNode.getNext());
        tempNode.getNext().setPrev(tempNode.getPrev());
      }
      tempNode.setPrev(null);
      tempNode.setNext(null);
      length--;
    }
  }

  // Find the position of the first value that is equal to a given value.
  public int getPosition(T data) {
    DLLNode<T> node = head;
    int position = 0;
    while(node != null){
      if(node.getData().equals(data)){
        return position;
      }
      node = node.getNext();
      position++;
    }
    return -1;
  }

  public String toString() {
    StringBuilder result = new StringBuilder("[");
    if(head == null) {
      result.append(" ]");
    } else {
      result.append(head.getData().toString());
      DLLNode<T> node = head.getNext();
      while(node != null){
        result.append(", ").append(node.getData().toString());
        node = node.getNext();
      }
      result.append("]");
    }
    return result.toString();
  }

  public String reverseToString() {
    StringBuilder result = new StringBuilder("[");
    if(tail == null) {
      result.append(" ]");
    } else {
      result.append(tail.getData().toString());
      DLLNode<T> node = tail.getPrev();
      while(node != null){
        result.append(", ").append(node.getData().toString());
        node = node.getPrev();
      }
      result.append("]");
    }
    return result.toString();
  }

  public void printList() {
    System.out.println("Length: " + this.length + " Data: " + this.toString());
  }

  public void printRevertList() {
    System.out.println("Length: " + this.length + " Data: " + this.reverseToString());
  }

  // Return the current length of the list.
  public int length() {
    return length;
  }

  public void clearList() {
    head = null;
    tail = null;
    length = 0;
  }

}