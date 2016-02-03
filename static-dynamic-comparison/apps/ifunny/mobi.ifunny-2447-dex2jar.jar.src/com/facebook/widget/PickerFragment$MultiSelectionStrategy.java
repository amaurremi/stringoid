package com.facebook.widget;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class PickerFragment$MultiSelectionStrategy
        extends PickerFragment<T>.SelectionStrategy {
    private Set<String> selectedIds = new HashSet();

    PickerFragment$MultiSelectionStrategy(PickerFragment paramPickerFragment) {
        super(paramPickerFragment);
    }

    public void clear() {
        this.selectedIds.clear();
    }

    public Collection<String> getSelectedIds() {
        return this.selectedIds;
    }

    boolean isEmpty() {
        return this.selectedIds.isEmpty();
    }

    boolean isSelected(String paramString) {
        return (paramString != null) && (this.selectedIds.contains(paramString));
    }

    void readSelectionFromBundle(Bundle paramBundle, String paramString) {
        if (paramBundle != null) {
            paramBundle = paramBundle.getString(paramString);
            if (paramBundle != null) {
                paramBundle = TextUtils.split(paramBundle, ",");
                this.selectedIds.clear();
                Collections.addAll(this.selectedIds, paramBundle);
            }
        }
    }

    void saveSelectionToBundle(Bundle paramBundle, String paramString) {
        if (!this.selectedIds.isEmpty()) {
            paramBundle.putString(paramString, TextUtils.join(",", this.selectedIds));
        }
    }

    boolean shouldShowCheckBoxIfUnselected() {
        return true;
    }

    void toggleSelection(String paramString) {
        if (paramString != null) {
            if (this.selectedIds.contains(paramString)) {
                this.selectedIds.remove(paramString);
            }
        } else {
            return;
        }
        this.selectedIds.add(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$MultiSelectionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */