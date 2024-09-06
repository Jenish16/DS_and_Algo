package com.codeistari.ds.stack.linkedlist;

import java.util.Objects;
import lombok.Data;

@Data
public class StackNode<T> {

  private T data;
  private StackNode next;

  public StackNode(T data) {
    this.data = data;
    this.next = null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StackNode<?> listNode = (StackNode<?>) o;
    return Objects.equals(data, listNode.data);
  }
}
