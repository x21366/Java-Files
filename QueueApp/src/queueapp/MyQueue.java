/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queueapp;

import java.util.*;

/**
 *
 * @author Hamilton1
 */
public class MyQueue implements QueueInterface {

    private ArrayList<String> theQueue;

    /* Creates a new instance of MyQueue class */
    public MyQueue() {
        theQueue = new ArrayList<String>();
    }

    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    public int size() {
        return theQueue.size();
    }

    public Object frontElement() {
        if (theQueue.size() > 0) {
            return theQueue.get(0);
        } else {
            return null;
        }
    }

    public void enqueue(Object element) {
        theQueue.add((String) element);
    }

    public Object dequeue() {
        if (theQueue.size() > 0) {
            return theQueue.remove(0);
        } else {
            return null;
        }
    }
}
