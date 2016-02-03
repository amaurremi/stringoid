package com.everimaging.fotor.camera;

import android.hardware.Camera.Size;

import java.util.Comparator;

public class b
        implements Comparator<Camera.Size> {
    public int a(Camera.Size paramSize1, Camera.Size paramSize2) {
        if (paramSize1.width > paramSize2.width) {
        }
        do {
            return 1;
            if (paramSize1.width != paramSize2.width) {
                break;
            }
        } while (paramSize1.height > paramSize2.height);
        if (paramSize1.height == paramSize2.height) {
            return 0;
        }
        return -1;
        return -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */