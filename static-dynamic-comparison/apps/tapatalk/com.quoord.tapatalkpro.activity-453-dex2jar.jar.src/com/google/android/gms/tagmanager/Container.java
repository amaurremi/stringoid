package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.d.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String WJ;
    private final DataLayer WK;
    private cs WL;
    private Map<String, FunctionCallMacroCallback> WM = new HashMap();
    private Map<String, FunctionCallTagCallback> WN = new HashMap();
    private volatile long WO;
    private volatile String WP = "";
    private final Context mContext;

    Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, c.j paramj) {
        this.mContext = paramContext;
        this.WK = paramDataLayer;
        this.WJ = paramString;
        this.WO = paramLong;
        a(paramj.fK);
        if (paramj.fJ != null) {
            a(paramj.fJ);
        }
    }

    Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, cq.c paramc) {
        this.mContext = paramContext;
        this.WK = paramDataLayer;
        this.WJ = paramString;
        this.WO = paramLong;
        a(paramc);
    }

    private void a(c.f paramf) {
        if (paramf == null) {
            throw new NullPointerException();
        }
        try {
            cq.c localc = cq.b(paramf);
            a(localc);
            return;
        } catch (cq.g localg) {
            bh.w("Not loading resource: " + paramf + " because it is invalid: " + localg.toString());
        }
    }

    private void a(cq.c paramc) {
        this.WP = paramc.getVersion();
        ag localag = bq(this.WP);
        a(new cs(this.mContext, paramc, this.WK, new a(null), new b(null), localag));
    }

    private void a(cs paramcs) {
        try {
            this.WL = paramcs;
            return;
        } finally {
            paramcs =finally;
            throw paramcs;
        }
    }

    private void a(c.i[] paramArrayOfi) {
        ArrayList localArrayList = new ArrayList();
        int j = paramArrayOfi.length;
        int i = 0;
        while (i < j) {
            localArrayList.add(paramArrayOfi[i]);
            i += 1;
        }
        kd().e(localArrayList);
    }

    private cs kd() {
        try {
            cs localcs = this.WL;
            return localcs;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    FunctionCallMacroCallback bn(String paramString) {
        synchronized (this.WM) {
            paramString = (FunctionCallMacroCallback) this.WM.get(paramString);
            return paramString;
        }
    }

    FunctionCallTagCallback bo(String paramString) {
        synchronized (this.WN) {
            paramString = (FunctionCallTagCallback) this.WN.get(paramString);
            return paramString;
        }
    }

    void bp(String paramString) {
        kd().bp(paramString);
    }

    ag bq(String paramString) {
        if (cd.kT().kU().equals(cd.a.YV)) {
        }
        return new bq();
    }

    public boolean getBoolean(String paramString) {
        cs localcs = kd();
        if (localcs == null) {
            bh.w("getBoolean called for closed container.");
            return dh.lQ().booleanValue();
        }
        try {
            boolean bool = dh.n((d.a) localcs.bR(paramString).getObject()).booleanValue();
            return bool;
        } catch (Exception paramString) {
            bh.w("Calling getBoolean() threw an exception: " + paramString.getMessage() + " Returning default value.");
        }
        return dh.lQ().booleanValue();
    }

    public String getContainerId() {
        return this.WJ;
    }

    public double getDouble(String paramString) {
        cs localcs = kd();
        if (localcs == null) {
            bh.w("getDouble called for closed container.");
            return dh.lP().doubleValue();
        }
        try {
            double d = dh.m((d.a) localcs.bR(paramString).getObject()).doubleValue();
            return d;
        } catch (Exception paramString) {
            bh.w("Calling getDouble() threw an exception: " + paramString.getMessage() + " Returning default value.");
        }
        return dh.lP().doubleValue();
    }

    public long getLastRefreshTime() {
        return this.WO;
    }

    public long getLong(String paramString) {
        cs localcs = kd();
        if (localcs == null) {
            bh.w("getLong called for closed container.");
            return dh.lO().longValue();
        }
        try {
            long l = dh.l((d.a) localcs.bR(paramString).getObject()).longValue();
            return l;
        } catch (Exception paramString) {
            bh.w("Calling getLong() threw an exception: " + paramString.getMessage() + " Returning default value.");
        }
        return dh.lO().longValue();
    }

    public String getString(String paramString) {
        cs localcs = kd();
        if (localcs == null) {
            bh.w("getString called for closed container.");
            return dh.lS();
        }
        try {
            paramString = dh.j((d.a) localcs.bR(paramString).getObject());
            return paramString;
        } catch (Exception paramString) {
            bh.w("Calling getString() threw an exception: " + paramString.getMessage() + " Returning default value.");
        }
        return dh.lS();
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0L;
    }

    String kc() {
        return this.WP;
    }

    public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback) {
        if (paramFunctionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.WM) {
            this.WM.put(paramString, paramFunctionCallMacroCallback);
            return;
        }
    }

    public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback) {
        if (paramFunctionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.WN) {
            this.WN.put(paramString, paramFunctionCallTagCallback);
            return;
        }
    }

    void release() {
        this.WL = null;
    }

    public void unregisterFunctionCallMacroCallback(String paramString) {
        synchronized (this.WM) {
            this.WM.remove(paramString);
            return;
        }
    }

    public void unregisterFunctionCallTagCallback(String paramString) {
        synchronized (this.WN) {
            this.WN.remove(paramString);
            return;
        }
    }

    public static abstract interface FunctionCallMacroCallback {
        public abstract Object getValue(String paramString, Map<String, Object> paramMap);
    }

    public static abstract interface FunctionCallTagCallback {
        public abstract void execute(String paramString, Map<String, Object> paramMap);
    }

    private class a
            implements s.a {
        private a() {
        }

        public Object b(String paramString, Map<String, Object> paramMap) {
            Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.bn(paramString);
            if (localFunctionCallMacroCallback == null) {
                return null;
            }
            return localFunctionCallMacroCallback.getValue(paramString, paramMap);
        }
    }

    private class b
            implements s.a {
        private b() {
        }

        public Object b(String paramString, Map<String, Object> paramMap) {
            Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.bo(paramString);
            if (localFunctionCallTagCallback != null) {
                localFunctionCallTagCallback.execute(paramString, paramMap);
            }
            return dh.lS();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */