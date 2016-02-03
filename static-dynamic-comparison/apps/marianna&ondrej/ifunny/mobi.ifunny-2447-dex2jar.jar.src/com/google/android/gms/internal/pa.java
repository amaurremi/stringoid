package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.a;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;

import java.io.IOException;

public class pa
        extends oj {
    protected pa(Context paramContext, qy paramqy, rk paramrk) {
        super(paramContext, paramqy, paramrk);
    }

    public static pa a(String paramString, Context paramContext) {
        gk localgk = new gk();
        a(paramString, paramContext, localgk);
        return new pa(paramContext, localgk, new sk(239));
    }

    protected void b(Context paramContext) {
        super.b(paramContext);
        try {
            Object localObject = g(paramContext);
            if (((pb) localObject).b()) {
            }
            for (long l = 1L; ; l = 0L) {
                a(28, l);
                localObject = ((pb) localObject).a();
                if (localObject != null) {
                    a(26, 5L);
                    a(24, (String) localObject);
                }
                return;
            }
            return;
        } catch (f localf) {
            a(24, d(paramContext));
            return;
        } catch (IOException paramContext) {
            return;
        } catch (ok paramContext) {
        }
    }

    pb g(Context paramContext) {
        int i = 0;
        a locala;
        try {
            locala = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
            paramContext = locala.a();
            if ((paramContext != null) && (paramContext.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"))) {
                byte[] arrayOfByte = new byte[16];
                int j = 0;
                while (i < paramContext.length()) {
                    int k;
                    if ((i != 8) && (i != 13) && (i != 18)) {
                        k = i;
                        if (i != 23) {
                        }
                    } else {
                        k = i + 1;
                    }
                    arrayOfByte[j] = ((byte) ((Character.digit(paramContext.charAt(k), 16) << 4) + Character.digit(paramContext.charAt(k + 1), 16)));
                    j += 1;
                    i = k + 2;
                }
                paramContext = this.c.a(arrayOfByte, true);
            }
        } catch (g paramContext) {
            throw new IOException(paramContext);
        } catch (SecurityException paramContext) {
            throw new IOException(paramContext);
        }
        for (; ; ) {
            return new pb(this, paramContext, locala.b());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */