package com.adrian.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        IO io = new IO();
        Translator translator = new Translator();
        BinarySearchTree<String, String> englishDict = io.readDictionary("English");
        BinarySearchTree<String, String> frenchDict = io.readDictionary("French");

        boolean quit = false;
        Scanner input = new Scanner(System.in);
        String option = "";

        while (!quit) {
            System.out.println("1.In order traversal\n2.Translate text\n3.Add word\n4.Edit word\n5.Delete word");
            option = input.nextLine();
            switch (option) {
                case "1":
                    System.out.println("1.English tree\n2.French tree");
                    option = input.nextLine();
                    if (option.equals("1")) {
                        englishDict.inOrder(new StringTraversal<>());
                    } else {
                        frenchDict.inOrder(new StringTraversal<>());
                    }

                    break;
                case "2":
                    String translation[] = translator.translate(io.getWords(), englishDict, frenchDict);
                    for (int x = 0; x < translation.length; x++) {
                        System.out.print(" " + translation[x]);
                    }
                    break;
                case "3":
                    System.out.println("Format: \"english,spanish,french\"");
                    option = input.nextLine();
                    String[] word = option.split(",");
                    englishDict.insert(word[0], word[1]);
                    frenchDict.insert(word[2], word[1]);
                    io.addWord(option);
                    break;
                case "4":
                    System.out.println("1 = English word 2 = French word");
                    option = input.nextLine();
                    if (option.equals("1")) {
                        englishDict.inOrder(new StringTraversal<>());
                        System.out.println("Format: \"english,newSpanish\"");
                        option = input.nextLine();
                        String[] editWord = option.split(",");
                        // deletes the previous word before inserting the new one
                        englishDict.delete(editWord[0]);
                        englishDict.insert(editWord[0], editWord[1]);
                    } else {
                        englishDict.inOrder(new StringTraversal<>());
                        System.out.println("Format: \"french,newSpanish\"");
                        option = input.nextLine();
                        String[] editWord = option.split(",");
                        frenchDict.insert(editWord[0], editWord[1]);
                    }
                    break;
                case "5":
                    System.out.println("1 = English word 2 = French word");
                    option = input.nextLine();
                    if (option.equals("1")) {
                        englishDict.inOrder(new StringTraversal<>());
                        System.out.println("Enter the english word");
                        option = input.nextLine();
                        englishDict.delete(option);
                    } else {
                        englishDict.inOrder(new StringTraversal<>());
                        System.out.println("Enter the french word");
                        option = input.nextLine();
                        frenchDict.delete(option);
                    }
                    break;
            }


        }


    }
}
