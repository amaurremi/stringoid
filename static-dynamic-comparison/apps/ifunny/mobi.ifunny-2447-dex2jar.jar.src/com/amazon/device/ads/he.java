package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class he {
    private static final String a = he.class.getSimpleName();
    private static he b = new he();
    private ArrayList<hh> c = new ArrayList();
    private final ReentrantLock d = new ReentrantLock();
    private final ReentrantLock e = new ReentrantLock();
    private final ConcurrentHashMap<String, hj> f = new ConcurrentHashMap();
    private SharedPreferences g;
    private final CountDownLatch h = new CountDownLatch(1);

    public static he a() {
        return b;
    }

    private void a(SharedPreferences.Editor paramEditor) {
        if (ho.a()) {
            dv.c(a, "Committing settings must be executed on a background thread.");
        }
        if (Build.VERSION.SDK_INT >= 9) {
            cf.a(paramEditor);
            return;
        }
        paramEditor.commit();
    }

    private void a(String paramString, hj paramhj) {
        b(paramString, paramhj);
        if ((!paramhj.d) && (b())) {
            c();
        }
    }

    private void b(String paramString, hj paramhj) {
        this.f.put(paramString, paramhj);
    }

    private void e() {
        b(this.g);
    }

    public int a(String paramString, int paramInt) {
        paramString = (hj) this.f.get(paramString);
        if (paramString == null) {
            return paramInt;
        }
        return ((Integer) paramString.c).intValue();
    }

    public long a(String paramString, long paramLong) {
        paramString = (hj) this.f.get(paramString);
        if (paramString == null) {
            return paramLong;
        }
        return ((Long) paramString.c).longValue();
    }

    public Boolean a(String paramString, Boolean paramBoolean) {
        paramString = (hj) this.f.get(paramString);
        if (paramString == null) {
            return paramBoolean;
        }
        return (Boolean) paramString.c;
    }

    public String a(String paramString1, String paramString2) {
        paramString1 = (hj) this.f.get(paramString1);
        if (paramString1 == null) {
            return paramString2;
        }
        return (String) paramString1.c;
    }

    public void a(Context paramContext) {
        if (paramContext == null) {
            return;
        }
        b(paramContext);
    }

    protected void a(SharedPreferences paramSharedPreferences) {
        a(paramSharedPreferences.getAll());
    }

    public void a(hh paramhh) {
        this.d.lock();
        if (b()) {
            paramhh.e();
        }
        for (; ; ) {
            this.d.unlock();
            return;
            this.c.add(paramhh);
        }
    }

    protected void a(Map<String, ?> paramMap) {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Object localObject = (Map.Entry) paramMap.next();
            String str = (String) ((Map.Entry) localObject).getKey();
            if ((str != null) && (!this.f.containsKey(str))) {
                localObject = ((Map.Entry) localObject).getValue();
                this.f.put(str, new hj(this, localObject.getClass(), localObject));
            }
        }
    }

    public boolean a(String paramString) {
        return this.f.containsKey(paramString);
    }

    public boolean a(String paramString, boolean paramBoolean) {
        paramString = a(paramString, null);
        if (paramString == null) {
            return paramBoolean;
        }
        return paramString.booleanValue();
    }

    protected void b(Context paramContext) {
        ho.a(new hf(this, paramContext));
    }

    protected void b(SharedPreferences paramSharedPreferences) {
        ho.a(new hg(this, paramSharedPreferences));
    }

    public void b(String paramString) {
        paramString = (hj) this.f.remove(paramString);
        if ((paramString != null) && (!paramString.d) && (b())) {
            c();
        }
    }

    public void b(String paramString, int paramInt) {
        a(paramString, new hj(this, Integer.class, Integer.valueOf(paramInt)));
    }

    public void b(String paramString, long paramLong) {
        a(paramString, new hj(this, Long.class, Long.valueOf(paramLong)));
    }

    public void b(String paramString1, String paramString2) {
        a(paramString1, new hj(this, String.class, paramString2));
    }

    public void b(String paramString, boolean paramBoolean) {
        a(paramString, new hj(this, Boolean.class, Boolean.valueOf(paramBoolean)));
    }

    public boolean b() {
        return this.g != null;
    }

    protected SharedPreferences c(Context paramContext) {
        return paramContext.getSharedPreferences("AmazonMobileAds", 0);
    }

    public void c() {
        e();
    }

    public void c(String paramString) {
        this.f.remove(paramString);
    }

    public void c(String paramString, int paramInt) {
        b(paramString, new hj(this, Integer.class, Integer.valueOf(paramInt)));
    }

    public void c(String paramString, long paramLong) {
        b(paramString, new hj(this, Long.class, Long.valueOf(paramLong)));
    }

    public void c(String paramString1, String paramString2) {
        b(paramString1, new hj(this, String.class, paramString2));
    }

    public void c(String paramString, boolean paramBoolean) {
        b(paramString, new hj(this, Boolean.class, Boolean.valueOf(paramBoolean)));
    }

    protected void d() {
        this.d.lock();
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
            ((hh) localIterator.next()).e();
        }
        this.c.clear();
        this.c = null;
        this.d.unlock();
    }

    protected void d(Context paramContext) {
        if (!b()) {
            paramContext = c(paramContext);
            a(paramContext);
            this.g = paramContext;
            b(paramContext);
        }
        this.h.countDown();
        d();
    }

    public void d(String paramString, boolean paramBoolean) {
        b(paramString, new hi(this, Boolean.class, Boolean.valueOf(paramBoolean)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */