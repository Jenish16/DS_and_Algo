package com.codeistari.ds.linklist.doubly;

public class DoublyLinkListMain {

  public static void main(String[] args) {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    list.insertAtBegin(10);
    list.printList();
    list.printRevertList();

    list.insertAtEnd(20);
    list.printList();
    list.printRevertList();

    list.insert(15,1);
    list.printList();
    list.printRevertList();

    list.insertAtEnd(-50);
    list.printList();
    list.printRevertList();

    list.insert(15,99);
    list.printList();
    list.printRevertList();

    System.out.println(list.getPosition(20));

    list.removeFromBegin();
    list.printList();
    list.printRevertList();

    list.removeFromEnd();
    list.printList();
    list.printRevertList();

    list.removeMatched(new DLLNode<>(20));
    list.printList();
    list.printRevertList();

    list.insertAtEnd(20);
    list.printList();
    list.printRevertList();

    list.remove(1);
    list.printList();
    list.printRevertList();

    System.out.println(list.getPosition(50));
   
  }
}
