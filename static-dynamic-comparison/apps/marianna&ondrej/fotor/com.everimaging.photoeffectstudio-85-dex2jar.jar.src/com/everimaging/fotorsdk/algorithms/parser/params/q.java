package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.EHSVSaturation;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSHSVSaturationBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class q
        extends a {
    protected EHSVSaturation a(String paramString) {
        if (paramString.equals("normal")) {
            return EHSVSaturation.NORMAL;
        }
        if (paramString.equals("hue")) {
            return EHSVSaturation.HUE;
        }
        return EHSVSaturation.NORMAL;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSHSVSaturationBaseFilterParams localRSHSVSaturationBaseFilterParams = new RSHSVSaturationBaseFilterParams();
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
                return localRSHSVSaturationBaseFilterParams;
                if (!str.equals("red")) {
                    break label151;
                }
                localRSHSVSaturationBaseFilterParams.setRed(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSHSVSaturationBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSHSVSaturationBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label151:
                if (str.equals("yellow")) {
                    localRSHSVSaturationBaseFilterParams.setYellow(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("green")) {
                    localRSHSVSaturationBaseFilterParams.setGreen(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("cyan")) {
                    localRSHSVSaturationBaseFilterParams.setCyan(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("blue")) {
                    localRSHSVSaturationBaseFilterParams.setBlue(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else {
                    j = i;
                    if (str.equals("magenta")) {
                        localRSHSVSaturationBaseFilterParams.setMagenta(Float.parseFloat(paramXmlPullParser.nextText()));
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */