package com.codeistari.ds.queue.dynamiccirculararray;

public class DynamicArrayCircularQueueMain {

  public static void main(String[] args) {
    DynamicArrayCircularQueue<Integer> queue = new DynamicArrayCircularQueue<>(4);

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
