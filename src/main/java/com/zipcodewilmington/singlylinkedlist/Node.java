package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;

public class Node<E> implements Comparable<E>{
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node (E data) {
        this.data = data;
        this.next = null;
    }

    public boolean hasNext() {
        if (this.next == null) {
            return false;
        } else {
            return true;
        }
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }


    public int compareTo(Node<E> node2) {
        return 0;
    }


    public int compareTo(E o) {
        return 0;
    }
}
