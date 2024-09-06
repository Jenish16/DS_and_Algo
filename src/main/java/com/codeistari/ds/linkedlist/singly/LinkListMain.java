package com.codeistari.ds.linkedlist.singly;

public class LinkListMain {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.insertAtBegin(10);
    list.printList();

    list.insertAtEnd(20);
    list.printList();

    list.insert(15,1);
    list.printList();

    list.insertAtEnd(-50);
    list.printList();

    list.insert(15,99);
    list.printList();

    System.out.println(list.getPosition(15));

    list.removeFromBegin();
    list.printList();

    list.removeFromEnd();
    list.printList();

    list.removeMatched(new ListNode<>(20));
    list.printList();

    list.insertAtEnd(20);
    list.printList();

    list.remove(1);
    list.printList();

    System.out.println(list.getPosition(50));
  }
}
