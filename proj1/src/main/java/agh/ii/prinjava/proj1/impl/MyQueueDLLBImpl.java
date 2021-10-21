package agh.ii.prinjava.proj1.impl;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     *
     * @param x
     * enqueue is a method that add an element to a queue
     */
    @Override
    public void enqueue(E x) {
        elems.addFirst(x);
    }

    /**
     *
     * @return E
     * dequeue is a method that remove an element from a queue and return it
     */
    @Override
    public E dequeue() {
        return (elems.removeLast());
    }

    /**
     *
     * @return int
     * numOfElems is a method that return the length of a queue
     */
    @Override
    public int numOfElems() {
        return (elems.getNumberOfElements());
    }

    /**
     *
     * @return E
     * peek is a method that return the first element of a queue
     */
    @Override
    public E peek() {
        return (elems.getLastElem());
    }

    /**
     *
     * @return String
     * toString is a method that return the queue as a string
     */
    @Override
    public String toString(){
        return elems.toString();
    }
}
