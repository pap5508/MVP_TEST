package com.example.parth.mvp_test.androidInterface;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.parth.mvp_test.R;
import com.example.parth.mvp_test.model.WordData;
import com.example.parth.mvp_test.presentator.WordFrequencyListPresenter;
import com.example.parth.mvp_test.presentator.WordFrequencyListPresenterImplementation;
import com.example.parth.mvp_test.view.WordFrequencyListView;

import java.util.List;

/**
 * Created by Parth on 12-Nov-15.
 */

public class MainActivity extends ActionBarActivity implements WordFrequencyListView {

    RecyclerView mAuctionRecyclerView;
    WordFrequencyMapAdapter mWordFrequencyMapAdapter;
    Button mTextInputButton,mRestInputButton;
    TextInputLayout mInputStringEditText;

    WordFrequencyListPresenter wordFrequencyListPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuctionRecyclerView = (RecyclerView) findViewById(R.id.wordfrequencymap_recyclerview);
        mTextInputButton = (Button) findViewById(R.id.textbox_input_button);
        mRestInputButton = (Button) findViewById(R.id.rest_input_button);
        mInputStringEditText = (TextInputLayout) findViewById(R.id.input_string_edittext);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAuctionRecyclerView.setLayoutManager(layoutManager);
        mAuctionRecyclerView.setHasFixedSize(true);

        wordFrequencyListPresenter = new WordFrequencyListPresenterImplementation();
        wordFrequencyListPresenter.setView(this);


        mTextInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearAdapter();
                if(mInputStringEditText.getEditText().getText().toString().trim().length() == 0) {
                    mInputStringEditText.setErrorEnabled(true);
                    mInputStringEditText.setError(getString(R.string.input_validation));
                    mInputStringEditText.requestFocus();
                }else{
                    getWordFrequencyList(mInputStringEditText.getEditText().getText().toString());
                }
            }
        });

        mRestInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearAdapter();
                setProgressBarIndeterminateVisibility(true);
                getWordFrequencyRestList();
            }
        });
    }

    private void getWordFrequencyList(String inputString) {
        wordFrequencyListPresenter.getWordFrequencyList(inputString);
    }

    private void getWordFrequencyRestList() {
        wordFrequencyListPresenter.getWordFrequencyListByRest();
    }

    @Override
    public void setWordFrequencyList(List<WordData> wordFrequencyList) {
        setProgressBarIndeterminateVisibility(false);
        mWordFrequencyMapAdapter = new WordFrequencyMapAdapter(wordFrequencyList);
        mAuctionRecyclerView.setAdapter(mWordFrequencyMapAdapter);
        mAuctionRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void ClearAdapter() {
        mWordFrequencyMapAdapter = null;
        mAuctionRecyclerView.setAdapter(mWordFrequencyMapAdapter);
        mAuctionRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public Context getContext() {
        return null;
    }
}
