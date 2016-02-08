package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

final class DisplayManagerJellybeanMr1 {
    public static Display getDisplay(Object paramObject, int paramInt) {
        return ((DisplayManager) paramObject).getDisplay(paramInt);
    }

    public static Object getDisplayManager(Context paramContext) {
        return paramContext.getSystemService("display");
    }

    public static Display[] getDisplays(Object paramObject) {
        return ((DisplayManager) paramObject).getDisplays();
    }

    public static Display[] getDisplays(Object paramObject, String paramString) {
        return ((DisplayManager) paramObject).getDisplays(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/hardware/display/DisplayManagerJellybeanMr1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */