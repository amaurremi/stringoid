package com.flurry.sdk;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class jh
        extends hk {
    protected LinkedList<a> b;

    public jh(String paramString) {
        super(paramString);
    }

    public jh(String paramString, hg paramhg) {
        super(paramString, paramhg);
    }

    public jh(String paramString, hg paramhg, Throwable paramThrowable) {
        super(paramString, paramhg, paramThrowable);
    }

    public jh(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public static jh a(hj paramhj, String paramString) {
        return new jh(paramString, paramhj.h());
    }

    public static jh a(hj paramhj, String paramString, Throwable paramThrowable) {
        return new jh(paramString, paramhj.h(), paramThrowable);
    }

    public static jh a(Throwable paramThrowable, a parama) {
        if ((paramThrowable instanceof jh)) {
        }
        String str1;
        for (paramThrowable = (jh) paramThrowable; ; paramThrowable = new jh(str1, null, paramThrowable)) {
            paramThrowable.a(parama);
            return paramThrowable;
            String str2 = paramThrowable.getMessage();
            if (str2 != null) {
                str1 = str2;
                if (str2.length() != 0) {
                }
            } else {
                str1 = "(was " + paramThrowable.getClass().getName() + ")";
            }
        }
    }

    public static jh a(Throwable paramThrowable, Object paramObject, int paramInt) {
        return a(paramThrowable, new a(paramObject, paramInt));
    }

    public static jh a(Throwable paramThrowable, Object paramObject, String paramString) {
        return a(paramThrowable, new a(paramObject, paramString));
    }

    public void a(a parama) {
        if (this.b == null) {
            this.b = new LinkedList();
        }
        if (this.b.size() < 1000) {
            this.b.addFirst(parama);
        }
    }

    public void a(Object paramObject, String paramString) {
        a(new a(paramObject, paramString));
    }

    protected void a(StringBuilder paramStringBuilder) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            paramStringBuilder.append(((a) localIterator.next()).toString());
            if (localIterator.hasNext()) {
                paramStringBuilder.append("->");
            }
        }
    }

    public String getMessage() {
        Object localObject = super.getMessage();
        if (this.b == null) {
            return (String) localObject;
        }
        if (localObject == null) {
        }
        for (localObject = new StringBuilder(); ; localObject = new StringBuilder((String) localObject)) {
            ((StringBuilder) localObject).append(" (through reference chain: ");
            a((StringBuilder) localObject);
            ((StringBuilder) localObject).append(')');
            return ((StringBuilder) localObject).toString();
        }
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public static class a
            implements Serializable {
        protected Object a;
        protected String b;
        protected int c = -1;

        protected a() {
        }

        public a(Object paramObject, int paramInt) {
            this.a = paramObject;
            this.c = paramInt;
        }

        public a(Object paramObject, String paramString) {
            this.a = paramObject;
            if (paramString == null) {
                throw new NullPointerException("Can not pass null fieldName");
            }
            this.b = paramString;
        }

        public String toString() {
            StringBuilder localStringBuilder = new StringBuilder();
            Class localClass;
            if ((this.a instanceof Class)) {
                localClass = (Class) this.a;
                Package localPackage = localClass.getPackage();
                if (localPackage != null) {
                    localStringBuilder.append(localPackage.getName());
                    localStringBuilder.append('.');
                }
                localStringBuilder.append(localClass.getSimpleName());
                localStringBuilder.append('[');
                if (this.b == null) {
                    break label120;
                }
                localStringBuilder.append('"');
                localStringBuilder.append(this.b);
                localStringBuilder.append('"');
            }
            for (; ; ) {
                localStringBuilder.append(']');
                return localStringBuilder.toString();
                localClass = this.a.getClass();
                break;
                label120:
                if (this.c >= 0) {
                    localStringBuilder.append(this.c);
                } else {
                    localStringBuilder.append('?');
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/jh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */