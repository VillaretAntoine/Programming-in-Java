package agh.ii.prinjava.proj1.impl;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     *
     * @return E
     * pop is a method that remove an element from a stack and return it
     */
    @Override
    public E pop() {
        return (elems.removeFirst());
    }

    /**
     *
     * @param x
     * push is a method that add an element to a stack
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     *
     * @return int
     * numOfElems is a method that return the length of a stack
     */
    @Override
    public int numOfElems() {
        return (elems.getNumberOfElements());
    }

    /**
     *
     * @return E
     * peek is a method that return the first element of a stack
     */
    @Override
    public E peek() {
        return (elems.getFirstElem());
    }

    /**
     *
     * @return String
     * toString is a method that return the stack as a string
     */
    @Override
    public String toString(){
        return elems.toString();
    }

}
