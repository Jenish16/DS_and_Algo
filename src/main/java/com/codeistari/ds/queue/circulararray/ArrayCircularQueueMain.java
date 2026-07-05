package com.codeistari.ds.queue.circulararray;

public class ArrayCircularQueueMain {

  public static void main(String[] args) {
    ArrayCircularQueue<Integer> queue = new ArrayCircularQueue<>(5);

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

    queue.enQueue(5);
    queue.printQueue();

    queue.enQueue(6);
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

    queue.enQueue(4);
    queue.printQueue();

    queue.enQueue(5);
    queue.printQueue();

  }

}
