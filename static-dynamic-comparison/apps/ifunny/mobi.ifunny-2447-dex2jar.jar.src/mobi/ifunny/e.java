package mobi.ifunny;

import android.app.Application;
import com.facebook.AppEventsLogger;
import com.facebook.Settings;

import java.util.ArrayList;
import java.util.Iterator;

import mobi.ifunny.rest.otherside.OthersRetrofit;
import mobi.ifunny.rest.retrofit.NotificationListener;
import mobi.ifunny.rest.retrofit.RestNotification;
import mobi.ifunny.rest.retrofit.Retrofit;
import mobi.ifunny.util.ah;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.l;

public abstract class e
        extends Application
        implements NotificationListener {
    public static e a;
    public static IFunnyCache b;
    private final ArrayList<c> c = new ArrayList();

    public void a(c paramc) {
        this.c.add(paramc);
    }

    public void b(c paramc) {
        this.c.remove(paramc);
    }

    public void onCreate() {
        super.onCreate();
        a = this;
        ah.a(this);
        h.a(this);
        g.a(this);
        Retrofit.init(this);
        OthersRetrofit.init(this);
        b = new IFunnyCache();
        l.a(this);
        try {
            if (Settings.getAttributionId(getContentResolver()) != null) {
                AppEventsLogger.activateApp(this, getString(2131689612));
            }
            return;
        } catch (IllegalStateException localIllegalStateException) {
        }
    }

    public void onLowMemory() {
        d.d("IFunnyApplication", "onLowMemory");
        super.onLowMemory();
    }

    public void onNotification(RestNotification paramRestNotification) {
        d.c("IFunnyApplication", "onNotification " + paramRestNotification);
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            ((c) localIterator.next()).a(paramRestNotification.counters);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */