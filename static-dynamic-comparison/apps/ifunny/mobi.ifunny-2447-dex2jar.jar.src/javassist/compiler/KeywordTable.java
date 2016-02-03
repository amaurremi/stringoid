package javassist.compiler;

import java.util.HashMap;

public final class KeywordTable
        extends HashMap {
    public void append(String paramString, int paramInt) {
        put(paramString, new Integer(paramInt));
    }

    public int lookup(String paramString) {
        paramString = get(paramString);
        if (paramString == null) {
            return -1;
        }
        return ((Integer) paramString).intValue();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/KeywordTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */