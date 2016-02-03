package com.quoord.xmlrpc;

public class PrefixMap {
    public static final PrefixMap DEFAULT = new PrefixMap(null, "", "");
    String namespace;
    String prefix;
    PrefixMap previous;

    public PrefixMap(PrefixMap paramPrefixMap, String paramString1, String paramString2) {
        this.previous = paramPrefixMap;
        this.prefix = paramString1;
        this.namespace = paramString2;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getNamespace(String paramString) {
        Object localObject = this;
        PrefixMap localPrefixMap;
        do {
            if (paramString.equals(((PrefixMap) localObject).prefix)) {
                return ((PrefixMap) localObject).namespace;
            }
            localPrefixMap = ((PrefixMap) localObject).previous;
            localObject = localPrefixMap;
        } while (localPrefixMap != null);
        return null;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getPrefix(String paramString) {
        Object localObject = this;
        PrefixMap localPrefixMap;
        do {
            if ((paramString.equals(((PrefixMap) localObject).namespace)) && (paramString.equals(getNamespace(((PrefixMap) localObject).prefix)))) {
                return ((PrefixMap) localObject).prefix;
            }
            localPrefixMap = ((PrefixMap) localObject).previous;
            localObject = localPrefixMap;
        } while (localPrefixMap != null);
        return null;
    }

    public PrefixMap getPrevious() {
        return this.previous;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/PrefixMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */