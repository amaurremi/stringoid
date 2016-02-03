package mobi.ifunny.j;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.h;
import mobi.ifunny.util.ai;

class d
        implements DialogInterface.OnClickListener {
    d(a parama, Activity paramActivity) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        h.a().b("rate.last_rated_version", "4.0");
        ai.a(this.a);
        a.a(this.b, this.a, "rate_app", "alert_navigation_to_store");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/j/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */