package com.umeng.analytics.b;

import android.content.Context;
import com.umeng.analytics.c.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class b {
    private final String a = "umeng_event_snapshot";
    private boolean b = false;
    private m c;
    private Map<String, ArrayList<a>> d = new HashMap();

    public b(Context paramContext) {
        this.c = m.a(paramContext, "umeng_event_snapshot");
    }

    private void c(String paramString) {
        Object localObject = null;
        if (this.d.containsKey(paramString)) {
            localObject = (ArrayList) this.d.get(paramString);
            while (((ArrayList) localObject).size() > 4) {
                ((ArrayList) localObject).remove(0);
            }
            localObject = j.a((Serializable) localObject);
        }
        this.c.a().a(paramString, (String) localObject).b();
    }

    private boolean d(String paramString) {
        if (this.d.containsKey(paramString)) {
            return true;
        }
        Object localObject = this.c.a(paramString, null);
        if (localObject != null) {
            localObject = (ArrayList) j.a((String) localObject);
            if (localObject != null) {
                this.d.put(paramString, localObject);
                return true;
            }
        }
        return false;
    }

    public int a(String paramString) {
        if (this.d.containsKey(paramString)) {
            return ((ArrayList) this.d.get(paramString)).size();
        }
        return 0;
    }

    public void a(String paramString, a parama) {
        if (this.b) {
            d(paramString);
        }
        if (this.d.containsKey(paramString)) {
            ((ArrayList) this.d.get(paramString)).add(parama);
        }
        for (; ; ) {
            if (this.b) {
                c(paramString);
            }
            return;
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(parama);
            this.d.put(paramString, localArrayList);
        }
    }

    public void a(boolean paramBoolean) {
        this.b = paramBoolean;
    }

    public a b(String paramString) {
        if (this.b) {
            d(paramString);
        }
        if (this.d.containsKey(paramString)) {
            localObject = (ArrayList) this.d.get(paramString);
            if (((ArrayList) localObject).size() <= 0) {
            }
        }
        for (Object localObject = (a) ((ArrayList) localObject).remove(((ArrayList) localObject).size() - 1); ; localObject = null) {
            if (this.b) {
                c(paramString);
            }
            return (a) localObject;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */