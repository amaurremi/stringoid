package com.everimaging.fotorsdk.algorithms.parser.params;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSMultiplyMatrixPlusBiasBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.parser.a;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class z
        extends a {
    public RSBaseParams a(XmlPullParser paramXmlPullParser) {
        int i = 0;
        RSMultiplyMatrixPlusBiasBaseFilterParams localRSMultiplyMatrixPlusBiasBaseFilterParams = new RSMultiplyMatrixPlusBiasBaseFilterParams();
        localRSMultiplyMatrixPlusBiasBaseFilterParams.setVectorBias(0.0F, 0.0F, 0.0F);
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
                return localRSMultiplyMatrixPlusBiasBaseFilterParams;
                if (!((String) localObject).equals("vectorG")) {
                    break label210;
                }
                localObject = paramXmlPullParser.nextText().split(",", 3);
                localRSMultiplyMatrixPlusBiasBaseFilterParams.setVectorG(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                j = i;
                continue;
            } catch (IOException paramXmlPullParser) {
                paramXmlPullParser.printStackTrace();
                return localRSMultiplyMatrixPlusBiasBaseFilterParams;
            }
            k = paramXmlPullParser.next();
            i = j;
            int j = k;
            continue;
            if (((String) localObject).equals("vectorR")) {
                localObject = paramXmlPullParser.nextText().split(",", 3);
                localRSMultiplyMatrixPlusBiasBaseFilterParams.setVectorR(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                j = i;
            } else {
                label210:
                if (((String) localObject).equals("vectorB")) {
                    localObject = paramXmlPullParser.nextText().split(",", 3);
                    localRSMultiplyMatrixPlusBiasBaseFilterParams.setVectorB(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
                    j = i;
                } else {
                    j = i;
                    if (((String) localObject).equals("vectorBias")) {
                        localObject = paramXmlPullParser.nextText().split(",", 3);
                        localRSMultiplyMatrixPlusBiasBaseFilterParams.setVectorBias(Float.parseFloat(localObject[0]), Float.parseFloat(localObject[1]), Float.parseFloat(localObject[2]));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/params/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */