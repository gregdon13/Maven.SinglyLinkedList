package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head;

    public SinglyLinkedList(){}

    public void addNode(E data) {
        if (this.head == null) {
            this.head = new Node<E>(data);
        } else {
            Node<E> temp = head;
            while (temp.hasNext()) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<E>(data));
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        Node<E> temp = this.head;
        if (index == 0) {
            this.head = this.head.getNext();
        } else {
            //catches if not index of 0
            for (int i = 0; i < index - 1; i++) {
                if (temp.hasNext()) {
                    temp = temp.getNext();
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public boolean contains(E data){
        return this.find(data) != -1;
    }

    public int find(E data) {
        Node<E> temp = this.head;
        int index = 0;
        while (temp.hasNext()) {
            if (temp.getData().equals(data)) {
                return index;
            }
            index++;
            temp = temp.getNext();
        }
        return -1;
    }

    public int size() {
        Node<E> temp = this.head;
        int index = 0;
        while (temp.hasNext()) {
            index++;
            temp = temp.getNext();
        }
        return index;
    }

    public E get(int index) {
        Node<E> temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            if (temp.hasNext()) {
                temp = temp.getNext();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return temp.getData();
    }

    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> copyList = new SinglyLinkedList<E>();
        Node<E> temp = this.head;
        if (temp.getNext() == null) {
            return copyList;
        } else {
            while (temp.hasNext()) {
                copyList.addNode(temp.getData());
                temp = temp.getNext();
            }
        }
        return copyList;
    }

    public void sort(Comparator<E> comparator) {
        boolean notSorted = true;
        Node<E> temp = this.head;
        Node<E> next;
        while (notSorted) {
            notSorted = false;
            while (temp.hasNext()) {
                next = temp.getNext();
                if (comparator.compare(temp.getData(), next.getData()) > 0){
                    swap(temp, next);
                    notSorted = true;
                }
                temp = temp.getNext();
            }
        }
    }

    private void swap(Node<E> current, Node<E> next) {
        Node<E> temp = current;
        current = next;
        next = temp;
    }
}
