package com.everimaging.fotorsdk.algorithms.xml;

import android.util.Xml;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity.Category;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

public class d {
    private static final String a = d.class.getSimpleName();
    private EffectEntity b;
    private XmlPullParser c = Xml.newPullParser();

    public EffectEntity a() {
        return this.b;
    }

    public void a(InputStream paramInputStream) {
        for (; ; ) {
            int i;
            int k;
            try {
                this.c.setInput(paramInputStream, "UTF-8");
                int j = this.c.getEventType();
                i = 0;
                if ((j != 1) && (i == 0)) {
                    paramInputStream = this.c.getName();
                    k = i;
                }
                switch (j) {
                    case 0:
                    case 1:
                        j = this.c.next();
                        i = k;
                        break;
                    case 2:
                        if ("Effect".equals(paramInputStream)) {
                            this.b = new EffectEntity();
                            paramInputStream = this.c.getAttributeValue(null, "name");
                            String str1 = this.c.getAttributeValue(null, "type");
                            String str2 = this.c.getAttributeValue(null, "id");
                            this.b.setCategory(EffectEntity.Category.FX);
                            this.b.setName(paramInputStream);
                            this.b.setID(Integer.valueOf(str2).intValue());
                            this.b.setType(str1);
                            k = i;
                            continue;
                            return;
                        }
                        break;
                }
            } catch (Exception paramInputStream) {
                this.b = null;
                paramInputStream.printStackTrace();
            }
            if ("Allocation".equals(paramInputStream)) {
                this.b.addAllocation(a.a(this.c));
                k = i;
            } else {
                k = i;
                if ("BaseFilter".equals(paramInputStream)) {
                    this.b.addFilter(b.a(this.c, this.b));
                    k = i;
                    continue;
                    boolean bool = "Effect".equals(paramInputStream);
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/xml/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */