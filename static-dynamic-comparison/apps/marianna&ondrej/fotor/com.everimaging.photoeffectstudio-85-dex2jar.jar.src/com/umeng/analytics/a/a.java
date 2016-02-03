package com.umeng.analytics.a;

import com.umeng.analytics.b.j;
import com.umeng.analytics.d.k;
import com.umeng.analytics.d.l;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class a {
    private final int a = 10;
    private final int b = 20;
    private final String c;
    private List<k> d;
    private l e;

    public a(String paramString) {
        this.c = paramString;
    }

    private boolean h() {
        boolean bool2 = false;
        Object localObject3 = this.e;
        Object localObject1;
        if (localObject3 == null) {
            localObject1 = null;
            if (localObject3 != null) {
                break label218;
            }
        }
        label218:
        for (int i = 0; ; i = ((l) localObject3).j()) {
            String str = a(f());
            boolean bool1 = bool2;
            if (str != null) {
                bool1 = bool2;
                if (!str.equals(localObject1)) {
                    Object localObject2 = localObject3;
                    if (localObject3 == null) {
                        localObject2 = new l();
                    }
                    ((l) localObject2).a(str);
                    ((l) localObject2).a(System.currentTimeMillis());
                    ((l) localObject2).a(i + 1);
                    localObject3 = new k();
                    ((k) localObject3).a(this.c);
                    ((k) localObject3).c(str);
                    ((k) localObject3).b((String) localObject1);
                    ((k) localObject3).a(((l) localObject2).f());
                    if (this.d == null) {
                        this.d = new ArrayList(2);
                    }
                    this.d.add(localObject3);
                    if (this.d.size() > 10) {
                        this.d.remove(0);
                    }
                    this.e = ((l) localObject2);
                    bool1 = true;
                }
            }
            return bool1;
            localObject1 = ((l) localObject3).c();
            break;
        }
    }

    public String a(String paramString) {
        if (paramString == null) {
        }
        do {
            return null;
            paramString = paramString.trim();
        }
        while ((paramString.length() == 0) || ("0".equals(paramString)) || ("unknown".equals(paramString.toLowerCase(Locale.US))));
        return paramString;
    }

    public void a(l paraml) {
        this.e = paraml;
    }

    public void a(List<k> paramList) {
        this.d = paramList;
    }

    public boolean a() {
        return h();
    }

    public String b() {
        return this.c;
    }

    public void b(String paramString) {
        try {
            paramString = new ObjectInputStream(new ByteArrayInputStream(j.b(paramString)));
            this.d = ((List) paramString.readObject());
            this.e = ((l) paramString.readObject());
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    public boolean c() {
        return (this.e == null) || (this.e.j() <= 20);
    }

    public l d() {
        return this.e;
    }

    public List<k> e() {
        return this.d;
    }

    public abstract String f();

    public String g() {
        try {
            Object localObject = new ByteArrayOutputStream();
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream) localObject);
            localObjectOutputStream.writeObject(this.d);
            localObjectOutputStream.writeObject(this.e);
            localObjectOutputStream.close();
            localObject = j.a(((ByteArrayOutputStream) localObject).toByteArray());
            return (String) localObject;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */