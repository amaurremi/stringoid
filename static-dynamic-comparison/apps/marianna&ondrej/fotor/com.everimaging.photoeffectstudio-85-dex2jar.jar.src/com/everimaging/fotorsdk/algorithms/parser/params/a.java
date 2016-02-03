package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.EAnisotropicDiffusionMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSAnisotropicDiffusionBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
        extends com.everimaging.fotorsdk.algorithms.parser.a {
    public EAnisotropicDiffusionMode a(String paramString) {
        if (paramString.equals("EED")) {
            return EAnisotropicDiffusionMode.EDGE_ENHANCING_DIFFUSION;
        }
        if (paramString.equals("CED")) {
            return EAnisotropicDiffusionMode.COHERENCE_ENHANCING_DIFFUSION;
        }
        return null;
    }

    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        int i = 0;
        RSAnisotropicDiffusionBaseFilterParams localRSAnisotropicDiffusionBaseFilterParams = new RSAnisotropicDiffusionBaseFilterParams();
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
                return localRSAnisotropicDiffusionBaseFilterParams;
                if (!str.equals("gray")) {
                    break label179;
                }
                str = paramXmlPullParser.nextText();
                if (!str.equals("false")) {
                    continue;
                }
                localRSAnisotropicDiffusionBaseFilterParams.setGray(false);
                j = i;
                if (!str.equals("true")) {
                    continue;
                }
                localRSAnisotropicDiffusionBaseFilterParams.setGray(true);
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSAnisotropicDiffusionBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSAnisotropicDiffusionBaseFilterParams.setMode(a(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label179:
                if (str.equals("sigma")) {
                    localRSAnisotropicDiffusionBaseFilterParams.setSigma(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("rho")) {
                    localRSAnisotropicDiffusionBaseFilterParams.setRho(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("lambda")) {
                    localRSAnisotropicDiffusionBaseFilterParams.setLambda(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("C")) {
                    localRSAnisotropicDiffusionBaseFilterParams.setC(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("m")) {
                    localRSAnisotropicDiffusionBaseFilterParams.setM(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("alpha")) {
                    localRSAnisotropicDiffusionBaseFilterParams.setAlpha(Float.parseFloat(paramXmlPullParser.nextText()));
                    j = i;
                } else {
                    j = i;
                    if (str.equals("dt")) {
                        localRSAnisotropicDiffusionBaseFilterParams.setDt(Float.parseFloat(paramXmlPullParser.nextText()));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */