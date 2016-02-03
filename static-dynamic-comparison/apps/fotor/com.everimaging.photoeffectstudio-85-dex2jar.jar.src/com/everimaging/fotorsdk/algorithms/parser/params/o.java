package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSGradientColorBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class o
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        int i = 0;
        RSGradientColorBaseFilterParams localRSGradientColorBaseFilterParams = new RSGradientColorBaseFilterParams();
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
                return localRSGradientColorBaseFilterParams;
                if (!((String) localObject).equals("gradientColor0")) {
                    break label176;
                }
                localObject = paramXmlPullParser.nextText().split(",", 3);
                localRSGradientColorBaseFilterParams.setGradientColor0(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSGradientColorBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (((String) localObject).equals("ratio")) {
                localRSGradientColorBaseFilterParams.setRatio(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label176:
                if (((String) localObject).equals("gradientColor1")) {
                    localObject = paramXmlPullParser.nextText().split(",", 3);
                    localRSGradientColorBaseFilterParams.setGradientColor1(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                    j = i;
                } else if (((String) localObject).equals("gradientColor3")) {
                    localObject = paramXmlPullParser.nextText().split(",", 3);
                    localRSGradientColorBaseFilterParams.setGradientColor3(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                    j = i;
                } else if (((String) localObject).equals("gradientColor4")) {
                    localObject = paramXmlPullParser.nextText().split(",", 3);
                    localRSGradientColorBaseFilterParams.setGradientColor4(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                    j = i;
                } else {
                    j = i;
                    if (((String) localObject).equals("gradientColorDefault")) {
                        localObject = paramXmlPullParser.nextText().split(",", 3);
                        localRSGradientColorBaseFilterParams.setGradientColorDefault(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */