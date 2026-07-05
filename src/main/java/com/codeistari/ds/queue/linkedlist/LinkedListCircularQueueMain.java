package com.codeistari.ds.queue.linkedlist;

public class LinkedListCircularQueueMain {

  public static void main(String[] args) {
    LinkedListCircularQueue<Integer> queue = new LinkedListCircularQueue<>();

    queue.enQueue(1);
    queue.printQueue();

    queue.enQueue(2);
    queue.printQueue();

    queue.enQueue(3);
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.enQueue(4);
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.enQueue(5);
    queue.printQueue();

    queue.enQueue(6);
    queue.printQueue();

    queue.enQueue(7);
    queue.printQueue();

    queue.enQueue(8);
    queue.printQueue();

    queue.enQueue(9);
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.enQueue(10);
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.enQueue(11);
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

    queue.deQueue();
    queue.printQueue();

  }
}
