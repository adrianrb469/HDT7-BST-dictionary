package com.adrian.dictionary;

public class Translator {

    public Translator(){

    }

    public String[] translate(String[] words, BinarySearchTree<String, String> englishDict, BinarySearchTree<String, String> frenchDict){
        String[] translation = words;
        try{
            for (int i = 0; i < words.length; i++){
                if (words[i].equals("/n")){
                    translation[i] = "\n";
                }
                else{
                    if (englishDict.find(words[i]) != null) {
                        translation[i] = englishDict.find(words[i]);
                    } else if (frenchDict.find(words[i]) != null) {
                        translation[i] = englishDict.find(words[i]);
                    } else {
                        // This means it's not in any of the dictionaries
                        translation[i] = "*" + words[i] + "*";
                    }
                }

            }

            return translation;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
