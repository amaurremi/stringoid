package com.everimaging.fotorsdk.collage.utils;

import android.graphics.Path;
import com.everimaging.fotorsdk.collage.entity.Polygon;
import com.everimaging.fotorsdk.collage.entity.SVGHole;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.plugins.h.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e {
    public static List<Path> a(Template paramTemplate, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3) {
        float f1 = 2.0F * paramFloat1;
        float f2 = paramFloat2 / 2.0F;
        float f3 = paramInt1;
        float f4 = paramInt2;
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = paramTemplate.getVertices();
        Iterator localIterator = paramTemplate.getPolygons().iterator();
        if (localIterator.hasNext()) {
            Polygon localPolygon = (Polygon) localIterator.next();
            paramTemplate = localPolygon.getMagicPath(localArrayList2, f3 - (f1 + paramFloat2), f4 - (f1 + paramFloat2));
            paramTemplate.a(f2 + paramFloat1, f2 + paramFloat1);
            paramTemplate = paramTemplate.c(-f2);
            if (paramFloat3 <= 0.0F) {
                break label164;
            }
            if (localPolygon.isRect(localArrayList2)) {
                paramTemplate = paramTemplate.a(paramFloat3);
            }
        }
        label164:
        for (; ; ) {
            localArrayList1.add(paramTemplate.a());
            break;
            paramTemplate = paramTemplate.b(paramFloat3);
            continue;
            return localArrayList1;
        }
    }

    public static List<Path> a(Template paramTemplate, h.a parama, float paramFloat) {
        ArrayList localArrayList = new ArrayList();
        Object localObject = paramTemplate.getSvgHoles();
        int i = paramTemplate.getOriginalWidth();
        int j = paramTemplate.getOriginalHeight();
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            localArrayList.add(((SVGHole) ((Iterator) localObject).next()).createAndroidPath(paramTemplate, paramFloat, parama, i, j, 0.0F));
        }
        return localArrayList;
    }

    public static List<Path> a(Template paramTemplate, h.a parama, float paramFloat1, float paramFloat2, float paramFloat3) {
        ArrayList localArrayList = new ArrayList();
        int i = paramTemplate.getOriginalWidth();
        int j = paramTemplate.getOriginalHeight();
        float f = Math.min(paramFloat1 / i, paramFloat2 / j);
        Iterator localIterator = paramTemplate.getSvgHoles().iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(((SVGHole) localIterator.next()).createAndroidPath(paramTemplate, f, parama, paramFloat1, paramFloat2, paramFloat3));
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */