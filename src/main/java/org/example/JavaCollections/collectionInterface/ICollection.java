package org.example.JavaCollections.collectionInterface;

public interface ICollection<T>  extends IIterator{

    int size();
    boolean isEmpty();
    boolean contains();
    T [] toArrt();
    void add(T value);
    void remove();
    void addAll(T value);
    void removeAll();
    void clear();

    boolean equalsValue(T value);
    T IIterator();
    T streamCollection();
    T parallelStreamCollection();

}
