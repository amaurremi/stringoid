package mobi.ifunny.j;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.h;

class c
        implements DialogInterface.OnClickListener {
    c(a parama, Activity paramActivity) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        h.a().b("rate.dont_remind", true);
        a.a(this.b, this.a, "rate_app", "alert_hide_permanent");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/j/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */