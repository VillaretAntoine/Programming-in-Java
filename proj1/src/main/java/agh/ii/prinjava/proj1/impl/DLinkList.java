package agh.ii.prinjava.proj1.impl;

public class DLinkList<E> {
    // ...

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;
    }

    private Node<E> first = null;
    private Node<E> last = null;
    private int numberOfElements = 0;

    /**
     *
     * @return int
     * getNumberOfElements is a method that return the number of Elements of a Doubly Linked List (DLL)
     */
    public int getNumberOfElements() {
        return numberOfElements;
    }

    /**
     *
     * @return E
     * getFirstElem is a method that return the first element of a DLL
     */
    public E getFirstElem() {
        if (numberOfElements!=0){
            return first.elem;
        }
        throw new RuntimeException("Is empty");
    }

    /**
     *
     * @return E
     * getLastElem is a method that return the last element of a DLL
     */
    public E getLastElem() {
        if (numberOfElements!=0){
            return last.elem;
        }
        throw new RuntimeException("Is empty");
    }

    /**
     *
     * @param elem
     * addFirst is a method that add an element at the first position of a DLL
     */
    public void addFirst(E elem) {
        if (numberOfElements != 0) {
            Node<E> newNode = new Node<>();
            newNode.elem = elem;
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        else {
            Node<E> newNode = new Node<>();
            newNode.elem = elem;
            first = newNode;
            last = newNode;
        }
        numberOfElements++;
    }


    /**
     *
     * @param elem
     * addLast is a method that add an element at the last position of a DLL
     */
    public void addLast(E elem) {
        if (numberOfElements != 0){
            Node<E> newNode = new Node<>();
            newNode.elem = elem;
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        else {
            Node<E> newNode = new Node<>();
            newNode.elem = elem;
            last = newNode;
            first = newNode;
        }
        numberOfElements++;
    }

    /**
     *
     * @return E
     * removeFirst is a method that return an element from the first position of a DLL
     */
    public E removeFirst(){
        if (numberOfElements!=0){
            E toRemove = first.elem;
            if (numberOfElements>1){
                first = first.next;
                first.prev = null;
            }
            else {
                first = null;
                last = null;
            }
            numberOfElements--;

            return toRemove;
        }
        throw new RuntimeException("Is empty");
    }

    /**
     *
     * @return E
     * removeLast is a method that return an element from the last position of a DLL
     */
    public E removeLast(){
        if (numberOfElements!=0){
            E toRemove = last.elem;
            if (numberOfElements>1){
                last = last.prev;
                last.next = null;
            }
            else {
                first = null;
                last = null;
            }
            numberOfElements--;

            return toRemove;
        }
        throw new RuntimeException("Is empty");
    }

    /**
     *
     * @return String
     * toString is a method that return the DLL as a string
     */
    @Override
    public String toString(){
        String toReturn = "";
        Node<E> temp = first;
        while (temp != null){
            toReturn += temp.elem.toString() + " ";
            temp = temp.next;
        }
        return toReturn;
    }
}
