package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ApplicationFocusManager$a
        extends Handler {
    private boolean a = false;

    public ApplicationFocusManager$a(Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        if ((paramMessage.what == 1001) && (this.a)) {
            this.a = false;
            ApplicationFocusManager.a(Boolean.valueOf(this.a));
        }
        while ((paramMessage.what != 1002) || (this.a)) {
            return;
        }
        this.a = true;
        ApplicationFocusManager.a(Boolean.valueOf(this.a));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ApplicationFocusManager$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */