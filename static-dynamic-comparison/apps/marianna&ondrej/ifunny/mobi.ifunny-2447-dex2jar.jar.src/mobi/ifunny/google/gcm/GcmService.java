package mobi.ifunny.google.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.gcm.a;
import mobi.ifunny.d;
import mobi.ifunny.h;
import mobi.ifunny.util.af;

public class GcmService
        extends IntentService {
    private static final String a = GcmService.class.getSimpleName();

    public GcmService() {
        super(a);
    }

    protected void onHandleIntent(Intent paramIntent) {
        int j = 0;
        d.c(a, "onHandleIntent: " + paramIntent);
        String str1 = a.a(this).a(paramIntent);
        Object localObject = paramIntent.getExtras();
        int i;
        if ((str1 != null) && (!((Bundle) localObject).isEmpty())) {
            d.c(a, "process " + str1 + '\n' + ((Bundle) localObject).toString());
            i = -1;
            switch (str1.hashCode()) {
                default:
                    switch (i) {
                    }
                    break;
            }
        }
        for (; ; ) {
            GcmReceiver.a(paramIntent);
            return;
            if (!str1.equals("gcm")) {
                break;
            }
            i = 0;
            break;
            str1 = ((Bundle) localObject).getString("ticker");
            String str2 = ((Bundle) localObject).getString("title");
            String str3 = ((Bundle) localObject).getString("text");
            localObject = ((Bundle) localObject).getString("num_new_featured");
            try {
                i = Integer.valueOf((String) localObject).intValue();
                localObject = h.a();
                ((h) localObject).b("pref.push.featured_count", i);
                if (((h) localObject).a("pref.push.notifications", true)) {
                    af.a(this, str1, str2, str3);
                }
                if ((!((h) localObject).a("pref.push.badges", true)) || (i <= 0)) {
                    continue;
                }
                af.a(this, i);
            } catch (NumberFormatException localNumberFormatException) {
                for (; ; ) {
                    i = j;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/google/gcm/GcmService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */