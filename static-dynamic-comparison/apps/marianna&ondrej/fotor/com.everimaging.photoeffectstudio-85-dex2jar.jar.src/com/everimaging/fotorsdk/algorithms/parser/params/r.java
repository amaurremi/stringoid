package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSHalfToneBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class r
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        int i = 0;
        RSHalfToneBaseFilterParams localRSHalfToneBaseFilterParams = new RSHalfToneBaseFilterParams();
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
                return localRSHalfToneBaseFilterParams;
                if (!((String) localObject).equals("amount")) {
                    break label178;
                }
                localRSHalfToneBaseFilterParams.setAmount(Integer.parseInt(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSHalfToneBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (((String) localObject).equals("gray")) {
                localObject = paramXmlPullParser.nextText();
                if (((String) localObject).equals("false")) {
                    localRSHalfToneBaseFilterParams.setGray(false);
                }
                j = i;
                if (((String) localObject).equals("true")) {
                    localRSHalfToneBaseFilterParams.setGray(true);
                    j = i;
                }
            } else {
                label178:
                if (((String) localObject).equals("halfToneColor0")) {
                    localObject = paramXmlPullParser.nextText().split(",", 3);
                    localRSHalfToneBaseFilterParams.setHalfToneColor0(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                    j = i;
                } else {
                    j = i;
                    if (((String) localObject).equals("halfToneColor1")) {
                        localObject = paramXmlPullParser.nextText().split(",", 3);
                        localRSHalfToneBaseFilterParams.setHalfToneColor1(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                        j = i;
                        continue;
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
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */