package org.apache.commons.lang.text;

import java.util.Map;

public abstract class StrLookup {
    private static final StrLookup NONE_LOOKUP = new MapStrLookup(null);
    private static final StrLookup SYSTEM_PROPERTIES_LOOKUP;

    static {
        try {
            MapStrLookup localMapStrLookup = new MapStrLookup(System.getProperties());
            SYSTEM_PROPERTIES_LOOKUP = localMapStrLookup;
            return;
        } catch (SecurityException localSecurityException) {
            for (; ; ) {
                StrLookup localStrLookup = NONE_LOOKUP;
            }
        }
    }

    public static StrLookup mapLookup(Map paramMap) {
        return new MapStrLookup(paramMap);
    }

    public static StrLookup noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public abstract String lookup(String paramString);

    static class MapStrLookup
            extends StrLookup {
        private final Map map;

        MapStrLookup(Map paramMap) {
            this.map = paramMap;
        }

        public String lookup(String paramString) {
            if (this.map == null) {
            }
            do {
                return null;
                paramString = this.map.get(paramString);
            } while (paramString == null);
            return paramString.toString();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/text/StrLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */