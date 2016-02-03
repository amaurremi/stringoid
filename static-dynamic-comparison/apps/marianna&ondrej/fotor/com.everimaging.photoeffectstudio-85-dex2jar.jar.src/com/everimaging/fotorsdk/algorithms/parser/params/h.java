package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.EDifferenceBlendMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSDifferenceBlendBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class h
        extends a {
    protected EDifferenceBlendMode a(String paramString) {
        if (paramString.equals("bilateral")) {
            return EDifferenceBlendMode.BILATERAL;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSDifferenceBlendBaseFilterParams localRSDifferenceBlendBaseFilterParams = new RSDifferenceBlendBaseFilterParams();
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
                return localRSDifferenceBlendBaseFilterParams;
                j = i;
                if (!str.equals("sigma")) {
                    continue;
                }
                localRSDifferenceBlendBaseFilterParams.setSigma(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSDifferenceBlendBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSDifferenceBlendBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */