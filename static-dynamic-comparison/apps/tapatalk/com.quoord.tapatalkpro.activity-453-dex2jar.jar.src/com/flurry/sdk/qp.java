package com.flurry.sdk;

public final class qp
        extends qq {
    protected final sh[] a;
    protected final String[] b;

    protected qp(Class<?> paramClass) {
        this(paramClass, null, null, null, null);
    }

    protected qp(Class<?> paramClass, String[] paramArrayOfString, sh[] paramArrayOfsh, Object paramObject1, Object paramObject2) {
        super(paramClass, 0, paramObject1, paramObject2);
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
            this.b = null;
            this.a = null;
            return;
        }
        this.b = paramArrayOfString;
        this.a = paramArrayOfsh;
    }

    public static qp d(Class<?> paramClass) {
        return new qp(paramClass, null, null, null, null);
    }

    public qp a(Object paramObject) {
        return new qp(this.d, this.b, this.a, this.f, paramObject);
    }

    protected sh a(Class<?> paramClass) {
        return new qp(paramClass, this.b, this.a, this.f, this.g);
    }

    protected String a() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d.getName());
        if ((this.a != null) && (this.a.length > 0)) {
            localStringBuilder.append('<');
            int j = 1;
            sh[] arrayOfsh = this.a;
            int k = arrayOfsh.length;
            int i = 0;
            if (i < k) {
                sh localsh = arrayOfsh[i];
                if (j != 0) {
                    j = 0;
                }
                for (; ; ) {
                    localStringBuilder.append(localsh.m());
                    i += 1;
                    break;
                    localStringBuilder.append(',');
                }
            }
            localStringBuilder.append('>');
        }
        return localStringBuilder.toString();
    }

    public String a(int paramInt) {
        if ((paramInt < 0) || (this.b == null) || (paramInt >= this.b.length)) {
            return null;
        }
        return this.b[paramInt];
    }

    public qp b(Object paramObject) {
        if (paramObject == this.f) {
            return this;
        }
        return new qp(this.d, this.b, this.a, paramObject, this.g);
    }

    public sh b(int paramInt) {
        if ((paramInt < 0) || (this.a == null) || (paramInt >= this.a.length)) {
            return null;
        }
        return this.a[paramInt];
    }

    public sh b(Class<?> paramClass) {
        throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
    }

    public sh c(Class<?> paramClass) {
        throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
    }

    public sh e(Object paramObject) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        Object localObject;
        label92:
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                return bool1;
                                bool1 = bool2;
                            } while (paramObject == null);
                            bool1 = bool2;
                        } while (paramObject.getClass() != getClass());
                        localObject = (qp) paramObject;
                        bool1 = bool2;
                    } while (((qp) localObject).d != this.d);
                    paramObject = this.a;
                    localObject = ((qp) localObject).a;
                    if (paramObject != null) {
                        break label92;
                    }
                    if (localObject == null) {
                        break;
                    }
                    bool1 = bool2;
                } while (localObject.length != 0);
                return true;
                bool1 = bool2;
            } while (localObject == null);
            bool1 = bool2;
        } while (paramObject.length != localObject.length);
        int j = paramObject.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                break label147;
            }
            bool1 = bool2;
            if (!paramObject[i].equals(localObject[i])) {
                break;
            }
            i += 1;
        }
        label147:
        return true;
    }

    public boolean f() {
        return false;
    }

    public int h() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(40);
        localStringBuilder.append("[simple type, class ").append(a()).append(']');
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */