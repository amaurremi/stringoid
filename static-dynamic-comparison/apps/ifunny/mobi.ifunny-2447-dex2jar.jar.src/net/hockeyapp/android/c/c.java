package net.hockeyapp.android.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import java.lang.ref.WeakReference;

import net.hockeyapp.android.d.e;
import net.hockeyapp.android.r;
import org.json.JSONArray;

class c
        implements DialogInterface.OnClickListener {
    c(a parama, JSONArray paramJSONArray) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        if (this.b.b()) {
            e.a(a.b(this.b), "[]");
        }
        paramDialogInterface = new WeakReference(a.b(this.b));
        if ((r.a().booleanValue()) && (r.a(paramDialogInterface).booleanValue())) {
            a.a(this.b, this.a);
            return;
        }
        a.a(this.b, this.a, Boolean.valueOf(false));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */