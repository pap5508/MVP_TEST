package com.example.parth.mvp_test.domain.processoralgorithm;

import com.example.parth.mvp_test.model.WordData;

import java.util.List;

/**
 * Created by Parth on 12-Nov-15.
 */

public class AlgorithmChooser {
    StringProcessingAlgorithm stringProcessingAlgorithm;

    public AlgorithmChooser(StringProcessingAlgorithm stringProcessingAlgorithm) {
        this.stringProcessingAlgorithm = stringProcessingAlgorithm;
    }

    public StringProcessingAlgorithm getStringProcessingAlgorithm() {
        return stringProcessingAlgorithm;
    }

    public void setStringProcessingAlgorithm(StringProcessingAlgorithm stringProcessingAlgorithm) {
        this.stringProcessingAlgorithm = stringProcessingAlgorithm;
    }

    public List<WordData> processInputString(String inputString){
        return stringProcessingAlgorithm.processInputString(inputString);
    }


}
