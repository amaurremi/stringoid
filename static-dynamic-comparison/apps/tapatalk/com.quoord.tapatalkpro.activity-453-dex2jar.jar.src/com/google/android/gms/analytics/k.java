package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

abstract class k<T extends j> {
    Context mContext;
    a<T> sy;

    public k(Context paramContext, a<T> parama) {
        this.mContext = paramContext;
        this.sy = parama;
    }

    private T a(XmlResourceParser paramXmlResourceParser) {
        for (; ; ) {
            try {
                paramXmlResourceParser.next();
                i = paramXmlResourceParser.getEventType();
                if (i == 1) {
                    continue;
                }
                if (paramXmlResourceParser.getEventType() == 2) {
                    str1 = paramXmlResourceParser.getName().toLowerCase();
                    if (!str1.equals("screenname")) {
                        continue;
                    }
                    str1 = paramXmlResourceParser.getAttributeValue(null, "name");
                    str2 = paramXmlResourceParser.nextText().trim();
                    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
                        this.sy.a(str1, str2);
                    }
                }
            } catch (XmlPullParserException paramXmlResourceParser) {
                aa.w("Error parsing tracker configuration file: " + paramXmlResourceParser);
                return this.sy.cg();
                if (!str1.equals("bool")) {
                    continue;
                }
                String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
                str1 = paramXmlResourceParser.nextText().trim();
                if (TextUtils.isEmpty(str2)) {
                    continue;
                }
                bool = TextUtils.isEmpty(str1);
                if (bool) {
                    continue;
                }
                try {
                    bool = Boolean.parseBoolean(str1);
                    this.sy.c(str2, bool);
                } catch (NumberFormatException localNumberFormatException1) {
                    aa.w("Error parsing bool configuration value: " + str1);
                }
                continue;
            } catch (IOException paramXmlResourceParser) {
                int i;
                aa.w("Error parsing tracker configuration file: " + paramXmlResourceParser);
                continue;
                if (!str1.equals("integer")) {
                    continue;
                }
                String str3 = paramXmlResourceParser.getAttributeValue(null, "name");
                String str1 = paramXmlResourceParser.nextText().trim();
                if (TextUtils.isEmpty(str3)) {
                    continue;
                }
                boolean bool = TextUtils.isEmpty(str1);
                if (bool) {
                    continue;
                }
                try {
                    i = Integer.parseInt(str1);
                    this.sy.a(str3, i);
                } catch (NumberFormatException localNumberFormatException2) {
                    aa.w("Error parsing int configuration value: " + str1);
                }
                continue;
            }
            i = paramXmlResourceParser.next();
            continue;
            if (!str1.equals("string")) {
                continue;
            }
            str1 = paramXmlResourceParser.getAttributeValue(null, "name");
            str2 = paramXmlResourceParser.nextText().trim();
            if ((!TextUtils.isEmpty(str1)) && (str2 != null)) {
                this.sy.b(str1, str2);
            }
        }
    }

    public T p(int paramInt) {
        try {
            j localj = a(this.mContext.getResources().getXml(paramInt));
            return localj;
        } catch (Resources.NotFoundException localNotFoundException) {
            aa.z("inflate() called with unknown resourceId: " + localNotFoundException);
        }
        return null;
    }

    public static abstract interface a<U extends j> {
        public abstract void a(String paramString, int paramInt);

        public abstract void a(String paramString1, String paramString2);

        public abstract void b(String paramString1, String paramString2);

        public abstract void c(String paramString, boolean paramBoolean);

        public abstract U cg();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */