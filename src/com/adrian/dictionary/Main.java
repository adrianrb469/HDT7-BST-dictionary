package com.adrian.dictionary;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<String, String> englishDict = new IO().readDictionary("English");
        BinarySearchTree<String, String> frenchDict = new IO().readDictionary("French");
        englishDict.inOrder(new StringTraversal<>());
        frenchDict.inOrder(new StringTraversal<>());




    }
}
