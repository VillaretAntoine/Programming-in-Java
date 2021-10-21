package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * addFirstTest is a method that allow to test the method addFirst from DLinkList.java
     */
    @Test
    void addFirstTest(){
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        dLinkList.addFirst(3);
        assertEquals("3 2 1 ", dLinkList.toString());
    }

    /**
     * addLastTest is a method that allow to test the method addLast from DLinkList.java
     */
    @Test
    void addLastTest(){
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        dLinkList.addLast(3);
        assertEquals("1 2 3 ", dLinkList.toString());
    }

    /**
     * removeFirstTest is a method that allow to test the method removeFirst from DLinkList.java
     */
    @Test
    void removeFirstTest(){
        addLastTest();
        dLinkList.removeFirst();
        assertEquals("2 3 ", dLinkList.toString());
    }

    /**
     * removeLastTest is a method that allow to test the method removeLast from DLinkList.java
     */
    @Test
    void removeLastTest(){
        addLastTest();
        dLinkList.removeLast();
        assertEquals("1 2 ", dLinkList.toString());
    }

    /**
     * toStringTest is a method that allow to test the method toString from DLinkList.java
     */
    @Test
    void toStringTest(){
        addLastTest();
        assertEquals("1 2 3 ", dLinkList.toString());
    }

    /**
     * removeLastTest is a method that allow to test the method removeLast from DLinkList.java
     */
    @Test
    void getFirstElemTest(){
        addLastTest();
        assertEquals(1, dLinkList.getFirstElem());
    }

    @Test
    void getLastElemTest(){
        addLastTest();
        assertEquals(3, dLinkList.getLastElem());
    }

    @Test
    void getNumberOfElementsTest(){
        addLastTest();
        assertEquals(3, dLinkList.getNumberOfElements());
    }

}