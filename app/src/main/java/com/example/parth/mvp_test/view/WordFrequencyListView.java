package com.example.parth.mvp_test.view;

import com.example.parth.mvp_test.model.WordData;

import java.util.List;

/**
 * Created by Parth on 12-Nov-15.
 */
public interface WordFrequencyListView extends RootView {

    void setWordFrequencyList(List<WordData> wordFrequencyList);
}
