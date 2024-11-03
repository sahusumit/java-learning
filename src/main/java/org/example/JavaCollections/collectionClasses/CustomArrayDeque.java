package org.example.JavaCollections.collectionClasses;

import java.util.*;

public class CustomArrayDeque<E> implements Queue, Deque {
    private static  final int INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int head;
    private int tail;
    private int size;

    public CustomArrayDeque(){
        elements = new Object[INITIAL_CAPACITY];
    }

    private  void ensureCapacity(){
        if(size==elements.length){
            int newCapacity = elements.length*2;
            Object[] newArray = new Object[newCapacity];
            for(int i=0; i<size; i++){
                newArray[i] = elements[(head+i)%elements.length];
            }
            elements = newArray;
            head = 0;
            tail = size;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Iterator descendingIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public void addFirst(Object o) {
        ensureCapacity();
        head = (head - 1 + elements.length)%elements.length;
        elements[head] = o;
        size++;
    }

    @Override
    public void addLast(Object o) {
        ensureCapacity();
        elements[tail] = o;
        tail = (tail+1)%elements.length;
        size++;

    }

    @Override
    public boolean offerFirst(Object o) {
        return false;
    }

    @Override
    public boolean offerLast(Object o) {
        return false;
    }

    @Override
    public Object removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Object firstElement = elements[head];
        elements[head] = null;
        head = (head+1) % elements.length;
        size--;
        return firstElement;
    }

    @Override
    public Object removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        tail = (tail-1+elements.length) % elements.length;
        Object lastElement = elements[tail];
        elements[tail] = null;

        size--;
        return lastElement;
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object peekFirst() {
        if(isEmpty()){
            return  null;
        }
        return elements[head];

    }

    @Override
    public Object peekLast() {
        if(isEmpty()){
            return  null;
        }
        return elements[(tail-1 + elements.length) % elements.length];

    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        addLast(o);
        return false;
    }

    @Override
    public Object remove() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return peekFirst();
    }
}
