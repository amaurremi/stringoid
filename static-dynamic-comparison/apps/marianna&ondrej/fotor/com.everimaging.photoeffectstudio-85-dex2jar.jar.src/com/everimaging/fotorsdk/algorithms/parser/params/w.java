package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSMascaraBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class w
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSMascaraBaseFilterParams localRSMascaraBaseFilterParams = new RSMascaraBaseFilterParams();
        int i = 0;
        for (; ; ) {
            try {
                j = paramXmlPullParser.getEventType();
                if ((j == 1) || (i != 0)) {
                    continue;
                }
                str = paramXmlPullParser.getName();
                switch (j) {
                }
            } catch (XmlPullParserException paramXmlPullParser) {
                String str;
                int k;
                paramXmlPullParser.printStackTrace();
                return localRSMascaraBaseFilterParams;
                boolean bool = str.equals("params");
                j = i;
                if (!bool) {
                    continue;
                }
                j = 1;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSMascaraBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            j = i;
            if (str.equals("radius")) {
                localRSMascaraBaseFilterParams.setRadius(Integer.parseInt(paramXmlPullParser.nextText()));
                j = i;
                continue;
                j = i;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */