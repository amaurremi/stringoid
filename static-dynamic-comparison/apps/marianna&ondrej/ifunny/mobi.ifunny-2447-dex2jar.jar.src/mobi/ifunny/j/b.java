package mobi.ifunny.j;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.h;

class b
        implements DialogInterface.OnClickListener {
    b(a parama, Activity paramActivity) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        h.a().b("rate.last_check", System.currentTimeMillis());
        a.a(this.b, this.a, "rate_app", "alert_hide");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */