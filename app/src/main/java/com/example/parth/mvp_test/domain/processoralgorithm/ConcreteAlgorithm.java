package com.example.parth.mvp_test.domain.processoralgorithm;

import com.example.parth.mvp_test.model.WordData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Parth on 12-Nov-15.
 */

public class ConcreteAlgorithm implements StringProcessingAlgorithm {


    @Override
    public List<WordData> processInputString(String inputString) {

        String wordDelimiter = "[^a-zA-Z]+";

        String[] wordArray = inputString.split(wordDelimiter);
        System.out.println("String length is :" + wordArray.length);
        System.out.println("Words are :" + Arrays.toString(wordArray).toLowerCase());

        // Calcualte Frequence & Add to map
        HashMap<String, Integer> wordFrequencyHashMap = new HashMap<>();
        for (String word : wordArray) {
            word = word.toLowerCase();
            Integer n = wordFrequencyHashMap.get(word);
            n = (n == null) ? 1 : ++n;
            wordFrequencyHashMap.put(word, n);
        }

        Iterator it = wordFrequencyHashMap.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            //   it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println("After Algo map size is  :" + wordFrequencyHashMap.size());

        return null;
//        return wordFrequencyHashMap;
    }
}
