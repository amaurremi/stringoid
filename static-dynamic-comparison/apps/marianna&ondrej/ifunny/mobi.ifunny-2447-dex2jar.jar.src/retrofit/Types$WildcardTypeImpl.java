package retrofit;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class Types$WildcardTypeImpl
        implements WildcardType {
    private final Type lowerBound;
    private final Type upperBound;

    public Types$WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2) {
        if (paramArrayOfType2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (paramArrayOfType1.length != 1) {
            throw new IllegalArgumentException();
        }
        if (paramArrayOfType2.length == 1) {
            if (paramArrayOfType2[0] == null) {
                throw new NullPointerException();
            }
            Types.access$000(paramArrayOfType2[0]);
            if (paramArrayOfType1[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.lowerBound = paramArrayOfType2[0];
            this.upperBound = Object.class;
            return;
        }
        if (paramArrayOfType1[0] == null) {
            throw new NullPointerException();
        }
        Types.access$000(paramArrayOfType1[0]);
        this.lowerBound = null;
        this.upperBound = paramArrayOfType1[0];
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof WildcardType)) && (Types.equals(this, (WildcardType) paramObject));
    }

    public Type[] getLowerBounds() {
        if (this.lowerBound != null) {
            return new Type[]{this.lowerBound};
        }
        return Types.access$200();
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public int hashCode() {
        if (this.lowerBound != null) {
        }
        for (int i = this.lowerBound.hashCode() + 31; ; i = 1) {
            return i ^ this.upperBound.hashCode() + 31;
        }
    }

    public String toString() {
        if (this.lowerBound != null) {
            return "? super " + Types.typeToString(this.lowerBound);
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        return "? extends " + Types.typeToString(this.upperBound);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Types$WildcardTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */