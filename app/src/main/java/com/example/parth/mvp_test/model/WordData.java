package com.example.parth.mvp_test.model;


import java.util.Comparator;

/**
 * Created by Parth on 12-Nov-15.
 */
public class WordData implements Comparable<WordData>{
    // Represents the data we need about a word:  the word and
    // the number of times it has been encountered.
    public String word;
    public int count;

    public WordData(String w) {
        // Constructor for creating a WordData object when
        // we encounter a new word.
        word = w;
        count = 1;  // The initial value of count is 1.
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(WordData wordData) {
        int compareFrequency = ((WordData) wordData).getCount();
        // Descending order
        return compareFrequency - this.count;
    }

    /**
     * WordNameComparator - To make alphabetical sorting.
     */
    public static Comparator<WordData> WordNameComparator
            = new Comparator<WordData>() {
        @Override
        public int compare(WordData wordData1, WordData wordData2) {

            String word1 = wordData1.getWord();
            String word2 = wordData2.getWord();

            //ascending order sort by word name.
            return wordData1.compareTo(wordData2);
        }
    };

}
