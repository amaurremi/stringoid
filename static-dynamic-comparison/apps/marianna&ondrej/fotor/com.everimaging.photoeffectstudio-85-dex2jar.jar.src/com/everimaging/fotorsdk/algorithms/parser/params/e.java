package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSConstColorBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSConstColorBaseFilterParams localRSConstColorBaseFilterParams = new RSConstColorBaseFilterParams();
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
                return localRSConstColorBaseFilterParams;
                if (!str.equals("green")) {
                    break label150;
                }
                localRSConstColorBaseFilterParams.setGreen(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSConstColorBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("red")) {
                localRSConstColorBaseFilterParams.setRed(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label150:
                j = i;
                if (str.equals("blue")) {
                    localRSConstColorBaseFilterParams.setBlue(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                    continue;
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */