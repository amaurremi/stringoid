package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.EVignetteMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSVignetteBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class al
        extends a {
    public EVignetteMode a(String paramString) {
        if (paramString.equals("linear")) {
            return EVignetteMode.LINEAR;
        }
        if (paramString.equals("quadric")) {
            return EVignetteMode.QUADRIC;
        }
        if (paramString.equals("color")) {
            return EVignetteMode.COLOR;
        }
        if (paramString.equals("vigblend")) {
            return EVignetteMode.VIGBLEND;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        int i = 0;
        RSVignetteBaseFilterParams localRSVignetteBaseFilterParams = new RSVignetteBaseFilterParams();
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
                return localRSVignetteBaseFilterParams;
                if (!((String) localObject).equals("blendMode")) {
                    break label162;
                }
                localRSVignetteBaseFilterParams.setBlendMode(u.b(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSVignetteBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (((String) localObject).equals("mode")) {
                localRSVignetteBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label162:
                if (((String) localObject).equals("vignetteStart")) {
                    localRSVignetteBaseFilterParams.setVignetteStart(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (((String) localObject).equals("vignetteRange")) {
                    localRSVignetteBaseFilterParams.setVignetteRange(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (((String) localObject).equals("amount")) {
                    localRSVignetteBaseFilterParams.setAmount(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (((String) localObject).equals("center")) {
                    localRSVignetteBaseFilterParams.setCenter(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (((String) localObject).equals("color")) {
                    localObject = paramXmlPullParser.nextText().split(",", 4);
                    float f8 = Float.parseFloat(localObject[0]);
                    float f7 = Float.parseFloat(localObject[1]);
                    float f6 = Float.parseFloat(localObject[2]);
                    float f5 = Float.parseFloat(localObject[3]);
                    float f4 = f5;
                    float f3 = f6;
                    float f2 = f7;
                    float f1 = f8;
                    if (f5 > 1.0F) {
                        f1 = f8 / 255.0F;
                        f2 = f7 / 255.0F;
                        f3 = f6 / 255.0F;
                        f4 = f5 / 255.0F;
                    }
                    localRSVignetteBaseFilterParams.setColor(f1, f2, f3, f4);
                    j = i;
                } else if (((String) localObject).equals("intensity")) {
                    localRSVignetteBaseFilterParams.setIntensity(Float.parseFloat(paramXmlPullParser.nextText()) / 100.0F);
                    j = i;
                } else if (((String) localObject).equals("vignette")) {
                    localObject = paramXmlPullParser.nextText().split(",", 2);
                    localRSVignetteBaseFilterParams.setVignette(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]));
                    j = i;
                } else if (((String) localObject).equals("vignetteCenter")) {
                    localObject = paramXmlPullParser.nextText().split(",", 2);
                    localRSVignetteBaseFilterParams.setVignetteCenter(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]));
                    j = i;
                } else {
                    j = i;
                    if (((String) localObject).equals("type")) {
                        localRSVignetteBaseFilterParams.setType(Integer.parseInt(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */