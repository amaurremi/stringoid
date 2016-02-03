package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.EHSLAdjustmentMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSHSLAdjustmentBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class p
        extends a {
    public EHSLAdjustmentMode a(String paramString) {
        if (paramString.equals("normal")) {
            return EHSLAdjustmentMode.NORMAL;
        }
        if (paramString.equals("hue")) {
            return EHSLAdjustmentMode.HUE;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSHSLAdjustmentBaseFilterParams localRSHSLAdjustmentBaseFilterParams = new RSHSLAdjustmentBaseFilterParams();
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
                return localRSHSLAdjustmentBaseFilterParams;
                if (!str.equals("saturation")) {
                    break label175;
                }
                localRSHSLAdjustmentBaseFilterParams.setSaturation(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSHSLAdjustmentBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSHSLAdjustmentBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
            }
            if (str.equals("hue")) {
                localRSHSLAdjustmentBaseFilterParams.setHue(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label175:
                j = i;
                if (str.equals("lightness")) {
                    localRSHSLAdjustmentBaseFilterParams.setLightness(Float.parseFloat(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */