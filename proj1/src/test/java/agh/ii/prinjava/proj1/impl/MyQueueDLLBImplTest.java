package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * enqueueTest is a method that allow to test the method enqueue from MyQueueDLLBImpl.java
     */
    @Test
    void enqueueTest(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        assertEquals("3 2 1 ", queueOfInts.toString());
    }

    /**
     * dequeueTest is a method that allow to test the method dequeue from MyQueueDLLBImpl.java
     */
    @Test
    void dequeueTest(){
        enqueueTest();
        queueOfInts.dequeue();
        assertEquals("3 2 ", queueOfInts.toString());
    }

    /**
     * numOfElemsTest is a method that allow to test the method numOfElems from MyQueueDLLBImpl.java
     */
    @Test
    void numOfElemsTest(){
        enqueueTest();
        assertEquals(3, queueOfInts.numOfElems());
    }

    /**
     * peekTest is a method that allow to test the method peek from MyQueueDLLBImpl.java
     */
    @Test
    void peekTest(){
        enqueueTest();
        assertEquals(1, queueOfInts.peek());
    }

    /**
     * toStringTest is a method that allow to test the method toString from MyQueueDLLBImpl.java
     */
    @Test
    void toStringTest(){
        enqueueTest();
        assertEquals("3 2 1 ", queueOfInts.toString());
    }
}