package agh.ii.prinjava.proj1.impl;

public interface MyStack<E> {
    /**
     *
     * @return E
     * pop is a method that remove an element from a stack and return it
     */
    E pop();

    /**
     *
     * @param x
     * push is a method that add an element to a stack
     */
    void push(E x);

    /**
     *
     * @return boolean
     * isEmpty is a method that return true if the stack is empty
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     *
     * @return int
     * numOfElems is a method that return the length of a stack
     */
    int numOfElems();

    /**
     *
     * @return E
     * peek is a method that return the first element of a stack
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
