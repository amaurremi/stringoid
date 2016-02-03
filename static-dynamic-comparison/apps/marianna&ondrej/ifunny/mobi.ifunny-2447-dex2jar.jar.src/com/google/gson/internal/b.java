package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class b
        implements Serializable, ParameterizedType {
    private static final long serialVersionUID = 0L;
    private final Type a;
    private final Type b;
    private final Type[] c;

    public b(Type paramType1, Type paramType2, Type... paramVarArgs) {
        int i;
        boolean bool;
        if ((paramType2 instanceof Class)) {
            Class localClass = (Class) paramType2;
            if ((Modifier.isStatic(localClass.getModifiers())) || (localClass.getEnclosingClass() == null)) {
                i = 1;
                if ((paramType1 == null) && (i == 0)) {
                    break label156;
                }
                bool = true;
                label54:
                .Gson.Preconditions.checkArgument(bool);
            }
        } else {
            if (paramType1 != null) {
                break label162;
            }
        }
        label156:
        label162:
        for (paramType1 = null; ; paramType1 =.Gson.Types.canonicalize(paramType1))
        {
            this.a = paramType1;
            this.b =.Gson.Types.canonicalize(paramType2);
            this.c = ((Type[]) paramVarArgs.clone());
            i = j;
            while (i < this.c.length) {
                .Gson.Preconditions.checkNotNull(this.c[i]);
                .Gson.Types.access$000(this.c[i]);
                this.c[i] =.Gson.Types.canonicalize(this.c[i]);
                i += 1;
            }
            i = 0;
            break;
            bool = false;
            break label54;
        }
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType) paramObject))
        ;
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
        return Arrays.hashCode(this.c) ^ this.b.hashCode() ^.Gson.Types.access$100(this.a);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder((this.c.length + 1) * 30);
        localStringBuilder.append(.Gson.Types.typeToString(this.b));
        if (this.c.length == 0) {
            return localStringBuilder.toString();
        }
        localStringBuilder.append("<").append(.Gson.Types.typeToString(this.c[0]));
        int i = 1;
        while (i < this.c.length) {
            localStringBuilder.append(", ").append(.Gson.Types.typeToString(this.c[i]));
            i += 1;
        }
        return ">";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */