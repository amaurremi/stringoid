package com.facebook.widget;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.Collection;

class PickerFragment$SingleSelectionStrategy
        extends PickerFragment<T>.SelectionStrategy {
    private String selectedId;

    PickerFragment$SingleSelectionStrategy(PickerFragment paramPickerFragment) {
        super(paramPickerFragment);
    }

    public void clear() {
        this.selectedId = null;
    }

    public Collection<String> getSelectedIds() {
        return Arrays.asList(new String[]{this.selectedId});
    }

    boolean isEmpty() {
        return this.selectedId == null;
    }

    boolean isSelected(String paramString) {
        return (this.selectedId != null) && (paramString != null) && (this.selectedId.equals(paramString));
    }

    void readSelectionFromBundle(Bundle paramBundle, String paramString) {
        if (paramBundle != null) {
            this.selectedId = paramBundle.getString(paramString);
        }
    }

    void saveSelectionToBundle(Bundle paramBundle, String paramString) {
        if (!TextUtils.isEmpty(this.selectedId)) {
            paramBundle.putString(paramString, this.selectedId);
        }
    }

    boolean shouldShowCheckBoxIfUnselected() {
        return false;
    }

    void toggleSelection(String paramString) {
        if ((this.selectedId != null) && (this.selectedId.equals(paramString))) {
            this.selectedId = null;
            return;
        }
        this.selectedId = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$SingleSelectionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */