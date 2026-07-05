package com.codeistari.ds.queue.linkedlist;

import com.codeistari.ds.linkedlist.doubly.DLLNode;
import com.codeistari.ds.linkedlist.singly.ListNode;

public class LinkedListCircularQueue<T> {

  private ListNode<T> front;
  private ListNode<T> rear;
  private int size = 0;

  public LinkedListCircularQueue() {
  }

  public void enQueue(T data) {
    ListNode<T> newNode = new ListNode(data);
    if(isEmpty()){
      front = newNode;
    } else {
      rear.setNext(newNode);
    }
    rear = newNode;
    size++;
  }

  public T deQueue(){
    if (size == 0 ) {
      throw new IllegalStateException("Queue is Empty");
    }
    ListNode<T> data;
    data = front;
    if (front == rear)
    {
      front = null;
      rear = null;
    } else {
      front = front.getNext();
      data.setNext(null);
    }
    size--;
    return data.getData();
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public T front() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is Empty");
    }
    return front.getData();
  }

  public T rear() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is Empty");
    }
    return rear.getData();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    ListNode<T> node = front;
    while (node != null) {
      sb.append(node.getData()).append(", ");
      node = node.getNext();
    }
    if (sb.length() > 2)
      sb.delete(sb.length()-2, sb.length());
    sb.append("]");
    return sb.toString();
  }

  public void printQueue() {
    System.out.println("Length: " + size() + " Data: " + this.toString());
  }
}
