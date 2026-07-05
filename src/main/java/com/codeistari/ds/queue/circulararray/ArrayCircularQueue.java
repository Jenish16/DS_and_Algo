package com.codeistari.ds.queue.circulararray;

public class ArrayCircularQueue<T> {

  private int capacity;

  private Object[] queue;

  private int front = 0;
  private int rear = 0;
  private int size = 0;

  private static final int CAPACITY = 16;

  public ArrayCircularQueue() {
    this(CAPACITY);
  }

  public ArrayCircularQueue(int cap) {
    capacity = cap;
    queue = new Object[capacity];
  }

  public void enQueue(T data) {
    if(size==capacity) {
      throw new IllegalStateException("Queue is Full");
    }
    queue[rear] = data;
    rear = (++rear) % capacity;
    size++;
  }

  public Object deQueue(){
    if (size == 0 ) {
      throw new IllegalStateException("Queue is Empty");
    }
    Object data = queue[front];
    queue[front] = null;
    front = ++front % capacity;
    size--;
    return data;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public int size() {
    return size;
  }

  public Object front() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is Empty");
    }
    return queue[front];
  }

  public Object rear() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is Empty");
    }
    return queue[rear];
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0 ; i < size; i++) {
      sb.append(queue[(i+front)%capacity]).append(", ");
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
