package com.everimaging.fotorsdk.collage.utils;

import com.everimaging.fotorsdk.collage.painter.ICollagePainter;

import java.util.Comparator;

public class d
        implements Comparator<ICollagePainter> {
    public int a(ICollagePainter paramICollagePainter1, ICollagePainter paramICollagePainter2) {
        int j = paramICollagePainter1.d();
        int k = paramICollagePainter2.d();
        int i = 0;
        if (j < k) {
            i = -1;
        }
        while (j <= k) {
            return i;
        }
        return 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */