package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class d
        implements Serializable, ParameterizedType {
    private static final long serialVersionUID = 0L;
    private final Type a;
    private final Type b;
    private final Type[] c;

    public d(Type paramType1, Type paramType2, Type... paramVarArgs) {
        boolean bool1;
        if ((paramType2 instanceof Class)) {
            Class localClass = (Class) paramType2;
            if ((paramType1 != null) || (localClass.getEnclosingClass() == null)) {
                bool1 = true;
                a.a(bool1);
                bool1 = bool2;
                if (paramType1 != null) {
                    if (localClass.getEnclosingClass() == null) {
                        break label161;
                    }
                    bool1 = bool2;
                }
                label63:
                a.a(bool1);
            }
        } else {
            if (paramType1 != null) {
                break label167;
            }
        }
        label161:
        label167:
        for (paramType1 = null; ; paramType1 = b.d(paramType1)) {
            this.a = paramType1;
            this.b = b.d(paramType2);
            this.c = ((Type[]) paramVarArgs.clone());
            while (i < this.c.length) {
                a.a(this.c[i]);
                b.h(this.c[i]);
                this.c[i] = b.d(this.c[i]);
                i += 1;
            }
            bool1 = false;
            break;
            bool1 = false;
            break label63;
        }
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof ParameterizedType)) && (b.a(this, (ParameterizedType) paramObject));
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    public Type getOwnerType() {
        return this.a;
    }

    public Type getRawType() {
        return this.b;
    }

    public int hashCode() {
        return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ b.a(this.a);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder((this.c.length + 1) * 30);
        localStringBuilder.append(b.f(this.b));
        if (this.c.length == 0) {
            return localStringBuilder.toString();
        }
        localStringBuilder.append("<").append(b.f(this.c[0]));
        int i = 1;
        while (i < this.c.length) {
            localStringBuilder.append(", ").append(b.f(this.c[i]));
            i += 1;
        }
        return ">";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */