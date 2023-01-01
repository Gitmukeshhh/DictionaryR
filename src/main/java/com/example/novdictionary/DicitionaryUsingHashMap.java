package com.example.novdictionary;

import java.util.HashMap;
import java.util.Map;

public class DicitionaryUsingHashMap {

    private HashMap<String, String> dictionary;

    public DicitionaryUsingHashMap() {
        dictionary = new HashMap<String, String>();
        addListOfWords();
    }


    public boolean addwored(String wored, String meaning) {
        dictionary.put(wored, meaning);
        return true;
    }


     public String[] getSuggestion(String word){
        String [] suggestion=new String[5];
        int i=0;
        for(Map.Entry<String,String>entry: dictionary.entrySet()){
            int lastIndex=Math.min(word.length(),entry.getKey().length());
            if(word.compareTo(entry.getKey().substring(0,lastIndex))==0){
                suggestion[i++]= entry.getKey();
            }
             if(i==4) break;
        }
                return suggestion;
     }


    public String findMeaning(String word) {
        if (!dictionary.containsKey(word)) {
            return "Given wored not found";
        } else {
            return dictionary.get(word);
        }
    }

    private void addListOfWords() {
        addwored("smart", "clever");
        addwored("chief", "head");
        addwored("nearyby", "close");
        addwored("whole", "total");
        addwored("hate", "abhor");
        addwored("emotion", "feeling");
        addwored("rest", "reminder");
        addwored("admire", "respect");
        addwored("worship", "pray");
        addwored("peal", "ring");
        addwored("borrow", "hole");

    }
}


