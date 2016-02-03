package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.ESmoothMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSSmoothBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ah
        extends a {
    protected ESmoothMode a(String paramString) {
        if (paramString.equals("mean")) {
            return ESmoothMode.MEAN;
        }
        if (paramString.equals("mean_gaussian")) {
            return ESmoothMode.MEAN_GAUSSIAN;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSSmoothBaseFilterParams localRSSmoothBaseFilterParams = new RSSmoothBaseFilterParams();
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
                return localRSSmoothBaseFilterParams;
                j = i;
                if (!str.equals("radius")) {
                    continue;
                }
                localRSSmoothBaseFilterParams.setRadius(Integer.parseInt(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSSmoothBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSSmoothBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */