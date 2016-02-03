package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.ECurveMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSCurveBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        RSCurveBaseFilterParams localRSCurveBaseFilterParams = new RSCurveBaseFilterParams();
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
                return localRSCurveBaseFilterParams;
                if (!str.equals("curveR")) {
                    break label149;
                }
                localRSCurveBaseFilterParams.setControlPointsR(a("curveR", paramXmlPullParser));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSCurveBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (str.equals("mode")) {
                localRSCurveBaseFilterParams.setMode(b(paramXmlPullParser.nextText()));
                j = i;
            } else {
                label149:
                if (str.equals("curveG")) {
                    localRSCurveBaseFilterParams.setControlPointsG(a("curveG", paramXmlPullParser));
                    j = i;
                } else if (str.equals("curveB")) {
                    localRSCurveBaseFilterParams.setControlPointsB(a("curveB", paramXmlPullParser));
                    j = i;
                } else if (str.equals("R")) {
                    localRSCurveBaseFilterParams.setControlPointsR(a(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("G")) {
                    localRSCurveBaseFilterParams.setControlPointsG(a(paramXmlPullParser.nextText()));
                    j = i;
                } else if (str.equals("B")) {
                    localRSCurveBaseFilterParams.setControlPointsB(a(paramXmlPullParser.nextText()));
                    j = i;
                } else {
                    j = i;
                    if (str.equals("RGB")) {
                        str = paramXmlPullParser.nextText();
                        localRSCurveBaseFilterParams.setControlPointsR(a(str));
                        localRSCurveBaseFilterParams.setControlPointsG(a(str));
                        localRSCurveBaseFilterParams.setControlPointsB(a(str));
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

    protected float[] a(String paramString) {
        paramString = paramString.replace("(", "").replace(")", ",").split(",");
        float[] arrayOfFloat = new float[paramString.length];
        int i = 0;
        while (i < paramString.length) {
            arrayOfFloat[i] = (Float.parseFloat(paramString[i]) / 255.0F);
            i += 1;
        }
        return arrayOfFloat;
    }

    protected float[] a(String paramString, XmlPullParser paramXmlPullParser) {
        ArrayList localArrayList = new ArrayList();
        for (; ; ) {
            try {
                j = paramXmlPullParser.getEventType();
                i = 0;
                if ((j == 1) || (i != 0)) {
                    continue;
                }
                localObject = paramXmlPullParser.getName();
                switch (j) {
                }
            } catch (XmlPullParserException paramString) {
                Object localObject;
                int k;
                float f1;
                float f2;
                paramString.printStackTrace();
                paramString = new float[localArrayList.size()];
                i = 0;
                if (i >= localArrayList.size()) {
                    break label255;
                }
                paramString[i] = ((Float) localArrayList.get(i)).floatValue();
                i += 1;
                continue;
                boolean bool = ((String) localObject).equals(paramString);
                j = i;
                if (!bool) {
                    continue;
                }
                j = 1;
                continue;
            } catch (IOException paramString) {
                paramString.printStackTrace();
                continue;
            }
            k = paramXmlPullParser.next();
            int i = j;
            int j = k;
            continue;
            j = i;
            if (((String) localObject).equals("point")) {
                localObject = paramXmlPullParser.nextText().split(",", 2);
                f1 = Float.parseFloat(localObject[0]) / 255.0F;
                f2 = Float.parseFloat(localObject[1]) / 255.0F;
                localArrayList.add(Float.valueOf(f1));
                localArrayList.add(Float.valueOf(f2));
                j = i;
                continue;
                label255:
                return paramString;
                j = i;
            }
        }
    }

    protected ECurveMode b(String paramString) {
        if (paramString.equals("reset")) {
            return ECurveMode.RESET_CURVE;
        }
        if (paramString.equals("generate")) {
            return ECurveMode.GEN_CURVE;
        }
        if (paramString.equals("merge")) {
            return ECurveMode.MERGE_CURVE;
        }
        if (paramString.equals("texturing")) {
            return ECurveMode.TEXTURING_CURVE;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */