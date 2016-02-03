package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.ESaturationMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSSaturationBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ad
        extends a {
    protected ESaturationMode a(String paramString) {
        if (paramString.equals("simple")) {
            return ESaturationMode.SIMPLE;
        }
        if (paramString.equals("complex")) {
            return ESaturationMode.COMPLEX;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSSaturationBaseFilterParams localRSSaturationBaseFilterParams = new RSSaturationBaseFilterParams();
        int i = 0;
        for (; ; ) {
            String str;
            try {
                j = paramXmlPullParser.getEventType();
                if ((j == 1) || (i != 0)) {
                    continue;
                }
                str = paramXmlPullParser.getName();
                switch (j) {
                }
            } catch (XmlPullParserException paramXmlPullParser) {
                int k;
                paramXmlPullParser.printStackTrace();
                return localRSSaturationBaseFilterParams;
                j = i;
                if (!str.equals("saturation")) {
                    continue;
                }
                localRSSaturationBaseFilterParams.setSaturation(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSSaturationBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSSaturationBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                boolean bool = str.equals("params");
                j = i;
                if (bool) {
                    j = 1;
                    continue;
                    j = i;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */