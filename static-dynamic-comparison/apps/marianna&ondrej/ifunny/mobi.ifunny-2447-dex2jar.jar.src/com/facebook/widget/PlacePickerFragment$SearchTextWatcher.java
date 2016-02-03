package com.facebook.widget;

import android.text.Editable;
import android.text.TextWatcher;

class PlacePickerFragment$SearchTextWatcher
        implements TextWatcher {
    private PlacePickerFragment$SearchTextWatcher(PlacePickerFragment paramPlacePickerFragment) {
    }

    public void afterTextChanged(Editable paramEditable) {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        this.this$0.onSearchBoxTextChanged(paramCharSequence.toString(), false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PlacePickerFragment$SearchTextWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */