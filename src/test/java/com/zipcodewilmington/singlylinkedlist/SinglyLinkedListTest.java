package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void addSizeTest() {
        //Given
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addNode(1);
        myList.addNode(2);
        int expected = 2;

        //When
        int actual = myList.size();
    }
}
