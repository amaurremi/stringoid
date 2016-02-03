package com.flurry.sdk;

public final class qj
        implements Comparable<qj> {
    private String a;
    private Class<?> b;
    private int c;

    public qj() {
        this.b = null;
        this.a = null;
        this.c = 0;
    }

    public qj(Class<?> paramClass) {
        this.b = paramClass;
        this.a = paramClass.getName();
        this.c = this.a.hashCode();
    }

    public int a(qj paramqj) {
        return this.a.compareTo(paramqj.a);
    }

    public void a(Class<?> paramClass) {
        this.b = paramClass;
        this.a = paramClass.getName();
        this.c = this.a.hashCode();
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (paramObject.getClass() != getClass()) {
                return false;
            }
        } while (((qj) paramObject).b == this.b);
        return false;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */