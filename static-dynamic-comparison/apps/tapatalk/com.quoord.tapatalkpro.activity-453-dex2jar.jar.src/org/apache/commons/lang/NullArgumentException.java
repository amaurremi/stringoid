package org.apache.commons.lang;

public class NullArgumentException
        extends IllegalArgumentException {
    private static final long serialVersionUID = 1174360235354917591L;

    public NullArgumentException(String paramString) {
        super(str + " must not be null.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/NullArgumentException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */