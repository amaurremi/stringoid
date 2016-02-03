package org.apache.commons.lang;

import java.util.Arrays;

public class IncompleteArgumentException
        extends IllegalArgumentException {
    private static final long serialVersionUID = 4954193403612068178L;

    public IncompleteArgumentException(String paramString) {
        super(paramString + " is incomplete.");
    }

    public IncompleteArgumentException(String paramString, String[] paramArrayOfString) {
        super(paramString + " is missing the following items: " + safeArrayToString(paramArrayOfString));
    }

    private static final String safeArrayToString(Object[] paramArrayOfObject) {
        if (paramArrayOfObject == null) {
            return null;
        }
        return Arrays.asList(paramArrayOfObject).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/IncompleteArgumentException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */