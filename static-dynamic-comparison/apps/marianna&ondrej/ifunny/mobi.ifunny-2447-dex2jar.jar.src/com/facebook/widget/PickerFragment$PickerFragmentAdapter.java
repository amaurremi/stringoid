package com.facebook.widget;

import android.content.Context;
import android.widget.CheckBox;
import com.facebook.model.GraphObject;

abstract class PickerFragment$PickerFragmentAdapter<U extends GraphObject>
        extends GraphObjectAdapter<T> {
    public PickerFragment$PickerFragmentAdapter(PickerFragment paramPickerFragment, Context paramContext) {
        super(paramContext);
    }

    boolean isGraphObjectSelected(String paramString) {
        return PickerFragment.access$700(this.this$0).isSelected(paramString);
    }

    void updateCheckboxState(CheckBox paramCheckBox, boolean paramBoolean) {
        paramCheckBox.setChecked(paramBoolean);
        if ((paramBoolean) || (PickerFragment.access$700(this.this$0).shouldShowCheckBoxIfUnselected())) {
        }
        for (int i = 0; ; i = 8) {
            paramCheckBox.setVisibility(i);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$PickerFragmentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */