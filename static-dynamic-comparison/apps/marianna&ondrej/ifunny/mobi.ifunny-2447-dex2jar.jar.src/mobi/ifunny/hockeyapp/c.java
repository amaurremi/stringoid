package mobi.ifunny.hockeyapp;

import android.content.Intent;
import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.e;
import mobi.ifunny.h;
import net.hockeyapp.android.g;

public class c
        extends g {
    public void a() {
        super.a();
        long l = System.currentTimeMillis();
        if (l - h.a().a("pref.last.message.about.crash", 0L) > 604800000L) {
            Intent localIntent = new Intent(IFunnyApplication.a, CrashExplanationActivity.class);
            localIntent.setFlags(268435456);
            IFunnyApplication.a.startActivity(localIntent);
            h.a().b("pref.last.message.about.crash", l);
        }
        h.a().b("pref.last_crash_time", l);
    }

    public boolean b() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/hockeyapp/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */