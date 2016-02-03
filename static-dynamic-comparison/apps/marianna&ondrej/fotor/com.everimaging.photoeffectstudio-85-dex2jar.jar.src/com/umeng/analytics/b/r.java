package com.umeng.analytics.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.c.d;
import com.umeng.analytics.d.s;
import com.umeng.common.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class r {
    private static final String a = "activities";
    private final Map<String, Long> b = new HashMap();
    private final ArrayList<p> c = new ArrayList();

    public static List<s> a(m paramm) {
        Object localObject = paramm.a("activities", "");
        if ("".equals(localObject)) {
            return null;
        }
        paramm = new ArrayList();
        for (; ; ) {
            int i;
            try {
                localObject = ((String) localObject).split(";");
                i = 0;
                if (i < localObject.length) {
                    CharSequence localCharSequence = localObject[i];
                    if (TextUtils.isEmpty(localCharSequence)) {
                        break label87;
                    }
                    paramm.add(new d(localCharSequence));
                }
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            if (paramm.size() <= 0) {
                break;
            }
            return paramm;
            label87:
            i += 1;
        }
    }

    public void a() {
        String str = null;
        long l = 0L;
        for (; ; ) {
            synchronized (this.b) {
                Iterator localIterator = this.b.entrySet().iterator();
                if (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    if (((Long) localEntry.getValue()).longValue() > l) {
                        l = ((Long) localEntry.getValue()).longValue();
                        str = (String) localEntry.getKey();
                    }
                } else {
                    if (str != null) {
                        b(str);
                    }
                    return;
                }
            }
        }
    }

    public void a(Context arg1) {
        Object localObject2 = m.a( ???);
        m.a locala = ((m) localObject2).a();
        synchronized (this.c) {
            if (this.c.size() <= 0) {
                break label182;
            }
            Object localObject3 = ((m) localObject2).a("activities", "");
            localObject2 = new StringBuilder();
            if (!TextUtils.isEmpty((CharSequence) localObject3)) {
                ((StringBuilder) localObject2).append((String) localObject3);
                ((StringBuilder) localObject2).append(";");
            }
            localObject3 = this.c.iterator();
            if (((Iterator) localObject3).hasNext()) {
                p localp = (p) ((Iterator) localObject3).next();
                ((StringBuilder) localObject2).append(String.format("[\"%s\",%d]", new Object[]{localp.a, Long.valueOf(localp.b)}));
                ((StringBuilder) localObject2).append(";");
            }
        }
        this.c.clear();
        ((StringBuilder) localObject2).deleteCharAt(((StringBuilder) localObject2).length() - 1);
        ((m.a) localObject1).a("activities");
        ((m.a) localObject1).a("activities", ((StringBuilder) localObject2).toString());
        label182:
        ((m.a) localObject1).b();
    }

    public void a(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            synchronized (this.b) {
                this.b.put(paramString, Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
    }

    public void b(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
        }
        Long localLong;
        synchronized (this.b) {
            localLong = (Long) this.b.remove(paramString);
            if (localLong == null) {
                Log.e("MobclickAgent", String.format("please call 'onPageStart(%s)' before onPageEnd", new Object[]{paramString}));
                return;
            }
        }
        long l1 = System.currentTimeMillis();
        long l2 = localLong.longValue();
        synchronized (this.c) {
            this.c.add(new p(paramString, l1 - l2));
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */