package com.everimaging.fotorsdk.algorithms.parser.params;

import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;
import com.everimaging.fotorsdk.algorithms.params.base.EFrameMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSFrameBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class m
        extends a {
    protected EFrameMode a(String paramString) {
        if (paramString.equals("M")) {
            return EFrameMode.M;
        }
        if (paramString.equals("S")) {
            return EFrameMode.S;
        }
        if (paramString.equals("N")) {
            return EFrameMode.N;
        }
        if (paramString.equals("coverskr")) {
            return EFrameMode.COVER_SKR;
        }
        if (paramString.equals("udcover")) {
            return EFrameMode.UD_COVER;
        }
        if (paramString.equals("lrcover")) {
            return EFrameMode.LR_COVER;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSFrameBaseFilterParams localRSFrameBaseFilterParams = new RSFrameBaseFilterParams();
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
                return localRSFrameBaseFilterParams;
                if (!str.equals("thickness")) {
                    break label165;
                }
                float f = Float.parseFloat(paramXmlPullParser.nextText());
                localRSFrameBaseFilterParams.setThickness(new Float2(f, f));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSFrameBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSFrameBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label165:
                if (str.equals("width")) {
                    localRSFrameBaseFilterParams.setWidth(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("height")) {
                    localRSFrameBaseFilterParams.setHeight(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else {
                    j = i;
                    if (str.equals("block")) {
                        a(localRSFrameBaseFilterParams, paramXmlPullParser.getAttributeValue(null, "type"), b(paramXmlPullParser));
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

    protected void a(RSFrameBaseFilterParams paramRSFrameBaseFilterParams, String paramString, Float4 paramFloat4) {
        if (paramString.equals("leftTop")) {
            paramRSFrameBaseFilterParams.setLeftTop(paramFloat4);
        }
        do {
            return;
            if (paramString.equals("top")) {
                paramRSFrameBaseFilterParams.setTop(paramFloat4);
                return;
            }
            if (paramString.equals("rightTop")) {
                paramRSFrameBaseFilterParams.setRightTop(paramFloat4);
                return;
            }
            if (paramString.equals("right")) {
                paramRSFrameBaseFilterParams.setRight(paramFloat4);
                return;
            }
            if (paramString.equals("rightBottom")) {
                paramRSFrameBaseFilterParams.setRightBottom(paramFloat4);
                return;
            }
            if (paramString.equals("bottom")) {
                paramRSFrameBaseFilterParams.setBottom(paramFloat4);
                return;
            }
            if (paramString.equals("leftBottom")) {
                paramRSFrameBaseFilterParams.setLeftBottom(paramFloat4);
                return;
            }
        } while (!paramString.equals("left"));
        paramRSFrameBaseFilterParams.setLeft(paramFloat4);
    }

    public Float4 b(XmlPullParser paramXmlPullParser) {
        Float4 localFloat4 = new Float4();
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
                return localFloat4;
                if (!str.equals("top")) {
                    break label150;
                }
                localFloat4.y = Float.parseFloat(paramXmlPullParser.nextText());
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localFloat4;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("left")) {
                localFloat4.x = Float.parseFloat(paramXmlPullParser.nextText());
                j = i;
            } else {
                label150:
                if (str.equals("width")) {
                    localFloat4.z = Float.parseFloat(paramXmlPullParser.nextText());
                    j = i;
                } else {
                    j = i;
                    if (str.equals("height")) {
                        localFloat4.w = Float.parseFloat(paramXmlPullParser.nextText());
                        j = i;
                        continue;
                        boolean bool = str.equals("block");
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */