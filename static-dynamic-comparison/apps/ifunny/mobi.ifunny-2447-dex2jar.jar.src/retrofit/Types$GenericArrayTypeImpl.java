package retrofit;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class Types$GenericArrayTypeImpl
        implements GenericArrayType {
    private final Type componentType;

    public Types$GenericArrayTypeImpl(Type paramType) {
        this.componentType = paramType;
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof GenericArrayType)) && (Types.equals(this, (GenericArrayType) paramObject));
    }

    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        return Types.typeToString(this.componentType) + "[]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Types$GenericArrayTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */