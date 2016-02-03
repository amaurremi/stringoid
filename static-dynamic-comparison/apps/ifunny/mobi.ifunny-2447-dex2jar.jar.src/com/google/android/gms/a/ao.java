package com.google.android.gms.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

abstract class ao<T extends an> {
    Context a;
    ap<T> b;

    public ao(Context paramContext, ap<T> paramap) {
        this.a = paramContext;
        this.b = paramap;
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
                        this.b.a(str1, str2);
                    }
                }
            } catch (XmlPullParserException paramXmlResourceParser) {
                bt.a("Error parsing tracker configuration file: " + paramXmlResourceParser);
                return this.b.b();
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
                    this.b.a(str2, bool);
                } catch (NumberFormatException localNumberFormatException1) {
                    bt.a("Error parsing bool configuration value: " + str1);
                }
                continue;
            } catch (IOException paramXmlResourceParser) {
                int i;
                bt.a("Error parsing tracker configuration file: " + paramXmlResourceParser);
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
                    this.b.a(str3, i);
                } catch (NumberFormatException localNumberFormatException2) {
                    bt.a("Error parsing int configuration value: " + str1);
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
                this.b.b(str1, str2);
            }
        }
    }

    public T a(int paramInt) {
        try {
            an localan = a(this.a.getResources().getXml(paramInt));
            return localan;
        } catch (Resources.NotFoundException localNotFoundException) {
            bt.d("inflate() called with unknown resourceId: " + localNotFoundException);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */