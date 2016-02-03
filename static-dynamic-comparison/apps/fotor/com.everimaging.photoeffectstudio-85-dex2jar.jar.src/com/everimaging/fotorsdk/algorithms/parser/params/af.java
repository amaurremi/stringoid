package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.ESharpeningMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSSharpeningBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class af
        extends a {
    protected ESharpeningMode a(String paramString) {
        if (paramString.equals("simple")) {
            return ESharpeningMode.SIMPLE;
        }
        if (paramString.equals("mean")) {
            return ESharpeningMode.MEAN;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSSharpeningBaseFilterParams localRSSharpeningBaseFilterParams = new RSSharpeningBaseFilterParams();
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
                return localRSSharpeningBaseFilterParams;
                if (!str.equals("radius")) {
                    break label151;
                }
                localRSSharpeningBaseFilterParams.setRadius(Integer.parseInt(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSSharpeningBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSSharpeningBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label151:
                j = i;
                if (str.equals("sharpening")) {
                    localRSSharpeningBaseFilterParams.setSharpening(Float.parseFloat(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */