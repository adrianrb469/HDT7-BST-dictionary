package com.adrian.dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class IO {

    private final String DICT_PATH = "src//com//adrian//dictionary//dictionary.txt";
    private final String TEXT_PATH = "src//com//adrian//dictionary//text.txt";

    public IO() {

    }

    public BinarySearchTree readDictionary(String language) {
        String line;
        String key = "";
        BinarySearchTree bst = new BinarySearchTree(new StringComparator());
        try {

            BufferedReader br = new BufferedReader(new FileReader(DICT_PATH));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // This is to know which csv column to use as the key
                if (language.equals("English")) {
                    key = values[0];
                }
                if (language.equals("French")) {
                    key = values[2];
                }
                bst.insert(key, values[1]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bst;
    }

    public String[] getWords(){
        String line = "";
        String file = "";
        String[] words;
        try{
            BufferedReader br = new BufferedReader(new FileReader(TEXT_PATH));
            while ((line = br.readLine()) != null) {
                file += line + " " + "/n" + " ";
            }
            words = file.split(" ");
            return words;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addWord(String word){
        try{
            FileWriter fw = new FileWriter(DICT_PATH, true);
            fw.write("\n"+word);
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
