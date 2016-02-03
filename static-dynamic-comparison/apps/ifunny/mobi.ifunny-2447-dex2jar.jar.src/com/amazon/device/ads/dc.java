package com.amazon.device.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.a;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;

import java.io.IOException;

class dc {
    private static final String a = dc.class.getSimpleName();

    public db a() {
        Object localObject = dn.i().h();
        try {
            localObject = AdvertisingIdClient.getAdvertisingIdInfo((Context) localObject);
            dv.a(a, "The Google Play Services Advertising Identifier was successfully retrieved.");
            String str = ((a) localObject).a();
            boolean bool = ((a) localObject).b();
            return new db().a(str).a(bool);
        } catch (IllegalStateException localIllegalStateException) {
            dv.c(a, "The Google Play Services Advertising Id API was called from a non-background thread.");
            return new db();
        } catch (IOException localIOException) {
            dv.c(a, "Retrieving the Google Play Services Advertising Identifier caused an IOException.");
            return new db();
        } catch (f localf) {
            dv.a(a, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return db.a();
        } catch (g localg) {
            dv.a(a, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
        }
        return new db();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */