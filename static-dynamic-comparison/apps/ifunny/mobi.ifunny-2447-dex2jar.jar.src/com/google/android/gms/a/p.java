package com.google.android.gms.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.a;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class p
        implements ar {
    private static Object a = new Object();
    private static p b;
    private a c;
    private long d;
    private Context e;
    private String f;
    private boolean g = false;
    private Object h = new Object();

    p(Context paramContext) {
        this.e = paramContext.getApplicationContext();
    }

    public static ar a(Context paramContext) {
        if (b == null) {
        }
        synchronized (a) {
            if (b == null) {
                b = new p(paramContext);
            }
            return b;
        }
    }

    private boolean a(a parama1, a parama2) {
        Object localObject1 = null;
        if (parama2 == null) {
        }
        for (parama2 = null; TextUtils.isEmpty(parama2); parama2 = parama2.a()) {
            return true;
        }
        al.a(this.e);
        al localal = al.a();
        String str = localal.a("&cid");
        boolean bool;
        for (; ; ) {
            synchronized (this.h) {
                if (!this.g) {
                    this.f = b(this.e);
                    this.g = true;
                    parama1 = b(parama2 + str);
                    if (!TextUtils.isEmpty(parama1)) {
                        break;
                    }
                    return false;
                }
            }
            if (TextUtils.isEmpty(this.f)) {
                if (parama1 == null) {
                }
                for (parama1 = (a) localObject1; parama1 == null; parama1 = parama1.a()) {
                    bool = c(parama2 + str);
                    return bool;
                }
                this.f = b(parama1 + str);
            }
        }
        if (parama1.equals(this.f)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.f)) {
            bt.c("Resetting the client id because Advertising Id changed.");
            parama1 = localal.b();
            bt.c("New client Id: " + parama1);
        }
        for (; ; ) {
            bool = c(parama2 + parama1);
            return bool;
            parama1 = str;
        }
    }

    static String b(Context paramContext) {
        String str = null;
        try {
            FileInputStream localFileInputStream = paramContext.openFileInput("gaClientIdData");
            Object localObject2 = new byte[''];
            int i = localFileInputStream.read((byte[]) localObject2, 0, 128);
            if (localFileInputStream.available() > 0) {
                bt.d("Hash file seems corrupted, deleting it.");
                localFileInputStream.close();
                paramContext.deleteFile("gaClientIdData");
                return null;
            }
            if (i <= 0) {
                bt.b("Hash file is empty.");
                localFileInputStream.close();
                return null;
            }
            localObject2 = new String((byte[]) localObject2, 0, i);
            Object localObject1;
            return null;
        } catch (IOException localIOException2) {
            try {
                localFileInputStream.close();
                return (String) localObject2;
            } catch (IOException localIOException1) {
                for (; ; ) {
                    localObject1 = localIOException2;
                }
            } catch (FileNotFoundException paramContext) {
                return localIOException2;
            }
            localIOException2 = localIOException2;
            bt.d("Error reading Hash file, deleting it.");
            paramContext.deleteFile("gaClientIdData");
            return str;
        } catch (FileNotFoundException paramContext) {
        }
    }

    static String b(String paramString) {
        MessageDigest localMessageDigest = ab.c("MD5");
        if (localMessageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, localMessageDigest.digest(paramString.getBytes()))});
    }

    private boolean c(String paramString) {
        try {
            paramString = b(paramString);
            bt.c("Storing hashed adid.");
            FileOutputStream localFileOutputStream = this.e.openFileOutput("gaClientIdData", 0);
            localFileOutputStream.write(paramString.getBytes());
            localFileOutputStream.close();
            this.f = paramString;
            return true;
        } catch (FileNotFoundException paramString) {
            bt.a("Error creating hash file.");
            return false;
        } catch (IOException paramString) {
            bt.a("Error writing to hash file.");
        }
        return false;
    }

    a a() {
        try {
            a locala = AdvertisingIdClient.getAdvertisingIdInfo(this.e);
            return locala;
        } catch (IllegalStateException localIllegalStateException) {
            bt.d("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (g localg) {
            bt.d("GooglePlayServicesRepairableException getting Ad Id Info");
            return null;
        } catch (IOException localIOException) {
            bt.d("IOException getting Ad Id Info");
            return null;
        } catch (f localf) {
            bt.d("GooglePlayServicesNotAvailableException getting Ad Id Info");
            return null;
        } catch (Throwable localThrowable) {
            bt.d("Unknown exception. Could not get the ad Id.");
        }
        return null;
    }

    public String a(String paramString) {
        long l = System.currentTimeMillis();
        a locala;
        if (l - this.d > 1000L) {
            locala = a();
            if (!a(this.c, locala)) {
                break label71;
            }
        }
        label71:
        for (this.c = locala; ; this.c = new a("", false)) {
            this.d = l;
            if (this.c == null) {
                break label114;
            }
            if (!"&adid".equals(paramString)) {
                break;
            }
            return this.c.a();
        }
        if ("&ate".equals(paramString)) {
            if (this.c.b()) {
                return "0";
            }
            return "1";
        }
        label114:
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */