package mobi.ifunny.b;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.a;

import java.io.IOException;

import mobi.ifunny.d;

final class f
        implements Runnable {
    f(Context paramContext, com.mobileapptracker.g paramg) {
    }

    public void run() {
        try {
            a locala = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
            this.b.a(locala.a(), locala.b());
            return;
        } catch (IOException localIOException) {
            d.b(e.a, "Unable to run Mobile App Tracking thread", localIOException);
            return;
        } catch (com.google.android.gms.common.f localf) {
            for (; ; ) {
            }
        } catch (com.google.android.gms.common.g localg) {
            for (; ; ) {
            }
        } catch (SecurityException localSecurityException) {
            for (; ; ) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */