package com.google.android.gms.internal;

import com.google.android.gms.common.internal.ag;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ji {
    private void a(StringBuilder paramStringBuilder, ji.a parama, Object paramObject) {
        if (parama.b() == 11) {
            paramStringBuilder.append(((ji) parama.h().cast(paramObject)).toString());
            return;
        }
        if (parama.b() == 7) {
            paramStringBuilder.append("\"");
            paramStringBuilder.append(pu.a((String) paramObject));
            paramStringBuilder.append("\"");
            return;
        }
        paramStringBuilder.append(paramObject);
    }

    private void a(StringBuilder paramStringBuilder, ji.a parama, ArrayList<Object> paramArrayList) {
        paramStringBuilder.append("[");
        int i = 0;
        int j = paramArrayList.size();
        while (i < j) {
            if (i > 0) {
                paramStringBuilder.append(",");
            }
            Object localObject = paramArrayList.get(i);
            if (localObject != null) {
                a(paramStringBuilder, parama, localObject);
            }
            i += 1;
        }
        paramStringBuilder.append("]");
    }

    protected <O, I> I a(ji.a<I, O> parama, Object paramObject) {
        Object localObject = paramObject;
        if (ji.a.a(parama) != null) {
            localObject = parama.a(paramObject);
        }
        return (I) localObject;
    }

    protected abstract Object a(String paramString);

    protected boolean a(ji.a parama) {
        if (parama.d() == 11) {
            if (parama.e()) {
                return d(parama.f());
            }
            return c(parama.f());
        }
        return b(parama.f());
    }

    protected Object b(ji.a parama) {
        String str = parama.f();
        if (parama.h() != null) {
            boolean bool;
            if (a(parama.f()) == null) {
                bool = true;
                ag.a(bool, "Concrete field shouldn't be value object: %s", new Object[]{parama.f()});
                if (!parama.e()) {
                    break label71;
                }
            }
            label71:
            for (parama = d(); ; parama = c()) {
                if (parama == null) {
                    break label79;
                }
                return parama.get(str);
                bool = false;
                break;
            }
            try {
                label79:
                parama = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
                parama = getClass().getMethod(parama, new Class[0]).invoke(this, new Object[0]);
                return parama;
            } catch (Exception parama) {
                throw new RuntimeException(parama);
            }
        }
        return a(parama.f());
    }

    public abstract HashMap<String, ji.a<?, ?>> b();

    protected abstract boolean b(String paramString);

    public HashMap<String, Object> c() {
        return null;
    }

    protected boolean c(String paramString) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public HashMap<String, Object> d() {
        return null;
    }

    protected boolean d(String paramString) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        HashMap localHashMap = b();
        StringBuilder localStringBuilder = new StringBuilder(100);
        Iterator localIterator = localHashMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            ji.a locala = (ji.a) localHashMap.get(str);
            if (a(locala)) {
                Object localObject = a(locala, b(locala));
                if (localStringBuilder.length() == 0) {
                    localStringBuilder.append("{");
                }
                for (; ; ) {
                    localStringBuilder.append("\"").append(str).append("\":");
                    if (localObject != null) {
                        break label135;
                    }
                    localStringBuilder.append("null");
                    break;
                    localStringBuilder.append(",");
                }
                label135:
                switch (locala.d()) {
                    default:
                        if (locala.c()) {
                            a(localStringBuilder, locala, (ArrayList) localObject);
                        }
                        break;
                    case 8:
                        localStringBuilder.append("\"").append(po.a((byte[]) localObject)).append("\"");
                        break;
                    case 9:
                        localStringBuilder.append("\"").append(po.b((byte[]) localObject)).append("\"");
                        break;
                    case 10:
                        pw.a(localStringBuilder, (HashMap) localObject);
                        continue;
                        a(localStringBuilder, locala, localObject);
                }
            }
        }
        if (localStringBuilder.length() > 0) {
            localStringBuilder.append("}");
        }
        for (; ; ) {
            return localStringBuilder.toString();
            localStringBuilder.append("{}");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */