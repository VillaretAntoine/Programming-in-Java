package agh.ii.prinjava.proj1.impl;

public interface MyQueue<E> {
    /**
     *
     * @param x
     * enqueue is a method that add an element to a queue
     */
    void enqueue(E x);

    /**
     *
     * @return E
     * dequeue is a method that remove an element from a queue and return it
     */
    E dequeue();

    /**
     *
     * @return boolean
     * isEmpty is a method that return true if the queue is empty
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     *
     * @return int
     * numOfElems is a method that return the length of a queue
     */
    int numOfElems();

    /**
     *
     * @return E
     * peek is a method that return the first element of a queue
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
