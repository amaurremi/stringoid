package mobi.ifunny;

import com.google.android.gms.a.m;
import com.mopub.mobileads.MoPubConversionTracker;
import mobi.ifunny.b.g;
import mobi.ifunny.social.auth.l;

public class IFunnyApplication
        extends e {
    private m c;

    public m a() {
        try {
            if (this.c == null) {
                this.c = g.a(this);
            }
            m localm = this.c;
            return localm;
        } finally {
        }
    }

    public void onCreate() {
        super.onCreate();
        if (l.a().h()) {
        }
        for (String str = "authed"; ; str = "guest") {
            g.a(this, 1, str);
            d.c("IFunnyApplication", "MoPub version 3.0.0");
            new MoPubConversionTracker().reportAppOpen(this);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/IFunnyApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */