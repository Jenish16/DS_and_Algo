package com.codeistari.ds.linklist;

import java.util.Objects;
import lombok.Data;

@Data
public class ListNode<T> {

  private T data;
  private ListNode next;

  public ListNode(T data) {
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
    ListNode<?> listNode = (ListNode<?>) o;
    return Objects.equals(data, listNode.data);
  }
}
