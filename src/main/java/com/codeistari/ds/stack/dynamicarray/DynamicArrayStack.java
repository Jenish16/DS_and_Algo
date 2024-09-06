package com.codeistari.ds.stack.dynamicarray;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayStack<T> {

  private int capacity;

  List<T> stack;

  private int top = -1;

  private static final int CAPACITY = 16;
  private static final int MINCAPACITY = 1 << 3; // 2^3

  public DynamicArrayStack() {
    this(CAPACITY);
  }

  public DynamicArrayStack(int cap) {
    capacity = cap;
    stack = new ArrayList<>(capacity);
  }

  public int size() {
    return top + 1;
  }

  public boolean isEmpty() {
    return top < 0;
  }

  public void push(T data) {
    if(size() == capacity) {
      expand();
    }
    stack.add(++top, data);
  }

  public T top() {
    if(isEmpty()) {
      return null;
    }
    return stack.get(top);
  }

  private void expand() {
    int length = size();
    List<T> newStack = new ArrayList<>(length << 1);
    newStack.addAll(stack);
    this.stack = newStack;
    this.capacity = this.capacity << 1;
  }

  public T pop() {
    if(isEmpty()) {
      return null;
    }
    T data = stack.get(top);
    stack.set(top--, null);

    if(size() <= capacity >> 2 && capacity > MINCAPACITY) {
      shrink();
    }
    return data;
  }

  private void shrink() {
    int length = size();
    length = length >> 1;
    if(length < MINCAPACITY) {
      length = MINCAPACITY;
    }
    List<T> newStack = new ArrayList<>(length);
    newStack.addAll(stack);
    this.capacity = length;
  }

  public String toString() {
    StringBuilder result = new StringBuilder("[");

    if(isEmpty()) {
      result.append(" ]");
    } else {
      int i = top;
      result.append(stack.get(i--));
      while(i>=0){
        result.append(", ").append(stack.get(i--));
      }
      result.append("]");
    }
    return result.toString();
  }

  public void printStack() {
    System.out.println("Length: " + size() + " Data: " + this.toString());
  }

}
