package com.google.android.gms.a;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class al
        implements ar {
    private static al a;
    private static final Object b = new Object();
    private final Context c;
    private String d;
    private boolean e = false;
    private final Object f = new Object();

    protected al(Context paramContext) {
        this.c = paramContext;
        f();
    }

    public static al a() {
        synchronized (b) {
            al localal = a;
            return localal;
        }
    }

    public static void a(Context paramContext) {
        synchronized (b) {
            if (a == null) {
                a = new al(paramContext);
            }
            return;
        }
    }

    private boolean b(String paramString) {
        try {
            bt.c("Storing clientId.");
            FileOutputStream localFileOutputStream = this.c.openFileOutput("gaClientId", 0);
            localFileOutputStream.write(paramString.getBytes());
            localFileOutputStream.close();
            return true;
        } catch (FileNotFoundException paramString) {
            bt.a("Error creating clientId file.");
            return false;
        } catch (IOException paramString) {
            bt.a("Error writing to clientId file.");
        }
        return false;
    }

    private String e() {
        if (!this.e) {
        }
        synchronized (this.f) {
            if (!this.e) {
                bt.c("Waiting for clientId to load");
            }
            try {
                do {
                    this.f.wait();
                } while (!this.e);
                bt.c("Loaded clientId");
                return this.d;
            } catch (InterruptedException localInterruptedException) {
                for (; ; ) {
                    bt.a("Exception while waiting for clientId: " + localInterruptedException);
                }
            }
        }
    }

    private void f() {
        new am(this, "client_id_fetcher").start();
    }

    public String a(String paramString) {
        if ("&cid".equals(paramString)) {
            return e();
        }
        return null;
    }

    String b() {
        synchronized (this.f) {
            this.d = c();
            String str = this.d;
            return str;
        }
    }

    protected String c() {
        String str2 = UUID.randomUUID().toString().toLowerCase();
        String str1 = str2;
        try {
            if (!b(str2)) {
                str1 = "0";
            }
            return str1;
        } catch (Exception localException) {
        }
        return null;
    }

    String d() {
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
                bt.a("clientId file seems corrupted, deleting it.");
                localFileInputStream.close();
                this.c.deleteFile("gaClientId");
                localObject1 = localObject3;
            } catch (IOException localIOException1) {
                try {
                    FileInputStream localFileInputStream;
                    Object localObject1;
                    int i;
                    localFileInputStream.close();
                    bt.c("Loaded client id from disk.");
                } catch (IOException localIOException2) {
                    Object localObject2;
                    continue;
                } catch (FileNotFoundException localFileNotFoundException3) {
                }
                localIOException1 = localIOException1;
                localObject2 = localObject4;
                bt.a("Error reading clientId file, deleting it.");
                this.c.deleteFile("gaClientId");
                continue;
                continue;
            } catch (FileNotFoundException localFileNotFoundException1) {
                FileNotFoundException localFileNotFoundException2 = localFileNotFoundException3;
                continue;
            }
            localObject3 = localObject1;
            if (localObject1 == null) {
                localObject3 = c();
            }
            return (String) localObject3;
            if (i > 0) {
                continue;
            }
            bt.a("clientId file seems empty, deleting it.");
            localFileInputStream.close();
            this.c.deleteFile("gaClientId");
            localObject1 = localObject3;
        }
        localObject1 = new String((byte[]) localObject1, 0, i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */