package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSRedEyeRemoverBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ac
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        int i = 0;
        RSRedEyeRemoverBaseFilterParams localRSRedEyeRemoverBaseFilterParams = new RSRedEyeRemoverBaseFilterParams();
        for (; ; ) {
            Object localObject;
            try {
                j = paramXmlPullParser.getEventType();
                if ((j == 1) || (i != 0)) {
                    continue;
                }
                localObject = paramXmlPullParser.getName();
                switch (j) {
                }
            } catch (XmlPullParserException paramXmlPullParser) {
                int k;
                paramXmlPullParser.printStackTrace();
                return localRSRedEyeRemoverBaseFilterParams;
                j = i;
                if (!((String) localObject).equals("radius")) {
                    continue;
                }
                localRSRedEyeRemoverBaseFilterParams.setRadius(Integer.parseInt(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSRedEyeRemoverBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (((String) localObject).equals("center")) {
                localObject = paramXmlPullParser.nextText().split(",", 2);
                localRSRedEyeRemoverBaseFilterParams.setCenter(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]));
                j = i;
            } else {
                boolean bool = ((String) localObject).equals("params");
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */