package net.hockeyapp.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import java.lang.ref.WeakReference;

final class c
        implements DialogInterface.OnClickListener {
    c(g paramg, WeakReference paramWeakReference, boolean paramBoolean) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        if (this.a != null) {
            this.a.l();
        }
        b.b(this.b);
        b.a(this.b, this.a, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */