package com.example.library.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListBookViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ListBookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ListBookViewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
