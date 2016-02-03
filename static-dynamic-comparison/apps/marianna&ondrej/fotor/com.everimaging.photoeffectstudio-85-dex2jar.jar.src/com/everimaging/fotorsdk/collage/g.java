package com.everimaging.fotorsdk.collage;

import android.util.SparseArray;
import com.everimaging.fotorsdk.collage.entity.ImageInfo;

import java.util.ArrayList;

public class g {
    private static g a;
    private SparseArray<ImageInfo> b = new SparseArray();

    public static g a() {
        if (a == null) {
            a = new g();
        }
        return a;
    }

    public void a(int paramInt) {
        this.b.remove(paramInt);
    }

    public void a(ImageInfo paramImageInfo, int paramInt) {
        this.b.put(paramInt, paramImageInfo);
    }

    public ImageInfo b(int paramInt) {
        return (ImageInfo) this.b.get(paramInt, null);
    }

    public void b() {
        this.b.clear();
    }

    public void c() {
        int j = this.b.size();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j) {
            localArrayList.add((ImageInfo) this.b.valueAt(i));
            i += 1;
        }
        this.b.clear();
        i = 0;
        while (i < localArrayList.size()) {
            this.b.put(i, localArrayList.get(i));
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */