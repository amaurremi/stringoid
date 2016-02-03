package com.everimaging.fotorsdk.algorithms.xml;

import android.util.Xml;
import com.everimaging.fotorsdk.algorithms.parser.RSBaseFilterFactory.BaseFilter;
import com.everimaging.fotorsdk.algorithms.parser.b;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntity.AllocationType;
import com.everimaging.fotorsdk.algorithms.xml.entity.AllocationEntityBorders;
import com.everimaging.fotorsdk.algorithms.xml.entity.BaseFilterEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity.Category;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

public class c {
    private XmlPullParser a = Xml.newPullParser();
    private EffectEntity b;

    public EffectEntity a() {
        return this.b;
    }

    protected void a(AllocationEntityBorders paramAllocationEntityBorders, String paramString, AllocationEntity paramAllocationEntity) {
        if ("LeftTop".equals(paramString)) {
            paramAllocationEntityBorders.setLeftTop(paramAllocationEntity);
        }
        do {
            return;
            if ("Top".equals(paramString)) {
                paramAllocationEntityBorders.setTop(paramAllocationEntity);
                return;
            }
            if ("RightTop".equals(paramString)) {
                paramAllocationEntityBorders.setRightTop(paramAllocationEntity);
                return;
            }
            if ("Right".equals(paramString)) {
                paramAllocationEntityBorders.setRight(paramAllocationEntity);
                return;
            }
            if ("RightBottom".equals(paramString)) {
                paramAllocationEntityBorders.setRightBottom(paramAllocationEntity);
                return;
            }
            if ("Bottom".equals(paramString)) {
                paramAllocationEntityBorders.setBottom(paramAllocationEntity);
                return;
            }
            if ("LeftBottom".equals(paramString)) {
                paramAllocationEntityBorders.setLeftBottom(paramAllocationEntity);
                return;
            }
            if ("Left".equals(paramString)) {
                paramAllocationEntityBorders.setLeft(paramAllocationEntity);
                return;
            }
        } while (!"Unity".equals(paramString));
        paramAllocationEntityBorders.setUnity(paramAllocationEntity);
    }

    public void a(InputStream paramInputStream) {
        for (; ; ) {
            BaseFilterEntity localBaseFilterEntity;
            int i;
            String str1;
            int k;
            try {
                this.a.setInput(paramInputStream, "UTF-8");
                this.b = new EffectEntity();
                this.b.setCategory(EffectEntity.Category.FRAME);
                paramInputStream = new AllocationEntityBorders();
                localBaseFilterEntity = new BaseFilterEntity();
                localBaseFilterEntity.setBaseFilterType(RSBaseFilterFactory.BaseFilter.FRAME);
                localBaseFilterEntity.setBorder(paramInputStream);
                localBaseFilterEntity.setSrc(this.b.getAllocation("SRC"));
                localBaseFilterEntity.setDst(this.b.getAllocation("DST"));
                this.b.addFilter(localBaseFilterEntity);
                int j = this.a.getEventType();
                i = 0;
                if ((j != 1) && (i == 0)) {
                    str1 = this.a.getName();
                    k = i;
                }
                switch (j) {
                    case 0:
                    case 1:
                        j = this.a.next();
                        i = k;
                        break;
                    case 2:
                        if (str1.equals("Frame")) {
                            str1 = this.a.getAttributeValue(null, "name");
                            this.b.setName(str1);
                            str1 = this.a.getAttributeValue(null, "type");
                            this.b.setType(str1);
                            str1 = this.a.getAttributeValue(null, "id");
                            this.b.setID(Integer.valueOf(str1).intValue());
                            k = i;
                            continue;
                            return;
                        }
                        break;
                }
            } catch (Exception paramInputStream) {
                this.b = null;
            }
            if (a(str1)) {
                String str2 = this.a.nextText();
                AllocationEntity localAllocationEntity = new AllocationEntity();
                localAllocationEntity.setType(AllocationEntity.AllocationType.BORDER);
                localAllocationEntity.setName(str1);
                localAllocationEntity.setFile(str2);
                this.b.addAllocation(localAllocationEntity);
                a(paramInputStream, str1, localAllocationEntity);
                k = i;
            } else {
                k = i;
                if (str1.equals("params")) {
                    localBaseFilterEntity.setParams(b.a(localBaseFilterEntity.getFilterType(), this.a));
                    k = i;
                    continue;
                    boolean bool = str1.equals("Frame");
                    k = i;
                    if (bool) {
                        k = 1;
                        continue;
                        k = i;
                    }
                }
            }
        }
    }

    protected boolean a(String paramString) {
        return ("LeftTop".equals(paramString)) || ("Top".equals(paramString)) || ("RightTop".equals(paramString)) || ("Right".equals(paramString)) || ("RightBottom".equals(paramString)) || ("Bottom".equals(paramString)) || ("LeftBottom".equals(paramString)) || ("Left".equals(paramString)) || ("Unity".equals(paramString));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/xml/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */