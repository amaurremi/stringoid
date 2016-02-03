package com.everimaging.fotorsdk.collage.utils;

import android.graphics.PointF;

import java.util.ArrayList;

public class a {
    public static PointF a(PointF paramPointF1, PointF paramPointF2, float paramFloat) {
        PointF localPointF = new PointF();
        paramPointF1.x -= (paramPointF1.x - paramPointF2.x) * paramFloat;
        paramPointF1.y -= (paramPointF1.y - paramPointF2.y) * paramFloat;
        return localPointF;
    }

    public static ArrayList<PointF> a(PointF paramPointF1, PointF paramPointF2) {
        ArrayList localArrayList = new ArrayList();
        PointF localPointF;
        if (((paramPointF1.x < paramPointF2.x) && (paramPointF1.y < paramPointF2.y)) || ((paramPointF1.x > paramPointF2.x) && (paramPointF1.y > paramPointF2.y))) {
            localPointF = new PointF(paramPointF1.x + (paramPointF2.x - paramPointF1.x) * 0.551784F, paramPointF1.y);
        }
        for (paramPointF1 = new PointF(paramPointF2.x, paramPointF2.y + (paramPointF1.y - paramPointF2.y) * 0.551784F); ; paramPointF1 = new PointF(paramPointF2.x + (paramPointF1.x - paramPointF2.x) * 0.551784F, paramPointF2.y)) {
            localArrayList.add(localPointF);
            localArrayList.add(paramPointF1);
            localArrayList.add(paramPointF2);
            return localArrayList;
            localPointF = new PointF(paramPointF1.x, paramPointF1.y + (paramPointF2.y - paramPointF1.y) * 0.551784F);
        }
    }

    public static double b(PointF paramPointF1, PointF paramPointF2) {
        double d2 = Math.atan2(paramPointF2.y - paramPointF1.y, paramPointF2.x - paramPointF1.x);
        double d1 = d2;
        if (d2 < 0.0D) {
            d1 = d2 + 6.283185307179586D;
        }
        return d1;
    }

    public static float c(PointF paramPointF1, PointF paramPointF2) {
        float f2 = 0.0F;
        float f1 = f2;
        if (paramPointF1 != null) {
            f1 = f2;
            if (paramPointF2 != null) {
                f1 = (float) Math.sqrt(Math.pow(Math.abs(paramPointF1.x - paramPointF2.x), 2.0D) + Math.pow(Math.abs(paramPointF1.y - paramPointF2.y), 2.0D));
            }
        }
        return f1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */