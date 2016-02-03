package com.facebook.widget;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class PickerFragment$4
        implements Session.StatusCallback {
    PickerFragment$4(PickerFragment paramPickerFragment) {
    }

    public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
        if (!paramSession.isOpened()) {
            PickerFragment.access$100(this.this$0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */