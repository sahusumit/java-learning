package org.example.JavaCollections.collectionInterface;

public interface IIterator<T> {
    boolean hasNext();
    void remove();
    T next();
}
