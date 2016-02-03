package org.apache.commons.lang.

enum;

import java.util.Iterator;
        import java.util.List;
        import org.apache.commons.lang.ClassUtils;

public abstract class ValuedEnum
        extends Enum {
    private static final long serialVersionUID = -7129650521543789085L;
    private final int iValue;

    protected ValuedEnum(String paramString, int paramInt) {
        super(paramString);
        this.iValue = paramInt;
    }

    protected static Enum getEnum(Class paramClass, int paramInt) {
        if (paramClass == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        paramClass = Enum.getEnumList(paramClass).iterator();
        while (paramClass.hasNext()) {
            ValuedEnum localValuedEnum = (ValuedEnum) paramClass.next();
            if (localValuedEnum.getValue() == paramInt) {
                return localValuedEnum;
            }
        }
        return null;
    }

    public int compareTo(Object paramObject) {
        return this.iValue - ((ValuedEnum) paramObject).iValue;
    }

    public final int getValue() {
        return this.iValue;
    }

    public String toString() {
        if (this.iToString == null) {
            String str = ClassUtils.getShortClassName(getEnumClass());
            this.iToString = (str + "[" + getName() + "=" + getValue() + "]");
        }
        return this.iToString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/enum/ValuedEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */