package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class c
        implements Serializable, WildcardType {
    private static final long serialVersionUID = 0L;
    private final Type a;
    private final Type b;

    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2) {
        if (paramArrayOfType2.length <= 1) {
            bool1 = true;
            .Gson.Preconditions.checkArgument(bool1);
            if (paramArrayOfType1.length != 1) {
                break label87;
            }
            bool1 = true;
            label27:
            .Gson.Preconditions.checkArgument(bool1);
            if (paramArrayOfType2.length != 1) {
                break label97;
            }
            .Gson.Preconditions.checkNotNull(paramArrayOfType2[0]);
            .Gson.Types.access$000(paramArrayOfType2[0]);
            if (paramArrayOfType1[0] != Object.class) {
                break label92;
            }
        }
        label87:
        label92:
        for (boolean bool1 = bool2; ; bool1 = false) {
            .Gson.Preconditions.checkArgument(bool1);
            this.b =.Gson.Types.canonicalize(paramArrayOfType2[0]);
            this.a = Object.class;
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label27;
        }
        label97:
        .Gson.Preconditions.checkNotNull(paramArrayOfType1[0]);
        .Gson.Types.access$000(paramArrayOfType1[0]);
        this.b = null;
        this.a =.Gson.Types.canonicalize(paramArrayOfType1[0]);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof WildcardType)) && (.Gson.Types.equals(this, (WildcardType) paramObject));
    }

    public Type[] getLowerBounds() {
        if (this.b != null) {
            return new Type[]{this.b};
        }
        return.Gson.Types.EMPTY_TYPE_ARRAY;
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    public int hashCode() {
        if (this.b != null) {
        }
        for (int i = this.b.hashCode() + 31; ; i = 1) {
            return i ^ this.a.hashCode() + 31;
        }
    }

    public String toString() {
        if (this.b != null) {
            return "? super " +.Gson.Types.typeToString(this.b);
        }
        if (this.a == Object.class) {
            return "?";
        }
        return "? extends " +.Gson.Types.typeToString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */