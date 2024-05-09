package com.dilip.marketplace.ui.drawer.marketplace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarketPlaceViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public MarketPlaceViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
