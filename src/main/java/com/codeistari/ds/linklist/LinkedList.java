package com.codeistari.ds.linklist;

public class LinkedList<T> {

  ListNode<T> head;

  //Size of LinkList
  private int length = 0;

  public LinkedList() {
    length = 0;
  }

  public synchronized ListNode<T> getHead() {
    return head;
  }

  //Insert at the beginning of the list.
  public synchronized void insertAtBegin(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    newNode.setNext(head);
    head = newNode;
    length++;
  }

  // Insert node at end of the List.
  public synchronized void insertAtEnd(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    if(head == null) {
      head = newNode;
    } else {
      ListNode<T> node = head.getNext();
      ListNode<T> prevNode = head;
      while(node != null){
        prevNode = node;
        node = node.getNext();
      }
      prevNode.setNext(newNode);
    }
    length++;
  }

  //Insert at given position
  public void insert(T data, int position) {
    ListNode<T> newNode = new ListNode<>(data);
    if(position < 0) {
      position = 0;
    }
    if(position > length) {
      position = length;
    }

    if(head == null) {
      head = newNode;
      length++;
    } else if(position == 0){
      newNode.setNext(head);
      head = newNode;
    } else {
      ListNode<T> node = head;
      for(int i = 1; i < position; i++){
        node = node.getNext();
      }
      newNode.setNext(node.getNext());
      node.setNext(newNode);
    }
    length++;
  }

  // Remove and return the node at the head
  public synchronized ListNode<T> removeFromBegin() {
    ListNode<T> node = head;
    if(node != null) {
      head = node.getNext();
      node.setNext(null);
      length--;
    }
    return node;
  }

  //Remove and return the node at the end
  public synchronized ListNode<T> removeFromEnd() {
    if(head == null){
      return null;
    }
    ListNode<T> node = head;
    ListNode<T> nextNode = head.getNext();
    ListNode<T> prevNode = null;
    if(nextNode == null) {
      head = null;
      length--;
      return node;

    }
    while(nextNode != null) {
      prevNode = node;
      node = nextNode;
      nextNode = nextNode.getNext();
    }
    prevNode.setNext(null);
    length--;
    return node;
  }

  // Remove a node matching the specified node from the list.
  public synchronized void removeMatched(ListNode<T> node){
    if(head == null){
      return;
    }

    if(head.equals(node)){
      head = head.getNext();
      length--;
      return;
    }

    ListNode<T> currentNode = head;
    ListNode<T> prevNode = null;
    while(currentNode != null){
      if(currentNode.equals(node)){
        prevNode.setNext(currentNode.getNext());
        length--;
      }
      prevNode = currentNode;
      currentNode = currentNode.getNext();
    }
  }

  // Remove the value at a given position.
  // If the position is less than 0, remove the value at position 0.
  // If the position is greater than 0, remove the value at the last position.
  public void remove(int position){
    if(position < 0){
      position = 0;
    }
    if(position >= length){
      position = length - 1;
    }

    if(head == null) {
      return;
    }

    if(position == 0){
      head = head.getNext();
      length--;
      return;
    }
    ListNode<T> prevNode = head;
    for(int i = 1; i < position; i++){
      prevNode = prevNode.getNext();
    }
    prevNode.setNext(prevNode.getNext().getNext());
    length--;
  }

  public String toString() {
    StringBuilder result = new StringBuilder("[");
    if(head == null) {
      result.append(" ]");
    } else {
      result.append(head.getData().toString());
      ListNode<T> node = head.getNext();
      while(node != null){
        result.append(", ").append(node.getData().toString());
        node = node.getNext();
      }
      result.append("]");
    }
    return result.toString();
  }

  public void printList() {
    System.out.println("Length: " + this.length + " Data: " + this.toString());
  }

  // Return the current length of the list.
  public int length() {
    return length;
  }

  // Find the position of the first value that is equal to a given value.
  public int getPosition(T data) {
    ListNode<T> node = head;
    int position = 0;

    while(node != null){
      if(node.getData().equals(data)){
        return position;
      }
      position++;
      node = node.getNext();
    }

    return -1;
  }


}
