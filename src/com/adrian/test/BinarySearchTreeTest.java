package com.adrian.test;

import com.adrian.dictionary.BinarySearchTree;
import com.adrian.dictionary.StringComparator;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {


    BinarySearchTree<String,String> bst = new BinarySearchTree<>(new StringComparator<>());

    BinarySearchTreeTest(){
        bst.insert("c","1");
        bst.insert("b","2");
        bst.insert("a","3");
        bst.insert("d","test");
        bst.insert("e","test2");

    }


    @org.junit.jupiter.api.Test
    void insert() {
        bst.insert("c","1");
        bst.insert("b","2");
        bst.insert("a","3");
        ArrayList<String> test = bst.getElements();
        Assertions.assertEquals("3", test.get(0));
        Assertions.assertEquals("2", test.get(1));
        Assertions.assertEquals("1", test.get(2));

    }

    @org.junit.jupiter.api.Test
    void delete() {
        bst.delete("d");
        Assertions.assertEquals(null, bst.find("d"));
    }

    @org.junit.jupiter.api.Test
    void find() {
        Assertions.assertEquals("3", bst.find("a"));
        Assertions.assertEquals("2", bst.find("b"));
    }

    @org.junit.jupiter.api.Test
    void edit() {
        bst.delete("a");
        bst.insert("a","newValue");
        Assertions.assertEquals("newValue",bst.find("a"));
    }
}