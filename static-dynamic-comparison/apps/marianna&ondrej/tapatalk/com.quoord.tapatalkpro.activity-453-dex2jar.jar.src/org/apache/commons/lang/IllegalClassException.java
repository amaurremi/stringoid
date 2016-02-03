package org.apache.commons.lang;

public class IllegalClassException
        extends IllegalArgumentException {
    private static final long serialVersionUID = 8063272569377254819L;

    public IllegalClassException(Class paramClass1, Class paramClass2) {
        super("Expected: " + safeGetClassName(paramClass1) + ", actual: " + safeGetClassName(paramClass2));
    }

    public IllegalClassException(Class paramClass, Object paramObject) {
    }

    public IllegalClassException(String paramString) {
        super(paramString);
    }

    private static final String safeGetClassName(Class paramClass) {
        if (paramClass == null) {
            return null;
        }
        return paramClass.getName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/IllegalClassException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */