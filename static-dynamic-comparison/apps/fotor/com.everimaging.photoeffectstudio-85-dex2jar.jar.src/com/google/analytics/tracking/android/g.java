package com.google.analytics.tracking.android;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class g
        implements j {
    private static g a;
    private static final Object b = new Object();
    private final Context c;
    private String d;
    private boolean e = false;
    private final Object f = new Object();

    protected g(Context paramContext) {
        this.c = paramContext;
        e();
    }

    public static g a() {
        synchronized (b) {
            g localg = a;
            return localg;
        }
    }

    public static void a(Context paramContext) {
        synchronized (b) {
            if (a == null) {
                a = new g(paramContext);
            }
            return;
        }
    }

    private boolean b(String paramString) {
        try {
            v.c("Storing clientId.");
            FileOutputStream localFileOutputStream = this.c.openFileOutput("gaClientId", 0);
            localFileOutputStream.write(paramString.getBytes());
            localFileOutputStream.close();
            return true;
        } catch (FileNotFoundException paramString) {
            v.a("Error creating clientId file.");
            return false;
        } catch (IOException paramString) {
            v.a("Error writing to clientId file.");
        }
        return false;
    }

    private String d() {
        if (!this.e) {
        }
        synchronized (this.f) {
            if (!this.e) {
                v.c("Waiting for clientId to load");
            }
            try {
                do {
                    this.f.wait();
                } while (!this.e);
                v.c("Loaded clientId");
                return this.d;
            } catch (InterruptedException localInterruptedException) {
                for (; ; ) {
                    v.a("Exception while waiting for clientId: " + localInterruptedException);
                }
            }
        }
    }

    private void e() {
        new Thread("client_id_fetcher") {
            public void run() {
                synchronized (g.a(g.this)) {
                    g.a(g.this, g.this.c());
                    g.a(g.this, true);
                    g.a(g.this).notifyAll();
                    return;
                }
            }
        }.start();
    }

    public String a(String paramString) {
        if ("&cid".equals(paramString)) {
            return d();
        }
        return null;
    }

    protected String b() {
        String str2 = UUID.randomUUID().toString().toLowerCase();
        String str1 = str2;
        if (!b(str2)) {
            str1 = "0";
        }
        return str1;
    }

    String c() {
        localObject4 = null;
        Object localObject3 = null;
        for (; ; ) {
            try {
                localFileInputStream = this.c.openFileInput("gaClientId");
                localObject1 = new byte[''];
                i = localFileInputStream.read((byte[]) localObject1, 0, 128);
                if (localFileInputStream.available() <= 0) {
                    continue;
                }
                v.a("clientId file seems corrupted, deleting it.");
                localFileInputStream.close();
                this.c.deleteFile("gaClientId");
                localObject1 = localObject3;
            } catch (IOException localIOException1) {
                try {
                    FileInputStream localFileInputStream;
                    Object localObject1;
                    int i;
                    localFileInputStream.close();
                } catch (IOException localIOException2) {
                    Object localObject2;
                    continue;
                } catch (FileNotFoundException localFileNotFoundException3) {
                }
                localIOException1 = localIOException1;
                localObject2 = localObject4;
                v.a("Error reading clientId file, deleting it.");
                this.c.deleteFile("gaClientId");
                continue;
                continue;
            } catch (FileNotFoundException localFileNotFoundException1) {
                FileNotFoundException localFileNotFoundException2 = localFileNotFoundException3;
                continue;
            }
            localObject3 = localObject1;
            if (localObject1 == null) {
                localObject3 = b();
            }
            return (String) localObject3;
            if (i > 0) {
                continue;
            }
            v.a("clientId file seems empty, deleting it.");
            localFileInputStream.close();
            this.c.deleteFile("gaClientId");
            localObject1 = localObject3;
        }
        localObject1 = new String((byte[]) localObject1, 0, i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */