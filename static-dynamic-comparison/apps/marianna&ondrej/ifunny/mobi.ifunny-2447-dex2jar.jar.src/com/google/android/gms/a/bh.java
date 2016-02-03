package com.google.android.gms.a;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.hb;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class bh
        extends Thread
        implements aj {
    private static bh f;
    private final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private volatile boolean b = false;
    private volatile boolean c = false;
    private volatile List<hb> d;
    private volatile String e;
    private volatile w g;
    private final Context h;

    private bh(Context paramContext) {
        super("GAThread");
        if (paramContext != null) {
        }
        for (this.h = paramContext.getApplicationContext(); ; this.h = paramContext) {
            start();
            return;
        }
    }

    static int a(String paramString) {
        int k = 1;
        if (!TextUtils.isEmpty(paramString)) {
            int j = paramString.length();
            int i = 0;
            j -= 1;
            for (; ; ) {
                k = i;
                if (j < 0) {
                    break;
                }
                k = paramString.charAt(j);
                k = (i << 6 & 0xFFFFFFF) + k + (k << 14);
                int m = 0xFE00000 & k;
                i = k;
                if (m != 0) {
                    i = k ^ m >> 21;
                }
                j -= 1;
            }
        }
        return k;
    }

    static bh a(Context paramContext) {
        if (f == null) {
            f = new bh(paramContext);
        }
        return f;
    }

    private String a(Throwable paramThrowable) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
        paramThrowable.printStackTrace(localPrintStream);
        localPrintStream.flush();
        return new String(localByteArrayOutputStream.toByteArray());
    }

    static String b(Context paramContext) {
        try {
            localObject = paramContext.openFileInput("gaInstallData");
            arrayOfByte = new byte[' '];
            i = ((FileInputStream) localObject).read(arrayOfByte, 0, 8192);
            if (((FileInputStream) localObject).available() > 0) {
                bt.a("Too much campaign data, ignoring it.");
                ((FileInputStream) localObject).close();
                paramContext.deleteFile("gaInstallData");
                return null;
            }
            ((FileInputStream) localObject).close();
            paramContext.deleteFile("gaInstallData");
            if (i <= 0) {
                bt.d("Campaign file is empty.");
                return null;
            }
        } catch (FileNotFoundException paramContext) {
            byte[] arrayOfByte;
            int i;
            bt.b("No campaign data found.");
            return null;
            Object localObject = new String(arrayOfByte, 0, i);
            bt.b("Campaign found: " + (String) localObject);
            return (String) localObject;
        } catch (IOException localIOException) {
            bt.a("Error reading campaign data.");
            paramContext.deleteFile("gaInstallData");
        }
        return null;
    }

    private String b(Map<String, String> paramMap) {
        if (paramMap.containsKey("useSecure")) {
            if (ab.a((String) paramMap.get("useSecure"), true)) {
                return "https:";
            }
            return "http:";
        }
        return "https:";
    }

    private boolean c(Map<String, String> paramMap) {
        if (paramMap.get("&sf") == null) {
            return false;
        }
        double d1 = ab.a((String) paramMap.get("&sf"), 100.0D);
        if (d1 >= 100.0D) {
            return false;
        }
        if (a((String) paramMap.get("&cid")) % 10000 >= d1 * 100.0D) {
            if (paramMap.get("&t") == null) {
            }
            for (paramMap = "unknown"; ; paramMap = (String) paramMap.get("&t")) {
                bt.c(String.format("%s hit sampled out", new Object[]{paramMap}));
                return true;
            }
        }
        return false;
    }

    private void d(Map<String, String> paramMap) {
        ar localar = p.a(this.h);
        ab.a(paramMap, "&adid", localar);
        ab.a(paramMap, "&ate", localar);
    }

    private void e(Map<String, String> paramMap) {
        ak localak = ak.a();
        ab.a(paramMap, "&an", localak);
        ab.a(paramMap, "&av", localak);
        ab.a(paramMap, "&aid", localak);
        ab.a(paramMap, "&aiid", localak);
        paramMap.put("&v", "1");
    }

    public void a() {
        a(new bj(this));
    }

    void a(Runnable paramRunnable) {
        this.a.add(paramRunnable);
    }

    public void a(Map<String, String> paramMap) {
        HashMap localHashMap = new HashMap(paramMap);
        String str = (String) paramMap.get("&ht");
        paramMap = str;
        if (str != null) {
        }
        try {
            Long.valueOf(str);
            paramMap = str;
        } catch (NumberFormatException paramMap) {
            for (; ; ) {
                paramMap = null;
            }
        }
        if (paramMap == null) {
            localHashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        a(new bi(this, localHashMap));
    }

    public void b() {
        a(new bk(this));
    }

    public LinkedBlockingQueue<Runnable> c() {
        return this.a;
    }

    public Thread d() {
        return this;
    }

    protected void e() {
        this.g.c();
        this.d = new ArrayList();
        this.d.add(new hb("appendVersion", "&_v".substring(1), "ma4.0.3"));
        this.d.add(new hb("appendQueueTime", "&qt".substring(1), null));
        this.d.add(new hb("appendCacheBuster", "&z".substring(1), null));
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000L);
            for (; ; ) {
                try {
                    if (this.g == null) {
                        this.g = new az(this.h, this);
                    }
                    e();
                    this.e = b(this.h);
                    bt.c("Initialized GA Thread");
                } catch (Throwable localThrowable2) {
                    bt.a("Error initializing the GAThread: " + a(localThrowable2));
                    bt.a("Google Analytics will not start up.");
                    this.b = true;
                    continue;
                }
                if (this.c) {
                    return;
                }
                try {
                    Runnable localRunnable = (Runnable) this.a.take();
                    if (!this.b) {
                        localRunnable.run();
                    }
                } catch (InterruptedException localInterruptedException1) {
                    bt.b(localInterruptedException1.toString());
                } catch (Throwable localThrowable1) {
                    bt.a("Error on GAThread: " + a(localThrowable1));
                    bt.a("Google Analytics is shutting down.");
                    this.b = true;
                }
            }
        } catch (InterruptedException localInterruptedException2) {
            for (; ; ) {
                bt.d("sleep interrupted in GAThread initialize");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */