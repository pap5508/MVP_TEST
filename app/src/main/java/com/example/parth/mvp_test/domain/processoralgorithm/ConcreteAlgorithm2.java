package com.example.parth.mvp_test.domain.processoralgorithm;

import com.example.parth.mvp_test.model.WordData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Parth on 12-Nov-15.
 */

public class ConcreteAlgorithm2 implements StringProcessingAlgorithm {

    TreeMap<String, WordData> wordsFrequencyMap = new TreeMap<String, WordData>();

    @Override
    public List<WordData> processInputString(String inputString) {

        // regular expression to check for - Still problem with aphostrophy
        String wordDelimiter = "[^a-zA-Z]+";

        //Array to hold list of words.
        String[] wordArray = inputString.split(wordDelimiter);

        /**
         * iterate over String array & get the unique word. Convert the word into lowercase & add it to WordData.
         */
        for (String singleWord : wordArray) {
            singleWord = singleWord.toLowerCase();
            WordData wordData = (WordData)wordsFrequencyMap.get(singleWord);
            // Check whether the word is already in the Map.
            if (wordData == null) {
                // if word doesn't exists add word to map
                wordsFrequencyMap.put(singleWord, new WordData(singleWord) );
            }
            else {
                // If word exists increment the counter
                wordData.count = wordData.count + 1;
            }
        }
        // get All the WordData Arraylist from the Map
        List<WordData> wordsByFrequencyList = new ArrayList<WordData>(wordsFrequencyMap.values());
        Iterator iterator = wordsByFrequencyList.iterator();
        // Sort wordsByFrequencyList List By Frequency in descending order
        Collections.sort(wordsByFrequencyList);
        //After Words are sorted by frequency, sort word with same frequency by Alphabets.(Natural ordering)
        Collections.sort(wordsByFrequencyList, WordData.WordNameComparator);
        return wordsByFrequencyList;
    }
}
