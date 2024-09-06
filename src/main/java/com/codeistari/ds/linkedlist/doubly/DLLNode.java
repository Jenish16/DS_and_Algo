package com.codeistari.ds.linkedlist.doubly;

import java.util.Objects;
import lombok.Data;

@Data
public class DLLNode<T> {

  private T data;
  private DLLNode prev;
  private DLLNode next;

  public DLLNode(T data) {
    this.data = data;
    this.prev = null;
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
    DLLNode<?> listNode = (DLLNode<?>) o;
    return Objects.equals(data, listNode.data);
  }
}
