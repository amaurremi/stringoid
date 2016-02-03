package com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class nx
        extends nw {
    protected final jn<?> a;
    protected final HashMap<String, String> b;
    protected final HashMap<String, sh> e;

    protected nx(jn<?> paramjn, sh paramsh, HashMap<String, String> paramHashMap, HashMap<String, sh> paramHashMap1) {
        super(paramsh, paramjn.m());
        this.a = paramjn;
        this.b = paramHashMap;
        this.e = paramHashMap1;
    }

    public static nx a(jn<?> paramjn, sh paramsh, Collection<nf> paramCollection, boolean paramBoolean1, boolean paramBoolean2) {
        if (paramBoolean1 == paramBoolean2) {
            throw new IllegalArgumentException();
        }
        if (paramBoolean1) {
        }
        for (HashMap localHashMap1 = new HashMap(); ; localHashMap1 = null) {
            if (paramBoolean2) {
            }
            for (HashMap localHashMap2 = new HashMap(); ; localHashMap2 = null) {
                if (paramCollection != null) {
                    Iterator localIterator = paramCollection.iterator();
                    if (localIterator.hasNext()) {
                        paramCollection = (nf) localIterator.next();
                        Class localClass = paramCollection.a();
                        if (paramCollection.c()) {
                        }
                        for (paramCollection = paramCollection.b(); ; paramCollection = a(localClass)) {
                            if (paramBoolean1) {
                                localHashMap1.put(localClass.getName(), paramCollection);
                            }
                            if (!paramBoolean2) {
                                break;
                            }
                            sh localsh = (sh) localHashMap2.get(paramCollection);
                            if ((localsh != null) && (localClass.isAssignableFrom(localsh.p()))) {
                                break;
                            }
                            localHashMap2.put(paramCollection, paramjn.b(localClass));
                            break;
                        }
                    }
                }
                return new nx(paramjn, paramsh, localHashMap1, localHashMap2);
            }
        }
    }

    protected static String a(Class<?> paramClass) {
        paramClass = paramClass.getName();
        int i = paramClass.lastIndexOf('.');
        if (i < 0) {
            return paramClass;
        }
        return paramClass.substring(i + 1);
    }

    public sh a(String paramString)
            throws IllegalArgumentException {
        return (sh) this.e.get(paramString);
    }

    public String a(Object paramObject) {
        Class localClass = paramObject.getClass();
        String str = localClass.getName();
        synchronized (this.b) {
            paramObject = (String) this.b.get(str);
            Object localObject = paramObject;
            if (paramObject == null) {
                if (this.a.b()) {
                    paramObject = (mw) this.a.c(localClass);
                    paramObject = this.a.a().g(((mw) paramObject).c());
                }
                localObject = paramObject;
                if (paramObject == null) {
                    localObject = a(localClass);
                }
                this.b.put(str, localObject);
            }
            return (String) localObject;
        }
    }

    public String a(Object paramObject, Class<?> paramClass) {
        return a(paramObject);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('[').append(getClass().getName());
        localStringBuilder.append("; id-to-type=").append(this.e);
        localStringBuilder.append(']');
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */