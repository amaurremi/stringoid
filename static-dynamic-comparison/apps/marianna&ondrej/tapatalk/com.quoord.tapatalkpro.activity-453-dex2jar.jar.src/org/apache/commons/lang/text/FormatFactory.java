package org.apache.commons.lang.text;

import java.text.Format;
import java.util.Locale;

public abstract interface FormatFactory {
    public abstract Format getFormat(String paramString1, String paramString2, Locale paramLocale);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/text/FormatFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */