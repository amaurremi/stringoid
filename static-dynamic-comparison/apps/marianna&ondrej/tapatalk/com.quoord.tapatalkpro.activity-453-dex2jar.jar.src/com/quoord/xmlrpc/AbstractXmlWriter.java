package com.quoord.xmlrpc;

import java.io.IOException;
import java.io.Writer;

public abstract class AbstractXmlWriter
        extends Writer {
    protected State current = new State(null, PrefixMap.DEFAULT, null);

    public abstract void attribute(String paramString1, String paramString2)
            throws IOException;

    public void attribute(String paramString1, String paramString2, String paramString3)
            throws IOException {
        if ((paramString1 == null) || ("".equals(paramString1))) {
            attribute(paramString2, paramString3);
            return;
        }
        String str2 = this.current.prefixMap.getPrefix(paramString1);
        String str1;
        int i;
        if (str2 != null) {
            str1 = str2;
            if (!str2.equals("")) {
            }
        } else {
            i = 0;
        }
        for (; ; ) {
            str1 = "p" + i;
            if (this.current.prefixMap.getNamespace(str1) == null) {
                this.current.prefixMap = new PrefixMap(this.current.prefixMap, str1, paramString1);
                attribute("xmlns:" + str1, paramString1);
                attribute(str1 + ":" + paramString2, paramString3);
                return;
            }
            i += 1;
        }
    }

    public abstract void endTag()
            throws IOException;

    public PrefixMap getPrefixMap() {
        return this.current.prefixMap;
    }

    protected abstract void startTag(PrefixMap paramPrefixMap, String paramString)
            throws IOException;

    public void startTag(PrefixMap paramPrefixMap, String paramString1, String paramString2)
            throws IOException {
        if (paramPrefixMap == null) {
            paramPrefixMap = this.current.prefixMap;
        }
        for (; ; ) {
            Object localObject = paramString1;
            if (paramString1 == null) {
                localObject = "";
            }
            paramString1 = paramPrefixMap.getPrefix((String) localObject);
            if (paramString1 == null) {
                paramPrefixMap = new PrefixMap(paramPrefixMap, "", (String) localObject);
                paramString1 = "";
            }
            for (; ; ) {
                label82:
                String str;
                if (paramString1.length() == 0) {
                    paramString1 = paramString2;
                    localObject = this.current.prefixMap;
                    startTag(paramPrefixMap, paramString1);
                    if (paramPrefixMap != localObject) {
                        paramString1 = paramPrefixMap;
                        paramString2 = paramString1.getPrefix();
                        str = paramString1.getNamespace();
                        if ((paramPrefixMap.getNamespace(paramString2).equals(str)) && (!str.equals(((PrefixMap) localObject).getNamespace(paramString2)))) {
                            if (!paramString2.equals("")) {
                                break label184;
                            }
                        }
                    }
                }
                label184:
                for (paramString2 = "xmlns"; ; paramString2 = "xmlns:" + paramString2) {
                    attribute(paramString2, str);
                    paramString2 = paramString1.getPrevious();
                    if (paramString2 != null) {
                        paramString1 = paramString2;
                        if (paramString2 != localObject) {
                            break label82;
                        }
                    }
                    return;
                    paramString1 = paramString1 + ':' + paramString2;
                    break;
                }
            }
        }
    }

    public void startTag(String paramString)
            throws IOException {
        startTag(null, "", paramString);
    }

    public void startTag(String paramString1, String paramString2)
            throws IOException {
        startTag(null, paramString1, paramString2);
    }

    public abstract void writeLegacy(int paramInt, String paramString)
            throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/AbstractXmlWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */