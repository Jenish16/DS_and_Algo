package com.codeistari.ds.queue.dynamiccirculararray;

public class DynamicArrayCircularQueue<T> {

  private int capacity;

  private Object[] queue;

  private int front = 0;
  private int rear = 0;
  private int size = 0;

  private static final int CAPACITY = 16;
  private static final int MIN_CAPACITY = 3;

  public DynamicArrayCircularQueue() {
    this(CAPACITY);
  }

  public DynamicArrayCircularQueue(int cap) {
    capacity = cap;
    queue = new Object[capacity];
  }

  public void enQueue(T data) {
    if(size==capacity) {
      expand();
    }
    queue[rear] = data;
    rear = (++rear) % capacity;
    size++;
  }

  private void expand () {
    Object[] newQueue = new Object[capacity << 1];

    for (int i = 0; i < size; i++) {
      newQueue[i] = queue[(i+front) % capacity];
    }
    capacity = capacity << 1;
    queue = newQueue;
    front=0;
    rear=size;
    System.out.println("Expanded Queue Size to " + capacity);
  }

  private void shrink() {
    Object[] newQueue = new Object[capacity >> 1];

    for (int i = 0; i < size; i++) {
      newQueue[i] = queue[(i + front) % capacity];
    }
    capacity = capacity >> 1;
    queue = newQueue;
    front = 0;
    rear = size;
    System.out.println("Shrank Queue Size to " + capacity);
  }

  public Object deQueue(){
    if (size == 0 ) {
      throw new IllegalStateException("Queue is Empty");
    }
    Object data = queue[front];
    queue[front] = null;
    front = ++front % capacity;
    size--;
    if (size < (capacity/4) && (capacity >> 1) >= MIN_CAPACITY) {
      shrink();
    }
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
