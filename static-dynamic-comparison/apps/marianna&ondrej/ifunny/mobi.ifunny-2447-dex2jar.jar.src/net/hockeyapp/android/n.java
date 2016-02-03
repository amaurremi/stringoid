package net.hockeyapp.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class n
        implements DialogInterface.OnClickListener {
    n(UpdateActivity paramUpdateActivity) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        UpdateActivity.a(this.a, null);
        paramDialogInterface.cancel();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */