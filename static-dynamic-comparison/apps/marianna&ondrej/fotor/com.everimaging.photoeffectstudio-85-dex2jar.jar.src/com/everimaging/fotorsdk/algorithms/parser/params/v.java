package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.ELevelMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSLevelBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class v
        extends a {
    public ELevelMode a(String paramString) {
        if (paramString.equals("Statistics")) {
            return ELevelMode.STATISTICS;
        }
        if (paramString.equals("GetScale")) {
            return ELevelMode.GET_SCALE;
        }
        if (paramString.equals("LevelSP")) {
            return ELevelMode.LEVEL_SP;
        }
        if (paramString.equals("Adobe")) {
            return ELevelMode.ADOBE;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSLevelBaseFilterParams localRSLevelBaseFilterParams = new RSLevelBaseFilterParams();
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
                return localRSLevelBaseFilterParams;
                if (!str.equals("dark")) {
                    break label151;
                }
                localRSLevelBaseFilterParams.setDark(Float.parseFloat(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSLevelBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("type")) {
                localRSLevelBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label151:
                if (str.equals("light")) {
                    localRSLevelBaseFilterParams.setLight(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("saturation")) {
                    localRSLevelBaseFilterParams.setSaturation(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else {
                    j = i;
                    if (str.equals("gamma")) {
                        localRSLevelBaseFilterParams.setGamma(Float.parseFloat(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */