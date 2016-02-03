package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSWhiteBalanceBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class am
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSWhiteBalanceBaseFilterParams localRSWhiteBalanceBaseFilterParams = new RSWhiteBalanceBaseFilterParams();
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
                return localRSWhiteBalanceBaseFilterParams;
                j = i;
                if (!str.equals("tint")) {
                    continue;
                }
                localRSWhiteBalanceBaseFilterParams.setTint(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSWhiteBalanceBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("temperature")) {
                localRSWhiteBalanceBaseFilterParams.setTemperature(Float.parseFloat(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */