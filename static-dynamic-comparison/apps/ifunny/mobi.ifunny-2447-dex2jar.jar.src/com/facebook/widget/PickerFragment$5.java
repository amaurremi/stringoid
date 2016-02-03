package com.facebook.widget;

import android.view.View;
import android.view.View.OnClickListener;

class PickerFragment$5
        implements View.OnClickListener {
    PickerFragment$5(PickerFragment paramPickerFragment) {
    }

    public void onClick(View paramView) {
        this.this$0.logAppEvents(true);
        PickerFragment.access$202(this.this$0, true);
        if (PickerFragment.access$300(this.this$0) != null) {
            PickerFragment.access$300(this.this$0).onDoneButtonClicked(this.this$0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */