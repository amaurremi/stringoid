package retrofit;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class Types$ParameterizedTypeImpl
        implements ParameterizedType {
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public Types$ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs) {
        if ((paramType2 instanceof Class)) {
            if (paramType1 == null) {
                i = 1;
                if (((Class) paramType2).getEnclosingClass() != null) {
                    break label55;
                }
            }
            for (; ; ) {
                if (i == j) {
                    break label61;
                }
                throw new IllegalArgumentException();
                i = 0;
                break;
                label55:
                j = 0;
            }
        }
        label61:
        this.ownerType = paramType1;
        this.rawType = paramType2;
        this.typeArguments = ((Type[]) paramVarArgs.clone());
        paramType1 = this.typeArguments;
        j = paramType1.length;
        int i = k;
        while (i < j) {
            paramType2 = paramType1[i];
            if (paramType2 == null) {
                throw new NullPointerException();
            }
            Types.access$000(paramType2);
            i += 1;
        }
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof ParameterizedType)) && (Types.equals(this, (ParameterizedType) paramObject));
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.typeArguments.clone();
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ Types.access$100(this.ownerType);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
        localStringBuilder.append(Types.typeToString(this.rawType));
        if (this.typeArguments.length == 0) {
            return localStringBuilder.toString();
        }
        localStringBuilder.append("<").append(Types.typeToString(this.typeArguments[0]));
        int i = 1;
        while (i < this.typeArguments.length) {
            localStringBuilder.append(", ").append(Types.typeToString(this.typeArguments[i]));
            i += 1;
        }
        return ">";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Types$ParameterizedTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */