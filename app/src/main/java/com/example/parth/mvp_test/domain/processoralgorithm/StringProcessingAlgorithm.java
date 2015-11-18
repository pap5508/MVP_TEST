package com.example.parth.mvp_test.domain.processoralgorithm;

import com.example.parth.mvp_test.model.WordData;

import java.util.List;

/**
 * Created by Parth on 12-Nov-15.
 */

public interface StringProcessingAlgorithm {

    /**
     * processInputString
     *
     * @param inputString
     * @return
     */
    public List<WordData> processInputString(String inputString);
}
