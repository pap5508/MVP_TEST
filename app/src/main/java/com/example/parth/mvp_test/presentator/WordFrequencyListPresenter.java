package com.example.parth.mvp_test.presentator;

import com.example.parth.mvp_test.view.WordFrequencyListView;

/**
 * Created by Parth on 12-Nov-15.
 */

public interface WordFrequencyListPresenter extends RootPresenter<WordFrequencyListView> {

    void getWordFrequencyList(String inputString);

    void getWordFrequencyListByRest();
}
