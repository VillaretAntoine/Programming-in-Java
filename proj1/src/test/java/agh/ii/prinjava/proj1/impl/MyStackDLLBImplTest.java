package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * pushTest is a method that allow to test the method push from MyStackDLLBImpl.java
     */
    @Test
    void pushTest(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        assertEquals("3 2 1 ", stackOfInts.toString());
    }

    /**
     * popTest is a method that allow to test the method pop from MyStackDLLBImpl.java
     */
    @Test
    void popTest(){
        pushTest();
        stackOfInts.pop();
        assertEquals("2 1 ", stackOfInts.toString());
    }

    /**
     * numOfElemsTest is a method that allow to test the method numOfElems from MyStackDLLBImpl.java
     */
    @Test
    void numOfElemsTest(){
        pushTest();
        assertEquals(3, stackOfInts.numOfElems());
    }

    /**
     * peekTest is a method that allow to test the method peek from MyStackDLLBImpl.java
     */
    @Test
    void peekTest(){
        pushTest();
        assertEquals(3, stackOfInts.peek());
    }

    /**
     * toStringTest is a method that allow to test the method toString from MyStackDLLBImpl.java
     */
    @Test
    void toStringTest(){
        pushTest();
        assertEquals("3 2 1 ", stackOfInts.toString());
    }

}