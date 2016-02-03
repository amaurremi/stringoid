package com.everimaging.fotorsdk.algorithms.xml;

import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity;
import org.xmlpull.v1.XmlPullParser;

public class a {
    public static AllocationEntity a(XmlPullParser paramXmlPullParser) {
        AllocationEntity localAllocationEntity = new AllocationEntity();
        try {
            int j = paramXmlPullParser.getEventType();
            int i = 0;
            Object localObject = localAllocationEntity;
            if (j != 1) {
                localObject = localAllocationEntity;
                if (i == 0) {
                    localObject = paramXmlPullParser.getName();
                    switch (j) {
                    }
                    for (; ; ) {
                        int k = paramXmlPullParser.next();
                        i = j;
                        j = k;
                        break;
                        if ("Allocation".equals(localObject)) {
                            localAllocationEntity.setName(paramXmlPullParser.getAttributeValue(null, "name"));
                            j = i;
                        } else {
                            j = i;
                            if ("file".equals(localObject)) {
                                localAllocationEntity.setFile(paramXmlPullParser.nextText());
                                j = i;
                                continue;
                                boolean bool = "Allocation".equals(localObject);
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
            return (AllocationEntity) localObject;
        } catch (Exception paramXmlPullParser) {
            localObject = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/xml/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */