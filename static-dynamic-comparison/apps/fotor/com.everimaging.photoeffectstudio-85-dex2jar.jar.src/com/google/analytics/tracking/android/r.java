package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;

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

class r
        extends Thread
        implements e {
    private static r g;
    private final LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private volatile boolean b = false;
    private volatile boolean c = false;
    private volatile List<Command> d;
    private volatile String e;
    private volatile String f;
    private volatile ae h;
    private final Context i;

    private r(Context paramContext) {
        super("GAThread");
        if (paramContext != null) {
        }
        for (this.i = paramContext.getApplicationContext(); ; this.i = paramContext) {
            start();
            return;
        }
    }

    static int a(String paramString) {
        int m = 1;
        if (!TextUtils.isEmpty(paramString)) {
            int k = paramString.length();
            int j = 0;
            k -= 1;
            for (; ; ) {
                m = j;
                if (k < 0) {
                    break;
                }
                m = paramString.charAt(k);
                m = (j << 6 & 0xFFFFFFF) + m + (m << 14);
                int n = 0xFE00000 & m;
                j = m;
                if (n != 0) {
                    j = m ^ n >> 21;
                }
                k -= 1;
            }
        }
        return m;
    }

    static r a(Context paramContext) {
        if (g == null) {
            g = new r(paramContext);
        }
        return g;
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
            j = ((FileInputStream) localObject).read(arrayOfByte, 0, 8192);
            if (((FileInputStream) localObject).available() > 0) {
                v.a("Too much campaign data, ignoring it.");
                ((FileInputStream) localObject).close();
                paramContext.deleteFile("gaInstallData");
                return null;
            }
            ((FileInputStream) localObject).close();
            paramContext.deleteFile("gaInstallData");
            if (j <= 0) {
                v.d("Campaign file is empty.");
                return null;
            }
        } catch (FileNotFoundException paramContext) {
            byte[] arrayOfByte;
            int j;
            v.b("No campaign data found.");
            return null;
            Object localObject = new String(arrayOfByte, 0, j);
            v.b("Campaign found: " + (String) localObject);
            return (String) localObject;
        } catch (IOException localIOException) {
            v.a("Error reading campaign data.");
            paramContext.deleteFile("gaInstallData");
        }
        return null;
    }

    private String b(Map<String, String> paramMap) {
        if (paramMap.containsKey("useSecure")) {
            if (aj.a((String) paramMap.get("useSecure"), true)) {
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
        double d1 = aj.a((String) paramMap.get("&sf"), 100.0D);
        if (d1 >= 100.0D) {
            return false;
        }
        if (a((String) paramMap.get("&cid")) % 10000 >= d1 * 100.0D) {
            if (paramMap.get("&t") == null) {
            }
            for (paramMap = "unknown"; ; paramMap = (String) paramMap.get("&t")) {
                v.c(String.format("%s hit sampled out", new Object[]{paramMap}));
                return true;
            }
        }
        return false;
    }

    private void d(Map<String, String> paramMap) {
        f localf = f.a();
        aj.a(paramMap, "&an", localf.a("&an"));
        aj.a(paramMap, "&av", localf.a("&av"));
        aj.a(paramMap, "&aid", localf.a("&aid"));
        aj.a(paramMap, "&aiid", localf.a("&aiid"));
        paramMap.put("&v", "1");
    }

    public void a() {
        a(new Runnable() {
            public void run() {
                r.e(r.this).c();
            }
        });
    }

    void a(Runnable paramRunnable) {
        this.a.add(paramRunnable);
    }

    public void a(Map<String, String> paramMap) {
        final HashMap localHashMap = new HashMap(paramMap);
        String str = (String) paramMap.get("&ht");
        paramMap = str;
        if (str != null) {
        }
        try {
            Long.valueOf(str).longValue();
            paramMap = str;
        } catch (NumberFormatException paramMap) {
            for (; ; ) {
                paramMap = null;
            }
        }
        if (paramMap == null) {
            localHashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        a(new Runnable() {
            public void run() {
                if (TextUtils.isEmpty((CharSequence) localHashMap.get("&cid"))) {
                    localHashMap.put("&cid", r.a(r.this));
                }
                if ((s.a(r.b(r.this)).c()) || (r.a(r.this, localHashMap))) {
                    return;
                }
                if (!TextUtils.isEmpty(r.c(r.this))) {
                    GAUsage.a().a(true);
                    localHashMap.putAll(new w().a(r.c(r.this)).a());
                    GAUsage.a().a(false);
                    r.a(r.this, null);
                }
                r.b(r.this, localHashMap);
                Map localMap = u.a(localHashMap);
                r.e(r.this).a(localMap, Long.valueOf((String) localHashMap.get("&ht")).longValue(), r.c(r.this, localHashMap), r.d(r.this));
            }
        });
    }

    public void b() {
        a(new Runnable() {
            public void run() {
                r.e(r.this).e();
            }
        });
    }

    public LinkedBlockingQueue<Runnable> c() {
        return this.a;
    }

    public Thread d() {
        return this;
    }

    protected void e() {
        this.h.f();
        this.d = new ArrayList();
        this.d.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.2"));
        this.d.add(new Command("appendQueueTime", "&qt".substring(1), null));
        this.d.add(new Command("appendCacheBuster", "&z".substring(1), null));
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            for (; ; ) {
                try {
                    if (this.h == null) {
                        this.h = new GAServiceProxy(this.i, this);
                    }
                    e();
                    this.f = g.a().a("&cid");
                    this.e = b(this.i);
                } catch (Throwable localThrowable2) {
                    v.a("Error initializing the GAThread: " + a(localThrowable2));
                    v.a("Google Analytics will not start up.");
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
                    v.b(localInterruptedException1.toString());
                } catch (Throwable localThrowable1) {
                    v.a("Error on GAThread: " + a(localThrowable1));
                    v.a("Google Analytics is shutting down.");
                    this.b = true;
                }
            }
        } catch (InterruptedException localInterruptedException2) {
            for (; ; ) {
                v.d("sleep interrupted in GAThread initialize");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */