package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.EBlendMode;
import com.everimaging.fotorsdk.algorithms.params.base.EBlendType;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSLayerBlendBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class u
        extends a {
    public static EBlendMode b(String paramString) {
        if (paramString.equals("normal")) {
            return EBlendMode.EBM_NORMAL;
        }
        if (paramString.equals("dissolve")) {
            return EBlendMode.EBM_DISSOLVE;
        }
        if (paramString.equals("darken")) {
            return EBlendMode.EBM_DARKEN;
        }
        if (paramString.equals("multiply")) {
            return EBlendMode.EBM_MULTIPLY;
        }
        if (paramString.equals("color_burn")) {
            return EBlendMode.EBM_COLOR_BURN;
        }
        if (paramString.equals("linear_burn")) {
            return EBlendMode.EBM_LINEAR_BURN;
        }
        if (paramString.equals("darker_color")) {
            return EBlendMode.EBM_DARKER_COLOR;
        }
        if (paramString.equals("lighten")) {
            return EBlendMode.EBM_LIGHTEN;
        }
        if (paramString.equals("screen")) {
            return EBlendMode.EBM_SCREEN;
        }
        if (paramString.equals("color_dodge")) {
            return EBlendMode.EBM_COLOR_DODGE;
        }
        if (paramString.equals("linear_dodge_add")) {
            return EBlendMode.EBM_LINEAR_DODGE_ADD;
        }
        if (paramString.equals("lighter_color")) {
            return EBlendMode.EBM_LIGHTER_COLOR;
        }
        if (paramString.equals("overlay")) {
            return EBlendMode.EBM_OVERLAY;
        }
        if (paramString.equals("soft_light")) {
            return EBlendMode.EBM_SOFT_LIGHT;
        }
        if (paramString.equals("hard_light")) {
            return EBlendMode.EBM_HARD_LIGHT;
        }
        if (paramString.equals("vivid_light")) {
            return EBlendMode.EBM_VIVID_LIGHT;
        }
        if (paramString.equals("linear_light")) {
            return EBlendMode.EBM_LINEAR_LIGHT;
        }
        if (paramString.equals("pin_light")) {
            return EBlendMode.EBM_PIN_LIGHT;
        }
        if (paramString.equals("hard_mix")) {
            return EBlendMode.EBM_HARD_MIX;
        }
        if (paramString.equals("difference")) {
            return EBlendMode.EBM_DIFFERENCE;
        }
        if (paramString.equals("exclusion")) {
            return EBlendMode.EBM_EXCLUSION;
        }
        if (paramString.equals("substract")) {
            return EBlendMode.EBM_SUBTRACT;
        }
        if (paramString.equals("divide")) {
            return EBlendMode.EBM_DIVIDE;
        }
        if (paramString.equals("hue")) {
            return EBlendMode.EBM_HUE;
        }
        if (paramString.equals("saturation")) {
            return EBlendMode.EBM_SATURATION;
        }
        if (paramString.equals("color")) {
            return EBlendMode.EBM_COLOR;
        }
        if (paramString.equals("luminosity")) {
            return EBlendMode.EBM_LUMINOSITY;
        }
        return null;
    }

    public EBlendType a(String paramString) {
        if (paramString.equals("stretch")) {
            return EBlendType.STRETCH;
        }
        if (paramString.equals("top_left")) {
            return EBlendType.TOP_LEFT;
        }
        if (paramString.equals("center")) {
            return EBlendType.CENTER;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSLayerBlendBaseFilterParams localRSLayerBlendBaseFilterParams = new RSLayerBlendBaseFilterParams();
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
                return localRSLayerBlendBaseFilterParams;
                if (!str.equals("mode")) {
                    break label151;
                }
                localRSLayerBlendBaseFilterParams.setMode(b(paramXmlPullParser.nextText()));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSLayerBlendBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("type")) {
                localRSLayerBlendBaseFilterParams.setType(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label151:
                if (str.equals("opacityTex")) {
                    localRSLayerBlendBaseFilterParams.setOpacityTex(c(paramXmlPullParser.nextText()));
                    j = i;
                } else {
                    j = i;
                    if (str.equals("opacity")) {
                        localRSLayerBlendBaseFilterParams.setOpacity(Float.parseFloat(paramXmlPullParser.nextText()));
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

    protected boolean c(String paramString) {
        if (paramString.equals("false")) {
        }
        while (!paramString.equals("true")) {
            return false;
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */